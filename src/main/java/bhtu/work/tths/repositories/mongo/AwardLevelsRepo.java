package bhtu.work.tths.repositories.mongo;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bhtu.work.tths.models.AwardLevelPeriod;

@Repository
public interface AwardLevelsRepo extends MongoRepository<AwardLevelPeriod, LocalDate> {

}
