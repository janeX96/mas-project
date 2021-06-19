package mas.masproject.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "seller")
public class Seller extends Employee {

    //stała premia dla wszsytkich sprzedawców
    public static double bonus = 100;

    public Seller() {
    }

    public Seller(String firstName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, lastName, birthDate, hireDate);
    }

    @Override
    public double calcBonus() {
        return bonus;
    }
}
