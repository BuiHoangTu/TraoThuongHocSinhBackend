package bhtu.work.tths.configs.mongo;

import bhtu.work.tths.models.UserAcess;
import bhtu.work.tths.models.enums.EUserAccess;
import bhtu.work.tths.repositories.mongo.UserAccessRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class UserAccessesConfig {

    @Bean
    CommandLineRunner UserAccessRunner(UserAccessRepo repo) {
        return (args) -> {
            Set<UserAcess> xs = UserAcess.build(EUserAccess.values()); 
            // repo.saveAll(xs);
        };
    }
}
