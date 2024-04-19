package race.model.car;

import race.model.Track;

public class SportCar extends Car {
    public SportCar(String name, int speed) {
        super(name, speed);
    }

    @Override
    public int drive(Track track) {
        return track.getDistance() - this.getSpeed();
    }
}
