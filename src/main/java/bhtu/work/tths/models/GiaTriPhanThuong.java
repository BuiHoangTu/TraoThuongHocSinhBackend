package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GiaTriPhanThuong {
    public class LoaiPhanThuong {
        private String danhHieu;
        private int giaTien;

        public String getDanhHieu() {
            return danhHieu;
        }

        public void setDanhHieu(String loaiPhanThuong) {
            this.danhHieu = loaiPhanThuong;
        }

        public int getGiaTien() {
            return giaTien;
        }

        public void setGiaTien(int giaTien) {
            this.giaTien = giaTien;
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
