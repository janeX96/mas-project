package mas.masproject.models;

import javax.persistence.*;

@Entity
@Table(name = "instrument")
public class Instrument extends Product {

    @Column(name = "name")
    private String name;
    @Column(name = "producer")
    private String producer;
    @Column(name = "electronic")
    private boolean electronic;



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

}
