package mas.masproject.models;

import mas.masproject.models.enums.EOrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "eorder")
public class EOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "subDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private LocalDateTime subDateTime;

    @Column(name = "finishDateTime")
    private LocalDateTime finishDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    private EOrderStatus status;

    @Column(name = "shipmentInfo")
    private String shipmentInfo;

    @ManyToMany(mappedBy = "eOrders", cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull
    private Client client;

    @ManyToOne()
    private Packer packer;

    public EOrder(@NotNull LocalDateTime subDateTime, LocalDateTime finishDateTime,
                  @NotNull EOrderStatus status, @NotNull Client client) {
        this.subDateTime = subDateTime;
        this.finishDateTime = finishDateTime;
        this.status = status;
        this.client = client;
    }

    public EOrder() {
    }


    public double calc(){
        double amount = 0;
        for (Product p : getProducts()) {
            amount+= p.getPrize();
        }

        return amount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDateTime subDateTime) {
        this.subDateTime = subDateTime;
    }

    public LocalDateTime getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(LocalDateTime finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public EOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EOrderStatus status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Packer getPacker() {
        return packer;
    }

    public void setPacker(Packer packer) {
        this.packer = packer;
    }

    public String getShipmentInfo() {
        return shipmentInfo;
    }

    public void setShipmentInfo(String shipmentInfo) {
        this.shipmentInfo = shipmentInfo;
    }

    public void addProduct(Product productToAdd){
        if (!products.contains(productToAdd)){
            products.add(productToAdd);
            productToAdd.geteOrders().add(this);
        }
    }
}
