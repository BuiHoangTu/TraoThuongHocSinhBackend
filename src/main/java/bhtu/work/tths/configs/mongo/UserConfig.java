package bhtu.work.tths.configs.mongo;

import bhtu.work.tths.models.User;
import bhtu.work.tths.models.UserAcess;
import bhtu.work.tths.models.enums.EUserAccess;
import bhtu.work.tths.repositories.mongo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userRunner(UserRepo repo) {
        return (args -> {
            var uas = UserAcess.build(
                    EUserAccess.READ_NATIONAL_STUDENTS,
                    EUserAccess.WRITE_NATIONAL_STUDENTS,
                    EUserAccess.READ_NATIONAL_SATISTIC
                    );
            User headUser = new User(null, "MrPresident", "123456789456", "Viet Nam");
            headUser.setAccesses(uas);

            // repo.save(headUser);

        });
    }
}
