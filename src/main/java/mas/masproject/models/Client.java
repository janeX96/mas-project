package mas.masproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends Person {

    @Size(min=2, max=70, message = "Pole powinno zawierać 2-70 znaków")
    @NotBlank(message = "Pole wymagane")
    @Column(name = "address")
    private String address;

    @Pattern(regexp = "^\\d{9}$", message = "Podaj poprawny numer telefonu")
    @NotBlank(message = "Pole wymagane")
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<EOrder> orders = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Repair> repairs = new HashSet<>();

    public Client() {

    }

    public Client(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber) {
        super(firstName, lastName, birthDate);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<EOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<EOrder> orders) {
        this.orders = orders;
    }

    public void addEOrder(EOrder eOrder) {
        if (!orders.contains(eOrder)){
            orders.add(eOrder);
            eOrder.setClient(this);
        }
    }

    public void addRepair(Instrument instrument, Luthier luthier){
        Repair repair = new Repair(luthier,instrument,this);
        this.repairs.add(repair);
        instrument.addRepair(repair);
        luthier.addRepair(repair);
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public void removeEOrder(EOrder eOrder) {
        if (this.orders.contains(eOrder)){
            orders.remove(eOrder);
            eOrder.setClient(null);
        }
    }
}
