package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MucThuong {
    public class GiaiThuong {
        private String tenDanhHieu;
        private String loaiPhanThuong;
        private int soLuong;

        public String getTenDanhHieu() {
            return tenDanhHieu;
        }

        public void setTenDanhHieu(String tenGiai) {
            this.tenDanhHieu = tenGiai;
        }

        public String getLoaiPhanThuong() {
            return loaiPhanThuong;
        }

        public void setLoaiPhanThuong(String loaiPhanThuong) {
            this.loaiPhanThuong = loaiPhanThuong;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }

    }

    private LocalDate ngayTao;
    private List<GiaiThuong> cacGiaiThuong = new ArrayList<>();

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public List<GiaiThuong> getCacGiaiThuong() {
        return cacGiaiThuong;
    }

    public void setCacGiaiThuong(List<GiaiThuong> cacGiaiThuong) {
        this.cacGiaiThuong = cacGiaiThuong;
    }

}
