package mas.masproject.repositories;

import mas.masproject.models.Client;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {

    List<Client> findAll();
}
