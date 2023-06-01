package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RewardValue {
    private LocalDate dateOfApply;
    private List<PrizeType> rewardTypes = new ArrayList<>();

    public LocalDate getDateOfApply() {
        return dateOfApply;
    }

    public void setDateOfApply(LocalDate dateOfApply) {
        this.dateOfApply = dateOfApply;
    }

    public List<PrizeType> getRewardTypes() {
        return rewardTypes;
    }

    public void setRewardTypes(List<PrizeType> rewardTypes) {
        this.rewardTypes = rewardTypes;
    }

}
