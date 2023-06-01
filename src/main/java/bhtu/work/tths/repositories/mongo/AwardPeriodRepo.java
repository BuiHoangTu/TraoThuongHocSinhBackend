package bhtu.work.tths.repositories.mongo;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import bhtu.work.tths.models.AwardPeriod;

public interface AwardPeriodRepo extends MongoRepository<AwardPeriod, LocalDate> {

    @Aggregation(pipeline = {
            "{ '$match': { 'dateOfApply' : {$lt : ?0 }} }",
            "{ '$sort' : { 'dateOfApply' : -1 } }",
            "{ '$limit' : 1 }"
    })
    AwardPeriod findByDateOfApply(LocalDate dateOfApply);

}
