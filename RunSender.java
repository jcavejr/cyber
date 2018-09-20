import java.io.*;

class RunSender {
    public static void main(String[] args) {
        Sender mySender = new Sender();
        System.out.println("Connected to: " + mySender);
        String data = "This is a test string";
        mySender.sendObjectToStream(data);
    }
}