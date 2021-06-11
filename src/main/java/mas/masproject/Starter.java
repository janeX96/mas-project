package mas.masproject;


import mas.masproject.models.*;
import mas.masproject.models.enums.EOrderStatus;
import mas.masproject.services.EOrderService;
import mas.masproject.services.PersonService;
import mas.masproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class Starter implements CommandLineRunner {

    @Autowired
    public EOrderService eOrderService = new EOrderService();
    @Autowired
    public PersonService personService = new PersonService();
    @Autowired
    public ProductService productService = new ProductService();

    @Override
    public void run(String... args) throws Exception {

        Client c = new Client("jan","abc", LocalDate.now(),"gdzies","234123234");
        personService.addClient(c);
        EOrder order = new EOrder(LocalDateTime.now(),null, EOrderStatus.NEW,c);
        //eOrderService.addEOrder(order);
        Instrument p1 = new Instrument(500,5,"gitara","yamaha",true);
        p1.setType("Instrument");
//        Product p2 = new Instrument(440,5,"gitara","yamaha",false);
//        Product p3 = new Instrument(800,5,"gitara","yamaha",true);

        productService.addProduct(p1);
        order.addProduct(p1);
//        order.addProduct(p2,2);
//        order.addProduct(p3,3);

        Packer packer = new Packer("franek","nowy",LocalDate.now().minusYears(20),LocalDate.now().minusMonths(5));
        personService.addPacker(packer);
        order.setPacker(packer);
        eOrderService.addEOrder(order);

    }
}