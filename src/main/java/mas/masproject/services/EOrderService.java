package mas.masproject.services;

import mas.masproject.models.EOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EOrderService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EOrder> getAllEOrders(){
        return entityManager.createQuery("from EOrder ").getResultList();
    }

    @Transactional
    public EOrder addEOrder(EOrder toCreate) {
        entityManager.persist(toCreate);
        return toCreate;
    }
}
