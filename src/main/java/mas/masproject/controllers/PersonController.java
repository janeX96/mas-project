package mas.masproject.controllers;

import mas.masproject.models.Client;
import mas.masproject.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Controller
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getClients(){

        return ResponseEntity.ok(service.getAllClients());
    }

    @PostMapping("/clients")
    ResponseEntity addClient(Client client){
        service.addClient(client);

        return ResponseEntity.ok().build();
    }
}
