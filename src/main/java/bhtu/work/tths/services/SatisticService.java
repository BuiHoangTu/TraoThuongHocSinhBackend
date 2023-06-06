package bhtu.work.tths.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhtu.work.tths.models.dto.RewardByEvent;
import bhtu.work.tths.models.dto.RewardByHouseholdNumber;
import bhtu.work.tths.repositories.mongo.AwardPeriodRepo;
import bhtu.work.tths.repositories.mongo.PrizePeriodRepo;
import bhtu.work.tths.repositories.mongo.StudentRepo;

@Service
public class SatisticService {
    private final AwardPeriodRepo awardPeriodRepo;
    private final PrizePeriodRepo prizePeriodRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public SatisticService(AwardPeriodRepo awardPeriodRepo, PrizePeriodRepo prizePeriodRepo,
            StudentRepo studentRepo) {
        this.awardPeriodRepo = awardPeriodRepo;
        this.prizePeriodRepo = prizePeriodRepo;
        this.studentRepo = studentRepo;
    }

    public RewardByEvent getRewardByEvent(String eventFilter, String filterType) {
        return null;
        // TODO: implement this and below 
    }

    public RewardByHouseholdNumber getByHouseholdNumber(String householdNumber) {
        return null;
    }
}
