package bhtu.work.tths.repositories.mongo;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import bhtu.work.tths.models.User;
import java.util.Optional;


public interface UserRepo extends MongoRepository<User, String> {

    Optional<User> findById(@NonNull String id);

    Boolean existsByUsername(@NonNull String username);

    Optional<User> findByUsername(String username);
}
