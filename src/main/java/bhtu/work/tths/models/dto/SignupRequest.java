package bhtu.work.tths.models.dto;

public record SignupRequest(
        String username,
        String password,
        String householdNumber
) {
}
