package bhtu.work.tths.configs.mongo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bhtu.work.tths.models.Reward;
import bhtu.work.tths.models.Student;
import bhtu.work.tths.repositories.mongo.StudentRepo;

@Configuration
public class StudentConfig {
    
    @Bean
	CommandLineRunner runner(StudentRepo repo) {
		return (args) -> {
			Student h = new Student(null, "Tu2", LocalDate.now(), Student.localSchool[2], "16894577", "rs");

			Reward p = new Reward();
            p.setAchievement("gioi");
            p.setClassStr("15");
            p.setDateOfEvent(LocalDate.of(1935,12,1));
            p.setAmount(10);
			p.setNameOfEvent("Trung Thu");
			p.setTotalExpense(100_000);
			p.setPrize("vo (quyen)");
			h.getRewards().add(p);
			
			p = new Reward();
            p.setAchievement("kha");
            p.setClassStr("15");
            p.setDateOfEvent(LocalDate.of(1935,12,5));
            p.setAmount(10);
			p.setNameOfEvent("Trung Thu");
			p.setTotalExpense(100_000);
			p.setPrize("vo (quyen)");
			h.getRewards().add(p);
			repo.save(h);
		};
	}
}
