package mas.masproject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "prize")
    private double prize;

    @Column(name = "count")
    private int count;

    @Column(name = "type", insertable = false, updatable = false)
    public String type;


    @ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<EOrder> eOrders = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StationarySale> stationarySales = new HashSet<>();


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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public Set<StationarySale> getStationarySales() {
        return stationarySales;
    }

    public void setStationarySales(Set<StationarySale> stationarySales) {
        this.stationarySales = stationarySales;
    }

    //połączenie z zamówieniem
    public void addOrder(EOrder eOrder) {
        if (!eOrders.contains(eOrder)){
            eOrders.add(eOrder);
            eOrder.addProduct(this);
        }
    }

    //połączenie ze sprzedażą stacjonarną
    public void addStationarySale(Seller seller){
        StationarySale stationarySale = new StationarySale(seller,this);
        this.stationarySales.add(stationarySale);
        seller.addStationarySale(stationarySale);
    }

    //połączenie ze sprzedażą stacjonarną (w przypadku od drugiej strony)
    public void addStationarySale(StationarySale stationarySale) {
        this.stationarySales.add(stationarySale);
    }

    //usunięcie z zamówienia (w przypadku jego usuwania)
    public void removeEOrder(EOrder eOrder) {
        if (this.eOrders.contains(eOrder)){
            this.eOrders.remove(eOrder);
            eOrder.removeProduct(this);
        }
    }
}
