package bhtu.work.tths.models.dto;

import java.time.LocalDate;

public record PhanThuongDot(
        int tongSoVo,
        int tongSoTien,
        LocalDate ngayPhat,
        String tenDotPhat
        ) 
        {
                
        }
