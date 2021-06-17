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

        Client c = new Client("Jan","Kowalski", LocalDate.now(),"gdzies","234123234");
        personService.addClient(c);


        Instrument p1 = new Instrument(500,5,"gitara","yamaha",true);
        Product p2 = new Instrument(440,5,"gitara","yamaha",false);
        Product p3 = new Instrument(1700,2,"perkusja","yamaha",false);
        Product p4 = new Instrument(300,2,"Saksofon","yamaha",false);


        EOrder order = new EOrder(LocalDateTime.now(),null, EOrderStatus.NEW,c);
        order.addProduct(p1);
        Packer packer = new Packer("franek","nowy",LocalDate.now().minusYears(20),LocalDate.now().minusMonths(5));
        personService.addPacker(packer);
        order.setPacker(packer);
        eOrderService.addEOrder(order);


        EOrder order2 = new EOrder(LocalDateTime.now().minusDays(1),null, EOrderStatus.NEW,c);
        order2.addProduct(p2);
        //order2.addProduct(p3);
        eOrderService.addEOrder(order2);

        EOrder order3 = new EOrder(LocalDateTime.now().minusDays(5),null, EOrderStatus.NEW,c);
        order3.addProduct(p4);
        order3.addProduct(p3);
        eOrderService.addEOrder(order3);






    }
}