package bhtu.work.tths.models.dto;

import bhtu.work.tths.models.enums.EUserAccess;

import java.util.Set;

public record PersonnelRegistration(
        String username,
        String password,
        Set<EUserAccess> accesses,
        String region
) {
}
