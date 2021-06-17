package mas.masproject.dto;

import mas.masproject.models.Instrument;
import mas.masproject.models.Product;

import javax.persistence.Column;

public class ProductReadModel {

    private long id;
    private double prize;
    private int count;
    public String type;
    private String name;
    private String producer;
    private boolean electronic;

    public ProductReadModel(Product product) {
        this.id = product.getId();
        this.count = product.getCount();
        this.prize = product.getPrize();
        this.type = product.getType();
     //   if (product.getType() == "Instrument"){
            this.electronic = ((Instrument)product).isElectronic();
            this.producer = ((Instrument)product).getProducer();
            this.name = ((Instrument)product).getName();
     //   }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "ProductReadModel{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
