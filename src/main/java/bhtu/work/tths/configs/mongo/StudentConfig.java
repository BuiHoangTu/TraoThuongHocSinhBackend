package bhtu.work.tths.configs.mongo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    // @Bean
	// CommandLineRunner runner(HocSinhRepo repo) {
	// 	return (args) -> {
	// 		HocSinh h = new HocSinh("2", "Tu2", LocalDate.now(), HocSinh.tenCacTruongHoc[2], "16894577", "rs");

	// 		PhanThuong p = new PhanThuong();
    //         p.setDanhHieu("gioi");
    //         p.setLop("15");
    //         p.setNgayPhatThuong(LocalDate.of(1935,12,1));
    //         p.setSoLuong(10);
	// 		p.setTenDotPhatThuong("Trung Thu");
	// 		p.setTongGiaTri(100_000);
	// 		p.setLoaiQua("vo (quyen)");
	// 		h.getCacPhanThuong().add(p);
			
	// 		p = new PhanThuong();
    //         p.setDanhHieu("kha");
    //         p.setLop("15");
    //         p.setNgayPhatThuong(LocalDate.of(1935,12,1));
    //         p.setSoLuong(10);
	// 		p.setTenDotPhatThuong("Trung Thu");
	// 		p.setTongGiaTri(100_000);
	// 		p.setLoaiQua("vo (quyen)");
	// 		h.getCacPhanThuong().add(p);
	// 		repo.insert(h);
	// 	};
	// }
}
