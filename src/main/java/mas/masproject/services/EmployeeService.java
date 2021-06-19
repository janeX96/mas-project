package mas.masproject.services;

import mas.masproject.models.Packer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeService() {
    }

    @Transactional
    public Packer addPacker(Packer toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public List<Packer> getAllPackers() {
        return entityManager.createQuery("from Packer").getResultList();
    }

}
