package mas.masproject.dto;

import mas.masproject.models.EOrder;
import mas.masproject.models.Packer;
import mas.masproject.models.Product;
import mas.masproject.models.enums.EOrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EOrderWriteModel {
    private long id;
    private long packerId;
//    private Packer packer;
    private String info;

    private List<Long> products = new ArrayList<>();

    public EOrderWriteModel(EOrder eOrder) {
        this.id = eOrder.geteOrderId();
    }

    public EOrderWriteModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPackerId() {
        return packerId;
    }

    public void setPackerId(long packerId) {
        this.packerId = packerId;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    //    public Packer getPacker() {
//        return packer;
//    }
//
//    public void setPacker(Packer packer) {
//        this.packer = packer;
//    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
