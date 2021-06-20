package mas.masproject.controllers;

import mas.masproject.dto.EOrderReadModel;
import mas.masproject.dto.EOrderWriteModel;
import mas.masproject.dto.ProductReadModel;
import mas.masproject.models.EOrder;
import mas.masproject.models.Instrument;
import mas.masproject.models.Packer;
import mas.masproject.models.Product;
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
        eOrderService.updateEOrder(id, packer, toUpdate.getInfo());

        return "pages/confirmation";
    }



    @GetMapping("/orders")
    String orders(Model model){
        List<EOrder> orders = eOrderService.getEOrdersByStatus(EOrderStatus.IN_PROGRESS);
        List<EOrderReadModel> readEOrders = orders.stream().map(EOrderReadModel::new).collect(Collectors.toList());

        Map<Long, List<String>> orderProductMap = new HashMap<>();

        //List<ProductReadModel> products = new ArrayList<>();

        for (EOrderReadModel o: readEOrders) {
                orderProductMap.put(o.getId(), o.getProducts()
                                                .stream()
                                                .map(p -> { return p.toString(); }).collect(Collectors.toList()));
            }

//
//        Map<Long,String> productName = new HashMap<>();
//        for (int i = 0; i < orders.size(); i++) {
//            products.addAll(orders.get(i).getProducts());
//            List<Product> prods = List.copyOf(orders.get(i).getProducts());
//            for (int j = 0; j < prods.size(); j++) {
//                productName.put(prods.get(j).getId(), ((Instrument)prods.get(j)).getName());
//            }
//                orderProductMap.put(readEOrders.get(i).getId(), orders.get(i).getProducts().stream().map(Product::getId).collect(Collectors.toList()));
//        }

        model.addAttribute("orders", readEOrders);
        model.addAttribute("orders_products", orderProductMap);
//        model.addAttribute("products_names", productName);
//        model.addAttribute("products", products);
        return "pages/orders";

    }




}
