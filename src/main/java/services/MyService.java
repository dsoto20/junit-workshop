package services;

import external.services.BQClient;

public class MyService {
    BQClient bqClient = new BQClient();

    public void sendMessage(String message) {
        if(message == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        bqClient.putObject(message);
    }
}
