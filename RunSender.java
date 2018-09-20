import java.io.*;

class RunSender {
    private static int PORT_NUMBER;
    public static void main(String[] args) {
        if (args.length == 1) {
            PORT_NUMBER = Integer.parseInt(args[0]);
        } else {
            PORT_NUMBER = 5000;
        }
        Sender mySender = new Sender(PORT_NUMBER);
        System.out.println("Connected to: " + mySender);
        String data = "This is a test string";
        mySender.sendObjectToStream(data);
    }
}