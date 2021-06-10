package mas.masproject.services;

import mas.masproject.models.Client;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonService() {
    }

    @Transactional
    public Client addClient(Client toCreate){
        entityManager.persist(toCreate);
        return toCreate;
    }

    public List<Client> getAllClients() {
        return entityManager.createQuery("from Client ").getResultList();
    }

}
