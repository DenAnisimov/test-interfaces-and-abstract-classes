package race.model.motorcycle;

import race.model.Transport;

abstract class Motorcycle implements Transport {
    private String name;
    private int speed;

    public Motorcycle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
