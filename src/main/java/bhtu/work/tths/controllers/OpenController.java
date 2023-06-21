package bhtu.work.tths.controllers;

import bhtu.work.tths.models.User;
import bhtu.work.tths.repositories.mongo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/open")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class OpenController {
    private final UserRepo userRepo;

    @Autowired
    public OpenController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("server-identity")
    public ResponseEntity<?> getDailyQuote() {
        return ResponseEntity.ok().body(Collections.singletonMap("string", "Welcome from TraoThuongHocSinhBackend java-spring-3"));
    }

    @GetMapping("username")
    public ResponseEntity<User> checkUserExist(@RequestParam(name = "username", defaultValue = "MrPresident") String username) {
        return ResponseEntity.ok().body(this.userRepo.findByUsername(username).orElseThrow(() -> null));
    }
}
