package bhtu.work.tths.configs.mongo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bhtu.work.tths.models.HocSinh;
import bhtu.work.tths.models.PhanThuong;
import bhtu.work.tths.repositories.mongo.HocSinhRepo;

@Configuration
public class HocSinhConfig {
    
    @Bean
	CommandLineRunner runner(HocSinhRepo repo) {
		return (args) -> {
			HocSinh h = new HocSinh("2", "Tu2", LocalDate.now(), HocSinh.tenCacTruongHoc[2], "16894577", "rs");

			PhanThuong p = new PhanThuong();
            p.setDanhHieu("gioi");
            p.setLop("15");
            p.setNgayPhatThuong(LocalDate.of(1935,12,1));
            p.setSoLuong(10);
			p.setTenDotPhatThuong("Trung Thu");
			p.setTongGiaTri(100_000);
			p.setLoaiQua("vo (quyen)");
			h.getCacPhanThuong().add(p);
			
			p = new PhanThuong();
            p.setDanhHieu("kha");
            p.setLop("15");
            p.setNgayPhatThuong(LocalDate.of(1935,12,1));
            p.setSoLuong(10);
			p.setTenDotPhatThuong("Trung Thu");
			p.setTongGiaTri(100_000);
			p.setLoaiQua("vo (quyen)");
			h.getCacPhanThuong().add(p);
			repo.save(h);
		};
	}
}
