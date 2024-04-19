package race.service;

import race.model.Participant;

import java.util.HashMap;
import java.util.List;

public interface Race {
    List<Participant> getAllParticipants();

    HashMap<Participant, Integer> getFinishedParticipants();

    HashMap<Participant, Integer> startRace();
    Participant startDuoRace(Participant firstParticipant, Participant secondParticipant);
}
