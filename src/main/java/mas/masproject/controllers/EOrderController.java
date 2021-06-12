package mas.masproject.controllers;

import mas.masproject.services.EOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EOrderController {
    private EOrderService eOrderService;

    public EOrderController(EOrderService eOrderService) {
        this.eOrderService = eOrderService;
    }

    @GetMapping("/index")
    String index(){

        return "pages/index";
    }


}
