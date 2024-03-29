package services;

import external.services.BQClient;

public class MyService {
    BQClient bqClient = new BQClient();

    public void sendMessage(String message) {
        String formattedMessage = bqClient.getFormattedMessage(message);
        if(formattedMessage == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        System.out.println("Calling to putObject with formatted message: " +  formattedMessage);
        bqClient.putObject(formattedMessage);
    }
}
