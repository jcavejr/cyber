import java.net.*;
import java.io.*;

public class Receiver {
    private final int PORT_NUMBER = 5000;
    private ServerSocket openSocket;

    public Receiver() {
        try {
            openSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException ex) {
            System.out.println("Error: Caught IOException on creating ServerSocket instance.");
            System.exit(-1);
        }
    }

    public Socket getConnection() throws IOException {
        return openSocket.accept();
    }

    public String toString() {
        return openSocket.toString();
    }
}