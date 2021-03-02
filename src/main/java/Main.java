import external.services.BQClient;
import services.MyService;

public class Main {
    //TODO suply DI for BQClient
    public static void main(String[] args) {
        String queue = "realQueue";
        String message = "Real Message";
        BQClient realClient = new BQClient(queue);
        MyService myService = new MyService(realClient);
        myService.sendMessage(message);
    }
}
