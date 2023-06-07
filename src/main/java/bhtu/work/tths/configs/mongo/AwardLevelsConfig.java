package bhtu.work.tths.configs.mongo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bhtu.work.tths.models.AwardLevel;
import bhtu.work.tths.models.AwardPeriod;
import bhtu.work.tths.repositories.mongo.AwardPeriodRepo;

@Configuration
public class AwardLevelsConfig {
    
    @Bean
    CommandLineRunner ALCrunner(AwardPeriodRepo repo) {
        return ((_args) -> {
            AwardPeriod awardPeriod = new AwardPeriod();
            awardPeriod.setDateOfApply(LocalDate.of(1992, 12, 9));
        
            AwardLevel awardLevel = new AwardLevel();
            awardLevel.setAchievement("gioi");
            awardLevel.setPrizeValue(100_000);
            awardPeriod.getAwardLevels().add(awardLevel);

            awardLevel = new AwardLevel();
            awardLevel.setAchievement("kha");
            awardLevel.setPrizeValue(50_000);
            awardPeriod.getAwardLevels().add(awardLevel);

            awardLevel = new AwardLevel();
            awardLevel.setAchievement("trung binh");
            awardLevel.setPrizeValue(100_000);
            awardPeriod.getAwardLevels().add(awardLevel);

            // repo.save(awardPeriod);
        });
    }
}
