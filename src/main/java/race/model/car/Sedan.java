package race.model.car;

import race.model.Track;

public class Sedan extends Car {
    public Sedan(String name, int speed) {
        super(name, speed);
    }

    @Override
    public int drive(Track track) {
        return track.getDistance() - this.getSpeed();
    }
}
