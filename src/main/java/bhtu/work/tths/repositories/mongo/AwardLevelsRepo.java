package bhtu.work.tths.repositories.mongo;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import bhtu.work.tths.models.AwardLevelPeriod;

public interface AwardLevelsRepo extends MongoRepository<AwardLevelPeriod, LocalDate> {

}
