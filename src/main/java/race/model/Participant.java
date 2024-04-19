package race.model;

public class Participant {
    private Transport transport;
    private String name;

    public Participant(Transport transport, String name) {
        this.transport = transport;
        this.name = name;
    }

    public Transport getTransport() {
        return transport;
    }

    public String getName() {
        return name;
    }
}
