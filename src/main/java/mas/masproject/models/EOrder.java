package mas.masproject.models;

import mas.masproject.models.enums.EOrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "eorder")
public class EOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eOrderId;

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


    @ManyToMany
    @JoinTable(name = "product_eorder",
            joinColumns = @JoinColumn(name = "eorder_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull
    private Client client;

    @ManyToOne
    private Packer packer;

    public EOrder(LocalDateTime subDateTime, LocalDateTime finishDateTime, EOrderStatus status) {
        this.subDateTime = subDateTime;
        this.finishDateTime = finishDateTime;
        this.status = status;
    }

    public EOrder() {
    }


    //wyliczenie kosztu zamówienia
    public double calc(){
        double amount = 0;
        for (Product p : getProducts()) {
            amount+= p.getPrize();
        }

        return amount;
    }


    public long geteOrderId() {
        return eOrderId;
    }

    public void seteOrderId(long eOrderId) {
        this.eOrderId = eOrderId;
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

        if (client != null){
            client.addEOrder(this);
        }
    }

    public Packer getPacker() {
        return packer;
    }

    public void setPacker(Packer packer) {
        this.packer = packer;

        if (packer != null){
            packer.addEOrder(this);
        }
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
            productToAdd.addOrder(this);
        }
    }

    public void removeProduct(Product product){
        if (this.products.contains(product)){
            this.products.remove(product);
            product.removeEOrder(this);
        }
    }


    public void cancel(){
        this.setStatus(EOrderStatus.CANCELED);
        this.setFinishDateTime(LocalDateTime.now());
    }

    public void deleteEOrder(){
        // usunięcie wszystkich produktów - zerwanie więzów
        List<Product> pList = getProducts().stream().collect(Collectors.toList());
        for (Product p: pList) {
            removeProduct(p);
        }
        //zerwanie więzów z klientem
        client.removeEOrder(this);
        //oraz z pakowaczem
        if (packer != null){
            packer.removeEOrder(this);
        }

    }
}
