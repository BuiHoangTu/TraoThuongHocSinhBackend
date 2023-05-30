package bhtu.work.tths.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bhtu.work.tths.models.HocSinh;

public interface HocSinhRepo extends MongoRepository<HocSinh, String>{
    
    
}
