package race;

import race.model.Participant;
import race.model.Track;
import race.model.Transport;
import race.model.car.SportCar;
import race.model.motorcycle.SportBike;
import race.service.Race;
import race.service.RaceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Transport buggati = new SportCar("Buggati", 350);
        Transport sportBike = new SportBike("SportBike", 300);

        Participant winDrosel = new Participant(buggati, "WinDrosel");
        Participant mcWin = new Participant(buggati, "McWin");
        Participant denis = new Participant(sportBike, "Denis");
        Participant noName = new Participant(sportBike, "NoName");

        List<Participant> participants = new ArrayList<>(List.of(winDrosel, mcWin, denis, noName));

        Track track = new Track(1000);

        Race race = new RaceImpl(participants, track);
        race.startRace();
        System.out.println(race);
    }
}
