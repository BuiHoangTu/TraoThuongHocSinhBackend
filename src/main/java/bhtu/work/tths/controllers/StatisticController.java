package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.dto.RewardByEvent;
import bhtu.work.tths.models.dto.RewardByHouseholdNumber;
import bhtu.work.tths.services.StatisticService;

@RestController
@RequestMapping("api/statistic")
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    // #region mapping
    @GetMapping("event")
    public ResponseEntity<RewardByEvent> getRewardByEvent(@RequestParam(name = "filter") String eventFilter, @RequestParam(name = "filterType", defaultValue = "eventname") String filterType) {
        return ResponseEntity.ok().body(this.statisticService.getRewardByEvent(eventFilter, filterType));
    }

    @GetMapping("household-number")
    public ResponseEntity<RewardByHouseholdNumber> getByHouseholdNumber(@RequestParam(name = "filter") String householdNumber) {
        return ResponseEntity.ok().body(this.statisticService.getByHouseholdNumber(householdNumber));
    }
    //#endregion
}
