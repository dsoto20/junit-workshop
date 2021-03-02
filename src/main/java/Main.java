import services.MyService;

public class Main {
    //TODO suply DI for BQClient
    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.sendMessage("default message");
    }
}
