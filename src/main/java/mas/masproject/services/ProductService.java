package mas.masproject.services;

import mas.masproject.models.Instrument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Instrument addStringed(Instrument toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public List<Instrument> getAllStringedInstruments() {
        return entityManager.createQuery("from Product where type = Instrument").getResultList();
    }


}
