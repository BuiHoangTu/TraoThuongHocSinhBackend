package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.AwardPeriod;
import bhtu.work.tths.services.AwardPeriodService;

import java.util.Collections;

@RestController
@RequestMapping("api/award-period")
public class AwardPeriodController {
    private final AwardPeriodService awardPeriodService;

    @Autowired
    public AwardPeriodController(AwardPeriodService awardPeriodService) {
        this.awardPeriodService = awardPeriodService;
    }

    //#region mapping
    @GetMapping("get")
    public ResponseEntity<AwardPeriod> getAwardPeriod(@RequestParam(name = "date", required = false) String dateString) {
        return ResponseEntity.ok().body(this.awardPeriodService.getAwardPeriod(dateString));
    }


    @PutMapping("update")
    public ResponseEntity<?> updateAwardLevel(@RequestBody AwardPeriod awardPeriod) {
        this.awardPeriodService.updateAwardLevel(awardPeriod);
        return ResponseEntity.ok().body(Collections.singletonMap("isUpdated", true));
    }

    //#endregion

    
}
