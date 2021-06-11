package mas.masproject.rest_controllers;

import mas.masproject.models.Instrument;
import mas.masproject.models.Product;
import mas.masproject.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/instruments")
    ResponseEntity<List<Instrument>> getInstruments(){

        return ResponseEntity.ok(productService.getAllInstruments());
    }

    @PostMapping("/instruments")
    ResponseEntity<Product> addInstrument(@RequestBody Instrument instrument){
       Product res = productService.addProduct(instrument);

        return ResponseEntity.ok(res);
    }

}
