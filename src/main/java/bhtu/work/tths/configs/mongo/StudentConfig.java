package bhtu.work.tths.configs.mongo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bhtu.work.tths.models.EventOfStudent;
import bhtu.work.tths.models.Prize;
import bhtu.work.tths.models.Student;
import bhtu.work.tths.repositories.mongo.StudentRepo;

@Configuration
public class StudentConfig {
    @Value("${spring.testdata.student.householdnumber}")
	private String householdNumber;

    
	@Bean
	CommandLineRunner SCrunner(StudentRepo repo) {
		this.householdNumber = String.valueOf(Integer.valueOf(this.householdNumber) + 1);

		return (args) -> {
			Student h = new Student(null, "Tu2", LocalDate.now(), Student.localSchool[2], String.valueOf(this.householdNumber), "rs");

			EventOfStudent e = new EventOfStudent();
            e.setAchievement("gioi");
            e.setClassStr("15");
            e.setDateOfEvent(LocalDate.of(1935,12,1));
			e.setNameOfEvent("Trung Thu");
			e.setTotalExpense(100_000);
			e.getPrizes().add((new Prize("Banh (cai)", 13)));
			e.getPrizes().add(new Prize("Keo (goi)", 2));
			h.getEvents().add(e);
			
			e = new EventOfStudent();
            e.setAchievement("kha");
            e.setClassStr("15");
            e.setDateOfEvent(LocalDate.of(1935,12,5));
			e.setNameOfEvent("Trung Thu");
			e.setTotalExpense(100_000);
			e.getPrizes().add((new Prize("Banh (cai)", 13)));
			e.getPrizes().add(new Prize("Keo (goi)", 2));
			repo.save(h);
		};
	}
}
