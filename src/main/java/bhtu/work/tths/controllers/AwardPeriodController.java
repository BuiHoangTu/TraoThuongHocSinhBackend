package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.AwardPeriod;
import bhtu.work.tths.services.AwardPeriodService;

@RestController
@RequestMapping("api/awardperiod")
public class AwardPeriodController {
    private final AwardPeriodService awardPeriodService;

    @Autowired
    public AwardPeriodController(AwardPeriodService awardPeriodService) {
        this.awardPeriodService = awardPeriodService;
    }

    //#region mapping
    @GetMapping("get")
    public AwardPeriod getAwardPeriod(@RequestParam(name = "date", required = false) String dateString) {
        return this.awardPeriodService.getAwardPeriod(dateString);
    }


    @PutMapping("change")
    public boolean changeAwardLevel(@RequestBody AwardPeriod awardPeriod) {
        this.awardPeriodService.changeAwardLevel(awardPeriod);
        return true;
    }

    //#endregion

    
}
