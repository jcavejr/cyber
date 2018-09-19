import java.net.*;
import java.io.*;

class RunReceiver {
    public static void main(String[] args) {
        Receiver myReceiver = new Receiver();
        System.out.println(myReceiver);
        try {
            Socket clientSocket = myReceiver.getConnection();
            System.out.println("Connection established: " + clientSocket);
        } catch (IOException ex) {
            System.err.println("Error: IOException occured when accepting connection.");
            System.exit(1);
        }
    }
}