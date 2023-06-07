package bhtu.work.tths.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhtu.work.tths.models.AwardPeriod;
import bhtu.work.tths.repositories.mongo.AwardPeriodRepo;

@Service
public class AwardPeriodService {
    private final AwardPeriodRepo awardPeriodRepo;

    @Autowired
    public AwardPeriodService(AwardPeriodRepo awardPeriodRepo) {
        this.awardPeriodRepo = awardPeriodRepo;
    }
    
    public AwardPeriod getAwardPeriod(String dateString) {
        LocalDate dateOfApply;
        if (dateString != null) {
            try {
                dateOfApply = LocalDate.parse(dateString);
            } catch (DateTimeParseException _e) {
                dateOfApply = LocalDate.now();
            }
        } else {
            dateOfApply = LocalDate.now();
        }
        return this.awardPeriodRepo.findByDateOfApply(dateOfApply);
    }

    public AwardPeriod updateAwardLevel(AwardPeriod awardPeriod) {
        return this.awardPeriodRepo.save(awardPeriod);
    }

}
