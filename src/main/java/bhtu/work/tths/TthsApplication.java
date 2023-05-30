package bhtu.work.tths;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.HocSinh;
import bhtu.work.tths.models.PhanThuong;
import bhtu.work.tths.repositories.mongo.HocSinhRepo;

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

	@Bean
	CommandLineRunner runner(HocSinhRepo repo) {
		return (args) -> {
			HocSinh h = new HocSinh(null, "Tu", LocalDate.now(), HocSinh.tenCacTruongHoc[2], "16894577", "rs");
			PhanThuong p = new PhanThuong();
			h.getCacPhanThuong().add(p);
			repo.insert(h);
		};
	}

}
