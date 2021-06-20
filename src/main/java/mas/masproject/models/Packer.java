package mas.masproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "packer")
public class Packer extends Employee{

    @OneToMany(mappedBy = "packer",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<EOrder> orders = new HashSet<>();

    public Packer() {
    }


    public Packer(String firstName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, lastName, birthDate, hireDate);
    }

    public void addEOrder(EOrder eOrder){
        if (!orders.contains(eOrder)){
            orders.add(eOrder);
            eOrder.setPacker(this);
        }
    }

    public Set<EOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<EOrder> orders) {
        this.orders = orders;
    }

    // premia wyliczana na zasadzie: [(liczba napraw z poprzedniego miesiąca) * 2] zł
    @Override
    public double calcBonus() {
        double bonus = getPrevMonthPackages() * 2;

        if (bonus>getMaxBonus()){
            return getMaxBonus();
        }

        return bonus;
    }

    //liczba paczek spakowanych w poprzednim miesiącu
    public int getPrevMonthPackages() {

        int count = this.orders
                        .stream()
                        .filter(o -> o.getFinishDateTime().getMonth() == LocalDate.now().minusMonths(1).getMonth())
                        .collect(Collectors.toList()).size();

        return count;
    }

    public void removeEOrder(EOrder eOrder) {
        if (this.orders.contains(eOrder)){
            this.orders.remove(eOrder);
            eOrder.setPacker(null);
        }
    }
}