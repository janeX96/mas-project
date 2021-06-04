package mas.masproject.models;

import java.time.LocalDate;

public abstract class Employee extends Person {
    private int workYears;
    private static double maxBonus;

    public Employee(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public abstract double calcBonus();

    public int getWorkYears() {
        return workYears;
    }

    public void setWorkYears(int workYears) {
        this.workYears = workYears;
    }

    public static double getMaxBonus() {
        return maxBonus;
    }

    public static void setMaxBonus(double maxBonus) {
        Employee.maxBonus = maxBonus;
    }
}
