package bhtu.work.tths.configs.mongo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bhtu.work.tths.models.AwardLevel;
import bhtu.work.tths.models.AwardLevelPeriod;
import bhtu.work.tths.repositories.mongo.AwardLevelsRepo;

@Configuration
public class AwardLevelsConfig {
    
    @Bean
    CommandLineRunner ALCrunner(AwardLevelsRepo repo) {
        return ((_args) -> {
            AwardLevelPeriod awardLevels = new AwardLevelPeriod();
            awardLevels.setDateOfApply(LocalDate.of(1990, 12, 8));
        
            AwardLevel awardLevel = new AwardLevel();
            awardLevel.setAchievement(null);
        });
    }
}
