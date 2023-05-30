package bhtu.work.tths.repositories.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import bhtu.work.tths.models.HocSinh;

@Component
public interface HocSinhRepo extends MongoRepository<HocSinh, String>{
    
    List<HocSinh> findByTen(String ten);
}
