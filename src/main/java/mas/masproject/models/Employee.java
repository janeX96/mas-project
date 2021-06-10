package mas.masproject.models;

import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee extends Person {

    @Column(name = "hireDate")
    private LocalDate hireDate;

    private static double maxBonus;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public abstract double calcBonus();

    public static double getMaxBonus() {
        return maxBonus;
    }

    public static void setMaxBonus(double maxBonus) {
        Employee.maxBonus = maxBonus;
    }


}
