package bhtu.work.tths.repositories.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import bhtu.work.tths.models.UserAcess;
import bhtu.work.tths.models.enums.EUserAccess;


public interface UserAccessRepo extends MongoRepository<UserAcess, Integer>{
    Optional<UserAcess> findByAccess(EUserAccess access);
}
