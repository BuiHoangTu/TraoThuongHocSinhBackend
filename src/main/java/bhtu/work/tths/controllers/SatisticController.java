package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.dto.RewardByEvent;
import bhtu.work.tths.models.dto.RewardByHouseholdNumber;
import bhtu.work.tths.services.SatisticService;

@RestController
@RequestMapping("api/satistic")
public class SatisticController {
    private final SatisticService satisticService;

    @Autowired
    public SatisticController(SatisticService satisticService) {
        this.satisticService = satisticService;
    }

    // #region mapping
    @GetMapping("event")
    public RewardByEvent getRewardByEvent(@RequestParam(name = "filter") String eventFilter, @RequestParam(name = "filterType", defaultValue = "eventname") String filterType) {
        return this.satisticService.getRewardByEvent(eventFilter, filterType);
    }

    @GetMapping("householdnumber")
    public RewardByHouseholdNumber getByHouseholdNumber(@RequestParam(name = "filter") String householdNumber) {
        return this.satisticService.getByHouseholdNumber(householdNumber);
    }
    //#endregion
}
