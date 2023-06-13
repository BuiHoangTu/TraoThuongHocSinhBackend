package bhtu.work.tths.controllers;

import bhtu.work.tths.models.User;
import bhtu.work.tths.repositories.mongo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/open")
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("daily-quote")
    public String getDailyQuote() {
        return "Welcome!";
    }

    @GetMapping("username")
    public User checkUserExist(@RequestParam(name = "username", defaultValue = "MrPresident") String username) {
        return  this.userRepo.findByUsername(username).orElseThrow(() -> null);
    }
}
