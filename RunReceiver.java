import java.io.*;

class RunReceiver {
    public static void main(String[] args) {
        Receiver myReceiver = new Receiver();
        System.out.println(myReceiver);
        System.out.println(myReceiver.receiveObjectFromStream());
    }
}