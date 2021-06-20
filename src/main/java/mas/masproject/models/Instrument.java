package mas.masproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instrument")
public class Instrument extends Product {

    @Column(name = "name")
    private String name;
    @Column(name = "producer")
    private String producer;
    @Column(name = "electronic")
    private boolean electronic;

    @OneToMany(mappedBy = "instrument", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Repair> repairs = new HashSet<>();


    public Instrument() {

    }

    public Instrument(double prize, int count, String name, String producer, boolean electronic) {
        super(prize, count);
        this.name = name;
        this.producer = producer;
        this.electronic = electronic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isElectronic() {
        return electronic;
    }

    public void setElectronic(boolean electronic) {
        this.electronic = electronic;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return  name +
                ", producent: " + producer;
    }

    public void addRepair(Luthier luthier, Client client){
        Repair repair = new Repair(luthier,this, client);
        this.repairs.add(repair);
        luthier.addRepair(repair);
        client.addRepair(repair);
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
