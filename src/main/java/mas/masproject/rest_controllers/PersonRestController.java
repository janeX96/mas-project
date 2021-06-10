package mas.masproject.rest_controllers;

import mas.masproject.models.Client;
import mas.masproject.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService service;

    public PersonRestController(PersonService service) {
        this.service = service;
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
}
