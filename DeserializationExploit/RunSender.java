import java.io.*;

class RunSender {
    private static int PORT_NUMBER;
    private static String ADDRESS;
    public static void main(String[] args) {
        if (args.length == 2) {
            ADDRESS = args[0];
            PORT_NUMBER = Integer.parseInt(args[1]);
        } else {
            System.err.println("WARNING: Address and port number not provided. Defaulting to localhost:5000");
            ADDRESS = "localhost";
            PORT_NUMBER = 5000;
        }
        Sender mySender = new Sender(ADDRESS, PORT_NUMBER);
        System.out.println("Connected to: " + mySender);
        String data = "This is a test string";
        mySender.sendObjectToStream(data);
    }
}