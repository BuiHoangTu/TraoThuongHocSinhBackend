package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GiaTriPhanThuong {
    public class LoaiPhanThuong {
        /**
         * Phan thuong: keo(cai), banh(goi)
         */
        private String loaiPhanThuong;
        private int donGia;

        public String getLoaiPhanThuong() {
            return loaiPhanThuong;
        }

        public void setLoaiPhanThuong(String loaiPhanThuong) {
            this.loaiPhanThuong = loaiPhanThuong;
        }

        public int getDonGia() {
            return donGia;
        }

        public void setDonGia(int giaTien) {
            this.donGia = giaTien;
        }

    }

    private LocalDate ngayTao;
    private List<LoaiPhanThuong> cacLoaiPhanThuong = new ArrayList<>();

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public List<LoaiPhanThuong> getCacLoaiPhanThuong() {
        return cacLoaiPhanThuong;
    }

    public void setCacLoaiPhanThuong(List<LoaiPhanThuong> cacGiaiThuong) {
        this.cacLoaiPhanThuong = cacGiaiThuong;
    }

    

}
