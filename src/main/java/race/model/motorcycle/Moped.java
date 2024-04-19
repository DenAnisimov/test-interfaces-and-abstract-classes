package race.model.motorcycle;

import race.model.Track;

public class Moped extends Motorcycle {
    public Moped(String name, int speed) {
        super(name, speed);
    }

    @Override
    public int drive(Track track) {
        return track.getDistance() - this.getSpeed();
    }
}
