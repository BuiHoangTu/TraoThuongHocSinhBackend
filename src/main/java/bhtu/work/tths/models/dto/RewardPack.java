package bhtu.work.tths.models.dto;

import java.util.List;

public record RewardPack (
    List<AReward> rewards
) {
    private record AReward(
        String typeAndUnit,
        int amount
    ) {}


    
}
