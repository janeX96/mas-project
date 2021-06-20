package mas.masproject.controllers;

import mas.masproject.dto.EOrderReadModel;
import mas.masproject.dto.EOrderWriteModel;
import mas.masproject.models.EOrder;
import mas.masproject.models.Packer;
import mas.masproject.models.enums.EOrderStatus;
import mas.masproject.services.EOrderService;
import mas.masproject.services.PersonService;
import mas.masproject.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EOrderController {
    private EOrderService eOrderService;
    private ProductService productService;
    private PersonService personService;

    public EOrderController(EOrderService eOrderService, ProductService productService, PersonService personService) {
        this.eOrderService = eOrderService;
        this.productService = productService;
        this.personService = personService;
    }

    @GetMapping("/index")
    String index(){
        return "pages/index";
    }


    @GetMapping("/orders/list")
    public String getNewOrders(Model model){
        List<EOrderReadModel> orders = eOrderService.getNewEOrders().stream().map(EOrderReadModel::new).collect(Collectors.toList());
        model.addAttribute("orders", orders);
        return "pages/new-orders-list";
    }

    @GetMapping("/orders/order_details")
    public String getOrderDetails(@RequestParam("id") long id, Model model){
        EOrder eOrder = eOrderService.findById(id);
        model.addAttribute("order", eOrder);

        return "pages/order-details";
    }

    @GetMapping("/orders/shipment")
    public String shipmentForm(@RequestParam("id") long id, Model model){
        EOrder eOrder = eOrderService.findById(id);
        EOrderWriteModel orderWriteModel = new EOrderWriteModel(eOrder);
        List<Packer> packers = personService.getAllPackers();

        model.addAttribute("orderWriteModel",orderWriteModel);
        model.addAttribute("packers",packers);
        model.addAttribute("default","");

        return "pages/shipment-form";
    }


    @Transactional
    @PostMapping("orders/update/{id}")
    public String updateOrder(@PathVariable int id, @ModelAttribute EOrderWriteModel toUpdate, Model model){

        Packer packer = personService.findById(toUpdate.getPackerId());

        //aktualizacj zamówienia o dodatkowe informacje
        eOrderService.updateEOrder(id, packer, toUpdate.getInfo());

        return "pages/confirmation";
    }



    @GetMapping("/orders")
    String orders(Model model){
        List<EOrder> orders = eOrderService.getEOrdersByStatus(EOrderStatus.IN_PROGRESS);
        List<EOrderReadModel> readEOrders = orders.stream().map(EOrderReadModel::new).collect(Collectors.toList());

        Map<Long, List<String>> orderProductMap = new HashMap<>();

        for (EOrderReadModel o: readEOrders) {
                orderProductMap.put(o.getId(), o.getProducts()
                                                .stream()
                                                .map(p -> { return p.toString(); }).collect(Collectors.toList()));
            }


        model.addAttribute("orders", readEOrders);
        model.addAttribute("orders_products", orderProductMap);

        return "pages/orders";

    }

}
