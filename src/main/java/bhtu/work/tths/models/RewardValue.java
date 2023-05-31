package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RewardValue {
    private LocalDate dateOfIndication;
    private List<PrizeType> rewardTypes = new ArrayList<>();

    public LocalDate getDateOfIndication() {
        return dateOfIndication;
    }

    public void setDateOfIndication(LocalDate ngayTao) {
        this.dateOfIndication = ngayTao;
    }

    public List<PrizeType> getRewardTypes() {
        return rewardTypes;
    }

    public void setRewardTypes(List<PrizeType> cacGiaiThuong) {
        this.rewardTypes = cacGiaiThuong;
    }

}
