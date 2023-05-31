package bhtu.work.tths.models;

import java.time.LocalDate;

public class Reward {
    private LocalDate ngayPhatThuong;
    private String tenDotPhatThuong;
    private String danhHieu;
    private String lop;
    /**
     * keo(cai), banh(goi)
     */
    private String loaiQua;
    private int soLuong;
    private int tongGiaTri;

    

    public Reward(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop, String loaiQua,
            int soLuong, int tongGiaTri) {
        this.ngayPhatThuong = ngayPhatThuong;
        this.tenDotPhatThuong = tenDotPhatThuong;
        this.danhHieu = danhHieu;
        this.lop = lop;
        this.loaiQua = loaiQua;
        this.soLuong = soLuong;
        this.tongGiaTri = tongGiaTri;
    }

    public Reward() {
    }

    public LocalDate getNgayPhatThuong() {
        return ngayPhatThuong;
    }

    public void setNgayPhatThuong(LocalDate ngayPhatThuong) {
        this.ngayPhatThuong = ngayPhatThuong;
    }

    public String getTenDotPhatThuong() {
        return tenDotPhatThuong;
    }

    public void setTenDotPhatThuong(String tenDotPhatThuong) {
        this.tenDotPhatThuong = tenDotPhatThuong;
    }

    public String getDanhHieu() {
        return danhHieu;
    }

    public void setDanhHieu(String danhHieu) {
        this.danhHieu = danhHieu;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuongPhanQua) {
        this.soLuong = soLuongPhanQua;
    }

    public int getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(int giaTri) {
        this.tongGiaTri = giaTri;
    }

    public String getLoaiQua() {
        return loaiQua;
    }

    public void setLoaiQua(String loaiQua) {
        this.loaiQua = loaiQua;
    }

}