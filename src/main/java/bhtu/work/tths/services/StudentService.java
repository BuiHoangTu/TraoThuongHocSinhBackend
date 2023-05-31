package bhtu.work.tths.services;

import bhtu.work.tths.models.Student;
import bhtu.work.tths.models.Reward;
import bhtu.work.tths.models.dto.RewardByEvent;
import bhtu.work.tths.models.dto.RewardByHouseholdNumber;
import bhtu.work.tths.repositories.mongo.StudentRepo;
import bhtu.work.tths.models.enums.EGetStudents;
import bhtu.work.tths.models.enums.EStatisticCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> findStudent(EGetStudents category, String filter) {
        
        switch (category) {
            case ID -> {return this.studentRepo.findByIdRegex(filter + ".*");}
            case NAME -> {return this.studentRepo.findByNameRegex(".*" + filter + ".*");}
            case SCHOOL -> {return this.studentRepo.findBySchoolRegex(".*" + filter + ".*");}
            case PARENT -> {return this.studentRepo.findByParentRegex(".*" + filter + ".*");}
            default -> {return null;}
        }
        
        
    }

    public Student addStudent(Student student) {
        return studentRepo.insert(student);
    }

    public Student getStudentById(@NonNull String Id) {
        return studentRepo.findById(Id).get();
    }

    public Student updateStudent(Student hocSinh) {
        Student onDbStudent = studentRepo.findById(hocSinh.getId()).get();
        onDbStudent.setHouseholdNumber(hocSinh.getHouseholdNumber());
        onDbStudent.setDateOfBirth(hocSinh.getDateOfBirth());
        onDbStudent.setParent(hocSinh.getParent());
        onDbStudent.setName(hocSinh.getName());
        onDbStudent.setSchool(hocSinh.getSchool());
        return studentRepo.save(onDbStudent);
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

    public List<RewardByHouseholdNumber> getPTHK(String filter) {
        return null;
    }

    public List<RewardByEvent> getPTDot(String filter) {
        return null;
    }

    public List<Reward> getThuong(String maHS) {
        return null;
    }

}
