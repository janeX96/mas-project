package mas.masproject.services;

import mas.masproject.models.Product;
import mas.masproject.models.Repair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Service
public class RepairService {
    @PersistenceContext
    private EntityManager entityManager;

    public RepairService() {
    }

    @Transactional
    public Repair save(Repair toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    @Transactional
    public Repair update(Repair toUpdate){
        entityManager.merge(toUpdate);
        return toUpdate;
    }
}
