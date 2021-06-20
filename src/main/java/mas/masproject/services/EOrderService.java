package mas.masproject.services;

import mas.masproject.dto.EOrderReadModel;
import mas.masproject.dto.EOrderWriteModel;
import mas.masproject.models.EOrder;
import mas.masproject.models.Packer;
import mas.masproject.models.Product;
import mas.masproject.models.enums.EOrderStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EOrderService {

    @PersistenceContext
    private EntityManager entityManager;

    public EOrderService() {
    }

    public List<EOrder> getAllEOrders(){
        return entityManager.createQuery("from EOrder ").getResultList();
    }


    public EOrder save(EOrder toCreate) {
        entityManager.persist(toCreate);
        return toCreate;
    }


    public EOrder update(EOrder toUpdate) {
        entityManager.merge(toUpdate);
        return toUpdate;
    }

    public List<EOrder> getNewEOrders() {
        return entityManager.createQuery("from EOrder where status = 'NEW'").getResultList();
    }

    public EOrder findById(long order_id) {
        EOrder res = (EOrder)entityManager.createQuery("from EOrder where id = ?1").setParameter(1,order_id).getSingleResult();
        return res;
    }

    @Transactional
    public void updateEOrder(int id, Packer packer, String info) {
        EOrder order = findById(id);
        order.setPacker(packer);
        order.setShipmentInfo(info);
        order.setStatus(EOrderStatus.IN_PROGRESS);

        for (Product p: order.getProducts()) {
            p.setCount(p.getCount()-1);
        }
        entityManager.merge(order);
    }

    public List<EOrder> getEOrdersByStatus(EOrderStatus status) {
        return entityManager.createQuery("from EOrder where status =?1").setParameter(1,status).getResultList();
    }

    public void removeCanceledEOrders(){
        List<EOrder> canceledEOrders = entityManager.createQuery("from EOrder where status=?1").setParameter(1,EOrderStatus.CANCELED).getResultList();

        for (EOrder eOrder: canceledEOrders) {
            eOrder.deleteEOrder();
            entityManager.merge(eOrder);
            entityManager.remove(eOrder);
        }
    }
}
