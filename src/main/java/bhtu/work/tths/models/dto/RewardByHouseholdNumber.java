package bhtu.work.tths.models.dto;

import java.util.List;

import bhtu.work.tths.models.PrizeGroup;

public record RewardByHouseholdNumber(
        List<PrizeGroup> totalPrizeGroups,
        String householdNumber) {

}
