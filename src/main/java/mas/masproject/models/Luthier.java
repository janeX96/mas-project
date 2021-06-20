package mas.masproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "luthier")
public class Luthier extends Employee {


    @OneToMany(mappedBy = "luthier", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Repair> repairs = new HashSet<>();


    public Luthier() {
    }

    public Luthier(String firstName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, lastName, birthDate, hireDate);
    }

    //premia wyliczana w sposób: [(liczba napraw z poprzedniego miesiąca) * 2] zł
    @Override
    public double calcBonus() {
        double bonus = getPrevMonthRepairs() * 2;

        if (bonus>getMaxBonus()){
            return getMaxBonus();
        }

        return bonus;
    }

    // wyliczenie ilości napraw z poprzedniego miesiąca
    public int getPrevMonthRepairs() {
        int count = this.repairs
                .stream()
                .filter(r -> r.getFinishDateTime().getMonth() == LocalDate.now().minusMonths(1).getMonth())
                .collect(Collectors.toList()).size();

        return count;
    }

    public Repair addRepair(Instrument instrument, Client client){
        Repair repair = new Repair(this,instrument,client);
        this.repairs.add(repair);
        instrument.addRepair(repair);
        client.addRepair(repair);

        return repair;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
