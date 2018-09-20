import java.io.*;

class RunReceiver {
    public static void main(String[] args) {
        Receiver myReceiver = new Receiver();
        System.out.println(myReceiver);
        try {
            System.out.println(myReceiver.receiveObjectFromStream());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}