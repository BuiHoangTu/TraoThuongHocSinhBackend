package bhtu.work.tths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.PrizePeriod;
import bhtu.work.tths.services.PrizePeriodService;

import java.util.Collections;

@RestController
@RequestMapping("api/prize-period")
public class PrizePeriodController {
    private final PrizePeriodService prizePeriodService;

    @Autowired
    public PrizePeriodController(PrizePeriodService prizePeriodService) {
        this.prizePeriodService = prizePeriodService;
    }

    //#region mapping
    @GetMapping("get")
    public ResponseEntity<PrizePeriod> getPrizePeriod(@RequestParam(name = "date", required = false) String dateString) {
        return ResponseEntity.ok().body(this.prizePeriodService.getAwardPeriod(dateString));
    }


    @PutMapping("update")
    public ResponseEntity<?> updatePrizeLevel(@RequestBody PrizePeriod prizePeriod) {
        this.prizePeriodService.updateAwardLevel(prizePeriod);
        return ResponseEntity.ok().body(Collections.singletonMap("isUpdated", true));
    }
    //#endregion
}
