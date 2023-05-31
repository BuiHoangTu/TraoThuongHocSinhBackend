package bhtu.work.tths.models.dto;

import java.time.LocalDate;

public record RewardByEvent(
        RewardPack allRewards,
        int totalExpense,
        LocalDate dateOfEvent,
        String nameOfEvent
        ) 
        {
                
        }
