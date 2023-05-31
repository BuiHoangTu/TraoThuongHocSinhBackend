package bhtu.work.tths.repositories.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bhtu.work.tths.models.HocSinh;

@Repository
public interface HocSinhRepo extends MongoRepository<HocSinh, String>{
    
    List<HocSinh> findByTen(String ten);

    List<HocSinh> findByIdRegex(String id);

    List<HocSinh> findByTenRegex(String name);

    List<HocSinh> findByPhuHuynhRegex(String parent);

    List<HocSinh> findByTruongHocRegex(String string);
}
