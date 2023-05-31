package bhtu.work.tths.models;

import lombok.Data;

@Data
public class Prize {
    private String nameOfPrize;
    private int amount;

    public Prize(String nameOfPrize, int amount) {
        this.nameOfPrize = nameOfPrize;
        this.amount = amount;
    }

}
