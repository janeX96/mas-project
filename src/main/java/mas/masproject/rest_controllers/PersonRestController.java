package mas.masproject.rest_controllers;

import mas.masproject.models.Client;
import mas.masproject.models.Packer;
import mas.masproject.services.EmployeeService;
import mas.masproject.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService service;
    private final EmployeeService employeeService;

    public PersonRestController(PersonService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getClients(){

        return ResponseEntity.ok(service.getAllClients());
    }

    @PostMapping("/clients")
    ResponseEntity<Client> addClient(@RequestBody Client client){
        Client res = service.addClient(client);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/packers")
    ResponseEntity<List<Packer>> getPackers(){

        return ResponseEntity.ok(service.getAllPackers());
    }

    @PostMapping("/packers")
    ResponseEntity<Packer> addPacker(@RequestBody Packer packer){
        Packer res = service.addPacker(packer);

        return ResponseEntity.ok(res);
    }
}
