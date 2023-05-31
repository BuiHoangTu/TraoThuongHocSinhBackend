package bhtu.work.tths.services;

import bhtu.work.tths.models.HocSinh;
import bhtu.work.tths.models.PhanThuong;
import bhtu.work.tths.models.dto.PhanThuongDot;
import bhtu.work.tths.models.dto.PhanThuongHK;
import bhtu.work.tths.repositories.mongo.HocSinhRepo;
import bhtu.work.tths.models.enums.EGetStudents;
import bhtu.work.tths.models.enums.EStatisticCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HocSinhService {
    @Autowired
    private HocSinhRepo hocSinhRepo;

    public List<HocSinh> findHocSinh(EGetStudents category, String filter) {
        
        switch (category) {
            case ID -> {return this.hocSinhRepo.findByIdRegex(filter + ".*");}
            case NAME -> {return this.hocSinhRepo.findByTenRegex(".*" + filter + ".*");}
            case SCHOOL -> {return this.hocSinhRepo.findByTruongHocRegex(".*" + filter + ".*");}
            case PARENT -> {return this.hocSinhRepo.findByPhuHuynhRegex(".*" + filter + ".*");}
            default -> {return null;}
        }
        
        
    }

    public HocSinh addHocSinh(HocSinh hocSinh) {
        return hocSinhRepo.insert(hocSinh);
    }

    public HocSinh getHocSinhById(@NonNull String Id) {
        return hocSinhRepo.findById(Id).get();
    }

    public List<HocSinh> getHocSinhByTen(@NonNull String ten) {
        return hocSinhRepo.findByTen(ten);
    }

    public HocSinh updateHocSinh(HocSinh hocSinh) {
        HocSinh onDbHocSinh = hocSinhRepo.findById(hocSinh.getId()).get();
        onDbHocSinh.setMaHoKhau(hocSinh.getMaHoKhau());
        onDbHocSinh.setNgaySinh(hocSinh.getNgaySinh());
        onDbHocSinh.setPhuHuynh(hocSinh.getPhuHuynh());
        onDbHocSinh.setTen(hocSinh.getTen());
        onDbHocSinh.setTruongHoc(hocSinh.getTruongHoc());
        return hocSinhRepo.save(onDbHocSinh);
    }

    // ------------------------------------------------------------------------------------------------------------------------------

    public int getPhanThuongDaTrao(EStatisticCriteria loaiMa) {
        return 0;
    }
    // public boolean themPhanThuong(String ten, String maHK, String danhHieu)
    // {return false;}
    // public boolean themPhanThuong(PhanThuong phanThuong) {
    // return false;
    // }

    public int getVoDaPhat() {
        return 0;
    }

    public int getVoChuaPhat() {
        return 0;
    }

    public List<PhanThuongHK> getPTHK(String filter) {
        return null;
    }

    public List<PhanThuongDot> getPTDot(String filter) {
        return null;
    }

    public List<PhanThuong> getThuong(String maHS) {
        return null;
    }

}
