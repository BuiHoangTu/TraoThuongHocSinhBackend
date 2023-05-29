package bhtu.work.tths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TthsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TthsApplication.class, args);
	}


	@GetMapping
	public String defaultGet() {
		return "Hello World";
	}

}
