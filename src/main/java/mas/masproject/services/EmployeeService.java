package mas.masproject.services;

import mas.masproject.models.Packer;
import mas.masproject.models.Seller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeService() {
    }


    public Packer save(Packer toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public Seller save(Seller toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }


    public List<Packer> getAllPackers() {
        return entityManager.createQuery("from Packer").getResultList();
    }

}
