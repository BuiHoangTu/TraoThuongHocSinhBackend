package bhtu.work.tths.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/open")
@CrossOrigin(originPatterns = "*", maxAge = 3600)
public class OpenController {
    private static final Logger logger = LoggerFactory.getLogger(OpenController.class);


    @GetMapping("server-identity")
    public ResponseEntity<?> getServerIdentity() {
        logger.info("An user has access server-identity");
        return ResponseEntity.ok().body(Collections.singletonMap("string", "Welcome from TraoThuongHocSinhBackend java-spring-3"));
    }
}
