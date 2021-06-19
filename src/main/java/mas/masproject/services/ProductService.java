package mas.masproject.services;

import mas.masproject.models.Instrument;
import mas.masproject.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductService() {
    }


    @Transactional
    public Product addProduct(Product toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    @Transactional
    public Product update(Product toCreate){
        entityManager.merge(toCreate);
        return toCreate;
    }

    public List<Instrument> getAllInstruments() {
        return entityManager.createQuery("from Product where type = Instrument").getResultList();
    }


}
