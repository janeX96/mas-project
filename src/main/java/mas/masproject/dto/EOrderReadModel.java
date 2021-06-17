package mas.masproject.dto;

import mas.masproject.models.Client;
import mas.masproject.models.EOrder;
import mas.masproject.models.Packer;
import mas.masproject.models.Product;
import mas.masproject.models.enums.EOrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EOrderReadModel {
    private long id;

    private LocalDateTime subDateTime;

    private LocalDateTime finishDateTime;

    private EOrderStatus status;

    private Set<ProductReadModel> products = new HashSet<>();

    private ClientReadModel client;

   // private PackerReadModel packer;

    public EOrderReadModel(EOrder eOrder) {
        this.id = eOrder.getId();
        this.client = new ClientReadModel(eOrder.getClient());
        this.finishDateTime = eOrder.getFinishDateTime();
       // this.packer = new PackerReadModel(eOrder.getPacker());
        this.status = eOrder.getStatus();
        //this.products = eOrder.getProducts().stream().map(ProductReadModel::new).collect(Collectors.toSet());
        for (Product p: eOrder.getProducts()) {
            this.products.add(new ProductReadModel(p));
        }
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

    public Set<ProductReadModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductReadModel> products) {
        this.products = products;
    }

    public ClientReadModel getClient() {
        return client;
    }

    public void setClient(ClientReadModel client) {
        this.client = client;
    }

//    public PackerReadModel getPacker() {
//        return packer;
//    }
//
//    public void setPacker(PackerReadModel packer) {
//        this.packer = packer;
//    }
}
