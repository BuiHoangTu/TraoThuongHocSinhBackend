package bhtu.work.tths.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import bhtu.work.tths.models.UserAcess;


public interface UserAccessRepo extends MongoRepository<UserAcess, Integer>{
}
