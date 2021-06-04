package mas.masproject.models;

import java.time.LocalDate;

public class Packer extends Employee{
    private int prevMonthPackages;

    public Packer(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    @Override
    public double calcBonus() {
        double bonus = prevMonthPackages * 0.3;

        if (bonus>getMaxBonus()){
            return getMaxBonus();
        }

        return bonus;
    }
}