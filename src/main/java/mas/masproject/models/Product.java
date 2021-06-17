package mas.masproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prize")
    private double prize;

    @Column(name = "count")
    private int count;

    @Column(name = "type", insertable = false, updatable = false)
    public String type;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "product_eorder",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "eorder_id"))
    private Set<EOrder> eOrders = new HashSet<>();

    public Product(double prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public Product() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<EOrder> geteOrders() {
        return eOrders;
    }

    public void seteOrders(Set<EOrder> eOrders) {
        this.eOrders = eOrders;
    }

    public void addOrder(EOrder eOrder) {
        if (!eOrders.contains(eOrder)){
            eOrders.add(eOrder);
            eOrder.addProduct(this);
        }
    }
}
