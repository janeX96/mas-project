package mas.masproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @Override
    public double calcBonus() {
        return 0;
    }

    public int getPrevMonthRepairs() {
        return 0;
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
