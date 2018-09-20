import java.io.*;

class RunSender {
    public static void main(String[] args) {
        Sender mySender = new Sender();
        System.out.println("Connected to: " + mySender);
        String data = "This is a test string";
        try {
            mySender.sendObjectToStream(data);
        } catch (IOException ex) {
            System.err.println("Error: Encountered IOException on sendObjectToStream(data)");
            ex.printStackTrace();
            System.exit(1);
        }
    }
}