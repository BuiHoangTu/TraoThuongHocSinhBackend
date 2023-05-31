package bhtu.work.tths.models;

import java.time.LocalDate;

public class Reward {
    private LocalDate dateOfEvent;
    private String nameOfEvent;
    private String achievement;
    private String classStr;
    /**
     * keo(cai), banh(goi)
     */
    private String prize;
    private int amount;
    private int totalExpense;

    

    public Reward(LocalDate dateOfEvent, String nameOfEvent, String achievement, String classStr, String typeOfReward,
            int amount, int totalExpense) {
        this.dateOfEvent = dateOfEvent;
        this.nameOfEvent = nameOfEvent;
        this.achievement = achievement;
        this.classStr = classStr;
        this.prize = typeOfReward;
        this.amount = amount;
        this.totalExpense = totalExpense;
    }

    public Reward() {
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getClassStr() {
        return classStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

}