package race.service;

import race.model.Participant;
import race.model.Track;

import java.util.*;

public class RaceImpl implements Race {
    private HashMap<Participant, Integer> finishedParticipants;
    private List<Participant> allParticipants;
    private Track track;

    public RaceImpl(List<Participant> allParticipants, Track track) {
        this.allParticipants = allParticipants;
        this.track = track;
        finishedParticipants = new HashMap<>();
    }

    @Override
    public List<Participant> getAllParticipants() {
        return allParticipants;
    }

    @Override
    public HashMap<Participant, Integer> getFinishedParticipants() {
        return finishedParticipants;
    }

    @Override
    public HashMap<Participant, Integer> startRace() {
        List<Participant> sortedParticipants = new ArrayList<>(allParticipants);

        sortedParticipants.sort(Comparator.comparingInt(participant -> participant.getTransport().drive(track)));

        HashMap<Participant, Integer> results = new HashMap<>();

        int currentPosition = 1;

        for (int i = 0; i < sortedParticipants.size(); i++) {
            Participant participant = sortedParticipants.get(i);

            if (i > 0 && participant.getTransport().drive(track) ==
                    sortedParticipants.get(i - 1).getTransport().drive(track)) {
                results.put(participant, currentPosition - 1);
            } else {
                results.put(participant, currentPosition++);
            }
        }

        finishedParticipants = results;

        return results;
    }

    @Override
    public Participant startDuoRace(Participant firstParticipant, Participant secondParticipant) {
        if (!(allParticipants.contains(firstParticipant) &&
                allParticipants.contains(secondParticipant))) {
            throw new ParticipantIsAbsentException();
        }

        int fParticipant = firstParticipant.getTransport().drive(track);
        int sParticipant = secondParticipant.getTransport().drive(track);

        return fParticipant > sParticipant ? firstParticipant : secondParticipant;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<Map.Entry<Participant, Integer>> sortedResults = new ArrayList<>(finishedParticipants.entrySet());
        sortedResults.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Participant, Integer> entry : sortedResults) {
            result.append(entry.getKey().getName())
                    .append(" занял ")
                    .append(entry.getValue())
                    .append(" место\n");
        }

        return result.toString();
    }
}
