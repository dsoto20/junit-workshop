package external.services;


public class BQClient {
    private String connection;

    public BQClient(String connection) {
        this.connection = connection;
    }

    public String getFormattedMessage(String message) {
        return String.format("put message: %s to Queue: %s", message, connection);
    }

    public void putObject(String message) {
        System.out.println(message);
    }
}
