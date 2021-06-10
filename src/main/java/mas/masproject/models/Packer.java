package mas.masproject.models;

import java.time.LocalDate;

public class Packer extends Employee{
    private int prevMonthPackages;

    public Packer() {
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