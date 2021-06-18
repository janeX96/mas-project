package mas.masproject.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "packer")
public class Packer extends Employee{

    @OneToMany(mappedBy = "packer")
    private Set<EOrder> orders = new HashSet<>();

    public Packer() {
    }


    public Packer(String firstName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, lastName, birthDate, hireDate);
    }

    public Set<EOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<EOrder> orders) {
        this.orders = orders;
    }

    @Override
    public double calcBonus() {
        double bonus = getPrevMonthPackages() * 0.3;

        if (bonus>getMaxBonus()){
            return getMaxBonus();
        }

        return bonus;
    }

    public int getPrevMonthPackages() {
        // todo wyliczany z asocjiacji z zamówieniami
        return 0;
    }

}