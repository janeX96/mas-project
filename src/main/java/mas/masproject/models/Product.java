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

    @ManyToMany()
    @JoinTable(name = "product_eorder",
    joinColumns = @JoinColumn(name = "id_eorder"),
    inverseJoinColumns = @JoinColumn(name = "id_product"))
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
}
