package mas.masproject.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "packer")
public class Packer extends Employee{

    public Packer() {
    }

    public Packer(String firstName, String lastName, LocalDate hireDate) {
        super(firstName, lastName, hireDate);
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