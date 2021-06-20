package mas.masproject;

import mas.masproject.models.Client;
import mas.masproject.models.EOrder;
import mas.masproject.models.Instrument;
import mas.masproject.models.Product;
import mas.masproject.models.enums.EOrderStatus;
import mas.masproject.services.EOrderService;
import mas.masproject.services.PersonService;
import mas.masproject.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class MasProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasProjectApplication.class, args);

	}

}
