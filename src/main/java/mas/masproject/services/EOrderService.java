package mas.masproject.services;

import mas.masproject.models.EOrder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EOrderService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EOrder> getAllOrders(){
        return entityManager.createQuery("from EOrder ").getResultList();
    }

}
