package bhtu.work.tths.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhtu.work.tths.models.PrizePeriod;
import bhtu.work.tths.repositories.mongo.PrizePeriodRepo;

@Service
public class PrizePeriodService {
    private final PrizePeriodRepo periodRepo;
    
    @Autowired
    public PrizePeriodService(PrizePeriodRepo periodRepo) {
        this.periodRepo = periodRepo;
    }

    public PrizePeriod getAwardPeriod(String dateString) {
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
        return this.periodRepo.findByDateOfApply(dateOfApply);
    }

    public PrizePeriod updateAwardLevel(PrizePeriod prizePeriod) {
        return this.periodRepo.save(prizePeriod);
    }

    
}
