package bhtu.work.tths.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	public static final String[] localSchool = {"Tiểu Học Tây Sơn", "Tiểu Học Thanh Lương", "THCS Đoàn Kết", "THCS Hà Huy Tập", "THPT Thăng Long", "THPT Trần Nhân Tông"}; 
    
    
    @Id
    private  String id;
	private String name;
	private LocalDate dateOfBirth;
	private String school;
	private String householdNumber;
	private String parent;
	private List<Reward> rewards = new ArrayList<>();

	public Student(String id, String name, LocalDate dateOfBirth, String school, String householdNumber, String parent) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.school = school;
		this.householdNumber = householdNumber;
		this.parent = parent;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHouseholdNumber() {
        return householdNumber;
    }

    public void setHouseholdNumber(String householdNumber) {
        this.householdNumber = householdNumber;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

	
}
