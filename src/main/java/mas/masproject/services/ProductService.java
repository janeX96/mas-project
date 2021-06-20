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


    public Product addProduct(Product toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }


    public Product update(Product toCreate){
        entityManager.merge(toCreate);
        return toCreate;
    }

    public List<Product> getAllProducts() {
        return entityManager.createQuery("from Product").getResultList();
    }

    public List<Instrument> getAllInstruments() {
        return entityManager.createQuery("from Product where type = Instrument").getResultList();
    }

    public Product findById(long id){
        return (Product) entityManager.createQuery("from Product where id=?1").setParameter(1,id).getSingleResult();
    }


}
