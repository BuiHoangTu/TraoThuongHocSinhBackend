package bhtu.work.tths.configs.mongo;

import bhtu.work.tths.models.User;
import bhtu.work.tths.models.UserAcess;
import bhtu.work.tths.models.enums.EUserAccess;
import bhtu.work.tths.repositories.mongo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Autowired
    private PasswordEncoder bCrypt;

    @Bean
    CommandLineRunner userRunner(UserRepo repo) {
        return (args -> {
            var uas = UserAcess.build(
                    EUserAccess.READ_NATIONAL_STUDENTS,
                    EUserAccess.WRITE_NATIONAL_STUDENTS,
                    EUserAccess.READ_NATIONAL_SATISTIC
                    );
            var bcPassword = this.bCrypt.encode("admin2");
            User headUser = new User(null, "admin", bcPassword, "Viet Nam");
            headUser.setAccesses(uas);

            // repo.save(headUser);

        });
    }
}
