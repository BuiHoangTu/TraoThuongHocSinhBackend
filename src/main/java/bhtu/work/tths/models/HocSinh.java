package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HocSinh {
	public static final String[] tenCacTruongHoc = {"Tiểu Học Tây Sơn", "Tiểu Học Thanh Lương", "THCS Đoàn Kết", "THCS Hà Huy Tập", "THPT Thăng Long", "THPT Trần Nhân Tông"}; 
    
    
    @Id
    private  String id;
	private String ten;
	private LocalDate ngaySinh;
	private String truongHoc;
	private String maHoKhau;
	private String phuHuynh;
	private List<PhanThuong> cacPhanThuong = new ArrayList<>();

	public HocSinh(String id, String ten, LocalDate ngaySinh, String truongHoc, String maHoKhau, String phuHuynh) {
		this.id = id;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.truongHoc = truongHoc;
		this.maHoKhau = maHoKhau;
		this.phuHuynh = phuHuynh;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTruongHoc() {
        return truongHoc;
    }

    public void setTruongHoc(String truongHoc) {
        this.truongHoc = truongHoc;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getPhuHuynh() {
        return phuHuynh;
    }

    public void setPhuHuynh(String phuHuynh) {
        this.phuHuynh = phuHuynh;
    }

    public List<PhanThuong> getCacPhanThuong() {
        return cacPhanThuong;
    }

    public void setCacPhanThuong(List<PhanThuong> cacPhanThuong) {
        this.cacPhanThuong = cacPhanThuong;
    }

	
}
