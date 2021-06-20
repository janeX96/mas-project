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

    @PostMapping("/order")
    String saveOrder(@ModelAttribute("eorder") EOrderWriteModel eOrderWriteModel, Model model){
        //towrzę nowe zamówienie
         EOrder eOrder = new EOrder();
         eOrder.setClient(personService.findClientById(1));
         eOrder.setStatus(EOrderStatus.NEW);
         eOrder.setSubDateTime(LocalDateTime.now());

          //dodaje do zamówienia produkty na podstawie pobranych kluczy
        for (Long id:eOrderWriteModel.getProducts()) {
            eOrder.addProduct(productService.findById(id));
        }

        eOrderService.save(eOrder);

        model.addAttribute("eorder", eOrder);

        return "pages/client-order";
    }

//    @PostMapping("/order/confirm")
//    String saveEOrder(@ModelAttribute("eorder") EOrder eOrder, Model model){
//
//        eOrderService.save(eOrder);
//
//        return "pages/client-confirmation";
//    }

    @GetMapping("/products")
    String products(Model model){
        List<Product> products = productService.getAllProducts();
        EOrderWriteModel eOrder = new EOrderWriteModel();

        model.addAttribute("products", products);
        model.addAttribute("eorder", eOrder);

        return "pages/client-products";
    }


}
