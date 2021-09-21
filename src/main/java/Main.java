import services.MyService;

public class Main {
    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.sendMessage("default message");
    }
}
