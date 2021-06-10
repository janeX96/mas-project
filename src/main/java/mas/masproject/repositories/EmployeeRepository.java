package mas.masproject.repositories;

import mas.masproject.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {

    List<Employee> findAll();
}
