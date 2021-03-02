package external.services;


public class BQClient {
    private String connection = "hardcodedConnection";

    public void putObject(String myMessage) {
        System.out.println(String.format("put message: %s to Queue: %s", myMessage, connection));
    }
}
