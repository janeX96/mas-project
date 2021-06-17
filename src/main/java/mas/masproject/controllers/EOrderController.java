package mas.masproject.controllers;

import mas.masproject.dto.EOrderReadModel;
import mas.masproject.dto.ProductReadModel;
import mas.masproject.models.EOrder;
import mas.masproject.models.Instrument;
import mas.masproject.models.Product;
import mas.masproject.services.EOrderService;
import mas.masproject.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EOrderController {
    private EOrderService eOrderService;
    private ProductService productService;

    public EOrderController(EOrderService eOrderService, ProductService productService) {
        this.eOrderService = eOrderService;
        this.productService = productService;
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
        EOrderReadModel eOrderReadModel = new EOrderReadModel(eOrderService.findById(id));
        model.addAttribute("order", eOrderReadModel);

        return "pages/order-details";
    }




    @GetMapping("/orders")
    String orders(Model model){
        List<EOrder> orders = eOrderService.getAllEOrders();
        List<EOrderReadModel> readEOrders = orders.stream().map(EOrderReadModel::new).collect(Collectors.toList());

        Map<Long, List<String>> orderProductMap = new HashMap<>();

        //List<ProductReadModel> products = new ArrayList<>();

        for (EOrderReadModel o: readEOrders) {
                orderProductMap.put(o.getId(), o.getProducts().stream().map(p -> {return p.getName() +
                                                    ", " + p.getPrize() + ", " + p.getCount(); }).collect(Collectors.toList()));
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
