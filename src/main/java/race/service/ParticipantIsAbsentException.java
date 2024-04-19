package race.service;

public class ParticipantIsAbsentException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Участник отстутсвует в списке";
    }
}
