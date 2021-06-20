package mas.masproject.controllers;

import mas.masproject.dto.EOrderWriteModel;
import mas.masproject.models.EOrder;
import mas.masproject.models.Product;
import mas.masproject.models.enums.EOrderStatus;
import mas.masproject.services.EOrderService;
import mas.masproject.services.PersonService;
import mas.masproject.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("client")
public class ClientController {
    private EOrderService eOrderService;
    private ProductService productService;
    private PersonService personService;

    public ClientController(EOrderService eOrderService, ProductService productService, PersonService personService) {
        this.eOrderService = eOrderService;
        this.productService = productService;
        this.personService = personService;
    }

    @GetMapping("/index")
    String index(){
        return "pages/client-index";
    }


    @GetMapping("/products")
    String products(Model model){
        List<Product> products = productService.getAllProducts();
        EOrderWriteModel eOrder = new EOrderWriteModel();

        model.addAttribute("products", products);
        model.addAttribute("eorder", eOrder);

        return "pages/client-products";
    }


    @PostMapping("/order")
    String saveOrder(@ModelAttribute("eorder") EOrderWriteModel eOrderWriteModel, Model model){

        //sprawdzenie czy zamówienie nie jest puste
        if (eOrderWriteModel.getProducts().size() == 0){
            return "pages/client-empty-order-message";
        }

        //towrzenie nowego zamówienia
         EOrder eOrder = new EOrder();
         eOrder.setClient(personService.findClientById(1));
         eOrder.setStatus(EOrderStatus.NEW);
         eOrder.setSubDateTime(LocalDateTime.now());

          //dodanie do zamówienia produktów na podstawie pobranych kluczy
        for (Long id:eOrderWriteModel.getProducts()) {
            eOrder.addProduct(productService.findById(id));
        }

        //zapis do bazy
        eOrderService.save(eOrder);

        //zwrócone zostaje podsumowanie zamówienia
        model.addAttribute("eorder", eOrder);

        return "pages/client-order";
    }

}
