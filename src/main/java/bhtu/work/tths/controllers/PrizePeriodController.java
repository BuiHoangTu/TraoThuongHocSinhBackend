package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.PrizePeriod;
import bhtu.work.tths.services.PrizePeriodService;

@RestController
@RequestMapping("api/prizeperiod")
public class PrizePeriodController {
    private final PrizePeriodService prizePeriodService;

    @Autowired
    public PrizePeriodController(PrizePeriodService prizePeriodService) {
        this.prizePeriodService = prizePeriodService;
    }

    //#region mapping
    @GetMapping("get")
    public PrizePeriod getPrizePeriod(@RequestParam(name = "date", required = false) String dateString) {
        return this.prizePeriodService.getAwardPeriod(dateString);
    }


    @PutMapping("change")
    public boolean changePrizeLevel(@RequestBody PrizePeriod prizePeriod) {
        this.prizePeriodService.changeAwardLevel(prizePeriod);
        return true;
    }
    //#endregion
}
