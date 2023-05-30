package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.Optional;

import bhtu.work.tths.models.GiaTriPhanThuong.LoaiPhanThuong;
import bhtu.work.tths.models.MucThuong.GiaiThuong;

public class PhanThuong {
    private LocalDate ngayPhatThuong;
    private String tenDotPhatThuong;
    private String danhHieu;
    private String lop;
    /**
     * keo(cai), banh(goi)
     */
    private String loaiGiaiThuong;
    private int soLuong;
    private int tongGiaTri;

    public PhanThuong(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop,
            MucThuong mucThuong, GiaTriPhanThuong giaTriPhanThuong) throws RuntimeException {
        this.ngayPhatThuong = ngayPhatThuong;
        this.tenDotPhatThuong = tenDotPhatThuong;
        this.danhHieu = danhHieu;
        this.lop = lop;

        Optional<GiaiThuong> gtOptional = mucThuong.getCacGiaiThuong().stream()
                .filter((gt) -> gt.getTenDanhHieu().equals(danhHieu)).findFirst();
        if (gtOptional.isPresent()) {
            GiaiThuong giaiThuong = gtOptional.get();
            this.loaiGiaiThuong = giaiThuong.getLoaiPhanThuong();
            this.soLuong = giaiThuong.getSoLuong();
        } else
            throw new RuntimeException("Danh hieu khong hop le");

        var gttOptional = giaTriPhanThuong.getCacLoaiPhanThuong().stream()
                .filter((lpt) -> lpt.getLoaiPhanThuong().equals(this.loaiGiaiThuong)).findFirst();
        if (gttOptional.isPresent()) {
            LoaiPhanThuong x = gttOptional.get();
            this.tongGiaTri = x.getDonGia() * this.soLuong;
        } else
            throw new RuntimeException("Phan qua khong hop le");

    }

    public PhanThuong() {
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

    public void setSoLuong(int soVo) {
        this.soLuong = soVo;
    }

    public int getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(int giaTri) {
        this.tongGiaTri = giaTri;
    }

}