package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RewardValue {
    public class RewardType {
        /**
         * Phan thuong: keo(cai), banh(goi)
         */
        private String nameOfRewardType;
        private int unitPrice;

        public String getNameOfRewardType() {
            return nameOfRewardType;
        }

        public void setNameOfRewardType(String loaiPhanThuong) {
            this.nameOfRewardType = loaiPhanThuong;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int giaTien) {
            this.unitPrice = giaTien;
        }

    }

    private LocalDate dateOfIndication;
    private List<RewardType> rewardTypes = new ArrayList<>();

    public LocalDate getDateOfIndication() {
        return dateOfIndication;
    }

    public void setDateOfIndication(LocalDate ngayTao) {
        this.dateOfIndication = ngayTao;
    }

    public List<RewardType> getRewardTypes() {
        return rewardTypes;
    }

    public void setRewardTypes(List<RewardType> cacGiaiThuong) {
        this.rewardTypes = cacGiaiThuong;
    }

    

}
