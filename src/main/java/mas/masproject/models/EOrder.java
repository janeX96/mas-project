package mas.masproject.models;

import mas.masproject.models.enums.EOrderStatus;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "eorder")
public class EOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "subDateTime")
    private LocalDateTime subDateTime;

    @Column(name = "finishDateTime")
    private LocalDateTime finishDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EOrderStatus status;

    @ManyToMany(mappedBy = "eOrders")
    private Set<Product> products = new HashSet<>();

    public EOrder(LocalDateTime subDateTime, LocalDateTime finishDateTime, EOrderStatus status) {
        this.subDateTime = subDateTime;
        this.finishDateTime = finishDateTime;
        this.status = status;
    }

    public EOrder() {
    }

    //todo
    public double calc(){
        return 0;
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
}
