package bhtu.work.tths.repositories.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bhtu.work.tths.models.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    List<Student> findByIdRegex(String id);

    List<Student> findByTenRegex(String name);

    List<Student> findByPhuHuynhRegex(String parent);

    List<Student> findByTruongHocRegex(String string);
}
