package bhtu.work.tths.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import bhtu.work.tths.models.enums.EUserAccess;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Document
@Data
public class UserAcess {
    @Id
    private int id;
    private EUserAccess access;

    public UserAcess(EUserAccess access) {
        this.access = access;
        this.id = access.value;
    }

    public static Set<UserAcess> build (EUserAccess ...eUserAccesses) {
        var s = new HashSet<UserAcess>(eUserAccesses.length);
        for(var e : eUserAccesses) {
            var a = new UserAcess(e);
            s.add(a);
        }
        return s;
    }

}
