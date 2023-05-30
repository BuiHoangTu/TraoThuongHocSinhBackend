package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.Optional;

import bhtu.work.tths.models.MucThuong.GiaiThuong;

public class PhanThuong {
    private LocalDate ngayPhatThuong;
    private String tenDotPhatThuong;
    private String danhHieu;
    private String lop;
    private String loaiGiaiThuong;
    private int soLuong;
    private int giaTri;


    public PhanThuong(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop,
            MucThuong mucThuong, GiaTriPhanThuong giaTriPhanThuong)  throws Exception{
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
        } else throw new Exception("Giai Thuong khong hop le");

        var gttOptional = giaTriPhanThuong.getCacLoaiPhanThuong().stream().filter((lpt)-> lpt.getDanhHieu().equals(danhHieu)).findFirst();
        if (gttOptional.isPresent()) {
            LoaiPhanThuong x = gttOptional.get();
            this.giaTien = x.
        }

        this.giaTri = giaTri;
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

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

}