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

        Packer packer = new Packer("franek","nowy",LocalDate.now().minusYears(20),LocalDate.now().minusMonths(5));
        personService.addPacker(packer);

        Instrument p1 = new Instrument(500,5,"gitara","yamaha",true);
        Product p2 = new Instrument(440,5,"gitara","yamaha",false);
        Product p3 = new Instrument(1700,2,"perkusja","yamaha",false);
        Product p4 = new Instrument(300,2,"Saksofon","yamaha",false);

        productService.addProduct(p1);
        productService.addProduct(p2);
        productService.addProduct(p3);
        productService.addProduct(p4);

        EOrder order = new EOrder(LocalDateTime.now(),null, EOrderStatus.NEW);
        order.setClient(c);
        eOrderService.save(order);

        order.addProduct(p1);
        order.addProduct(p2);
        eOrderService.update(order);


        EOrder order2 = new EOrder(LocalDateTime.now().minusDays(1),null, EOrderStatus.NEW);
        order2.setClient(c);
        eOrderService.save(order2);

        order2.addProduct(p1);
        order2.addProduct(p3);
        order2.addProduct(p4);
        eOrderService.update(order2);


        EOrder order3 = new EOrder(LocalDateTime.now().minusDays(5),null, EOrderStatus.NEW);
        order3.setClient(c);

        order3.addProduct(p2);
        order3.addProduct(p3);
        order3.addProduct(p4);

        eOrderService.save(order3);

        Seller seller1 = new Seller("Andrzej", "Nowak",LocalDate.now().minusYears(22), LocalDate.now().minusYears(2));
        personService.save(seller1);

        seller1.addStationarySale(p1);
        seller1.addStationarySale(p3);

        personService.update(seller1);
    }
}