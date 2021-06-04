package mas.masproject.models;

public abstract class Instrument extends Product {

    private String name;
    private String producer;
    private boolean electronic;

    public Instrument(double prize, String name, String producer, boolean electronic) {
        super(prize);
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
