package mas.masproject.rest_controllers;

import mas.masproject.models.Instrument;
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
    ResponseEntity<List<Instrument>> getStringed(){

        return ResponseEntity.ok(productService.getAllStringedInstruments());
    }

    @PostMapping("/instruments")
    ResponseEntity<Instrument> addStringed(@RequestBody Instrument instrument){
       Instrument res = productService.addStringed(instrument);

        return ResponseEntity.ok(res);
    }

}
