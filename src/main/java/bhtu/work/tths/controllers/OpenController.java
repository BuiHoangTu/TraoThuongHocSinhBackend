package bhtu.work.tths.controllers;

import bhtu.work.tths.models.User;
import bhtu.work.tths.repositories.mongo.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/open")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class OpenController {
    private static final Logger logger = LoggerFactory.getLogger(OpenController.class);

    private final UserRepo userRepo;

    @Autowired
    public OpenController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("server-identity")
    public ResponseEntity<?> getServerIdentity() {
        logger.info("An user has access server-identity");
        return ResponseEntity.ok().body(Collections.singletonMap("string", "Welcome from TraoThuongHocSinhBackend java-spring-3"));
    }

    @GetMapping("username")
    public ResponseEntity<User> checkUserExist(@RequestParam(name = "username", defaultValue = "MrPresident") String username) {
        return ResponseEntity.ok().body(this.userRepo.findByUsername(username).orElseThrow(() -> null));
    }

    @PostMapping("check-input")
    public ResponseEntity<?> checkInput(@RequestBody String whole) {
        logger.info("An user says hi: " + whole);
        return ResponseEntity.ok().body(Collections.singletonMap("string", "recieved, check backend console"));
    }
}
