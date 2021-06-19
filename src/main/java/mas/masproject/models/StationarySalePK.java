package mas.masproject.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StationarySalePK implements Serializable {
    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "product_id")
    private long productId;

}
