package mas.masproject.rest_controllers;

import mas.masproject.dto.EOrderReadModel;
import mas.masproject.models.EOrder;
import mas.masproject.services.EOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EOrderRestController {

    private EOrderService eOrderService;

    public EOrderRestController(EOrderService eOrderService) {
        this.eOrderService = eOrderService;
    }

    @GetMapping("/eorders")
    ResponseEntity<List<EOrder>> getAllEOrders(){

        return ResponseEntity.ok(eOrderService.getAllEOrders());
    }

    @GetMapping("/new_eorders")
    ResponseEntity<List<EOrderReadModel>> getNewEOrders(){

        return ResponseEntity.ok(eOrderService.getNewEOrders().stream().map(EOrderReadModel::new).collect(Collectors.toList()));
    }

    @PostMapping("/eorders")
    ResponseEntity<EOrder> addEOrder(@RequestBody EOrder eOrder){
        EOrder res = eOrderService.addEOrder(eOrder);

        return ResponseEntity.ok(res);
    }

}
