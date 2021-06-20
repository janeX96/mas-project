package mas.masproject.services;

import mas.masproject.models.Client;
import mas.masproject.models.Packer;
import mas.masproject.models.Person;
import mas.masproject.models.Seller;
import mas.masproject.repositories.ClientRepository;
import mas.masproject.repositories.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;


    public PersonService() {
    }

    public Person save(Person toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }


    public Person update(Person toUpdate){
        entityManager.merge(toUpdate);
        return toUpdate;
    }


    @Transactional
    public Client addClient(Client toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public List<Client> getAllClients() {
        return entityManager.createQuery("from Client ").getResultList();
    }

    @Transactional
    public Packer addPacker(Packer toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public List<Packer> getAllPackers() {
        return entityManager.createQuery("from Packer").getResultList();
    }

    public Packer findById(long id) {
       return (Packer)entityManager.createQuery("from Packer where id=?1").setParameter(1,id).getSingleResult();
    }

    public Client findClientById(long id) {
        return (Client)entityManager.createQuery("from Client where id=?1").setParameter(1,id).getSingleResult();
    }
}
