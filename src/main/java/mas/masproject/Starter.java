package mas.masproject;


import mas.masproject.models.*;
import mas.masproject.models.enums.AlbumType;
import mas.masproject.models.enums.EOrderStatus;
import mas.masproject.services.EOrderService;
import mas.masproject.services.PersonService;
import mas.masproject.services.ProductService;
import mas.masproject.services.RepairService;
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
    @Autowired
    public RepairService repairService = new RepairService();

    @Override
    public void run(String... args) throws Exception {

//        Client c = new Client("Jan","Kowalski", LocalDate.now(),"Warszawa, ul. Kolejnowa 22","234123234");
//        personService.addClient(c);
//
//        Client c2 = new Client("Andrzej","Nowak", LocalDate.now(),"Kraków, ul. Wawelska 17a","234123234");
//        personService.addClient(c2);
//
//        Packer packer = new Packer("Antoni","Sobczyk",LocalDate.now().minusYears(20),LocalDate.now().minusMonths(5));
//        personService.addPacker(packer);
//
//        Packer packer2 = new Packer("Michał","Sek",LocalDate.now().minusYears(32),LocalDate.now().minusMonths(10));
//        personService.addPacker(packer2);
//
//        Packer packer3 = new Packer("Aleksander","Remont",LocalDate.now().minusYears(24),LocalDate.now().minusMonths(9));
//        personService.addPacker(packer3);
//
//        Instrument p1 = new Instrument(500,5,"gitara elektr.","yamaha",true);
//        Product p2 = new Instrument(440,5,"gitara basowa","yamaha",true);
//        Product p3 = new Instrument(1700,2,"perkusja","yamaha",false);
//        Product p4 = new Instrument(300,2,"Saksofon","yamaha",false);
//        Product p5 = new MusicAlbum(80,10,"Rammstein","Rammstein",2019, 160, AlbumType.CD);
//        Product p6 = new MusicAlbum(80,5,"Appetite for Destruction","Guns N' Roses",1987, 120, AlbumType.VINYL);
//        Product p7 = new MusicAlbum(120,5,"Reload","Metallica",1997, 115, AlbumType.AUDIO_CASSETTE);
//        Product p8 = new MusicAlbum(70,5,"Kombi","Kombi",1980, 90, AlbumType.CD);
//
//
//        productService.addProduct(p1);
//        productService.addProduct(p2);
//        productService.addProduct(p3);
//        productService.addProduct(p4);
//        productService.addProduct(p5);
//        productService.addProduct(p6);
//        productService.addProduct(p7);
//        productService.addProduct(p8);
//
//        EOrder order = new EOrder(LocalDateTime.now(),null, EOrderStatus.NEW);
//        order.setClient(c);
//        eOrderService.save(order);
//
//        order.addProduct(p1);
//        order.addProduct(p2);
//        order.addProduct(p3);
//        eOrderService.update(order);
//
//
//        EOrder order2 = new EOrder(LocalDateTime.now().minusDays(1),null, EOrderStatus.NEW);
//        order2.setClient(c2);
//        eOrderService.save(order2);
//
//        order2.addProduct(p1);
//        order2.addProduct(p3);
//        order2.addProduct(p4);
//        order2.addProduct(p6);
//        eOrderService.update(order2);
//
//
//        EOrder order3 = new EOrder(LocalDateTime.now().minusDays(5),null, EOrderStatus.NEW);
//        order3.setClient(c);
//
//        order3.addProduct(p2);
//        order3.addProduct(p3);
//        order3.addProduct(p4);
//        order3.addProduct(p5);
//        order3.addProduct(p7);
//
//        eOrderService.save(order3);
//
//        Seller seller1 = new Seller("Andrzej", "Nowak",LocalDate.now().minusYears(22), LocalDate.now().minusYears(2));
//        personService.save(seller1);
//
//        seller1.addStationarySale(p1);
//        seller1.addStationarySale(p3);
//
//        personService.update(seller1);
//
//        Luthier luthier = new Luthier("Michał", "Kowal",LocalDate.now().minusYears(38), LocalDate.now().minusYears(5));
//        personService.save(luthier);
//
//        Repair repair = luthier.addRepair(p1,c);
//
//        repairService.save(repair);
//
//        repair.setRate(new Rate(3,"Ok"));
//
//        repairService.update(repair);
//
//
//        EOrder order4 = new EOrder(LocalDateTime.now().minusDays(12),null, EOrderStatus.IN_PROGRESS);
//        order4.setPacker(packer);
//        order4.setClient(c);
//
//        order4.addProduct(p2);
//        order4.addProduct(p6);
//        eOrderService.save(order4);
//
//        EOrder order5 = new EOrder(LocalDateTime.now().minusDays(17),null, EOrderStatus.IN_PROGRESS);
//        order5.setPacker(packer2);
//        order5.setClient(c);
//
//        order5.addProduct(p4);
//        order5.addProduct(p5);
//        order5.addProduct(p2);
//        eOrderService.save(order5);
//
//        EOrder order6 = new EOrder(LocalDateTime.now().minusDays(13),null, EOrderStatus.IN_PROGRESS);
//        order6.setPacker(packer2);
//        order6.setClient(c2);
//
//        order6.addProduct(p4);
//        order6.addProduct(p5);
//        order6.addProduct(p2);
//        eOrderService.save(order6);
//

//        order3.cancel();
//        eOrderService.update(order3);
//
//        eOrderService.removeCanceledEOrders();



    }
}