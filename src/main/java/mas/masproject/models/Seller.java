package mas.masproject.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seller")
public class Seller extends Employee {

    //stała premia dla wszsytkich sprzedawców
    public static double bonus = 100;

    @OneToMany(mappedBy = "seller", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StationarySale> stationarySales = new HashSet<>();

    public Seller() {
    }

    public Seller(String firstName, String lastName, LocalDate birthDate, LocalDate hireDate) {
        super(firstName, lastName, birthDate, hireDate);
    }

    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        Seller.bonus = bonus;
    }

    public Set<StationarySale> getStationarySales() {
        return stationarySales;
    }

    public void setStationarySales(Set<StationarySale> stationarySales) {
        this.stationarySales = stationarySales;
    }

    @Override
    public double calcBonus() {
        return getBonus();
    }

    public void addStationarySale(StationarySale stationarySale) {
        this.stationarySales.add(stationarySale);
    }

    //dodanie sprzedaży stacjonarnej
    public void addStationarySale(Product product) {
        StationarySale stationarySale = new StationarySale(this, product);
        this.stationarySales.add(stationarySale);
        product.addStationarySale(stationarySale);
    }

}
