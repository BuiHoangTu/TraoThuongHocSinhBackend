package bhtu.work.tths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class StudentAwardApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAwardApplication.class, args);
	}

}
