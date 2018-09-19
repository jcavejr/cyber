import java.net.*;
import java.io.*;

public class Sender {
    private Socket serverPort;
    private final int PORT_NUMBER = 5000;

    public Sender() {
        serverPort = openSocket();
    }

    private Socket openSocket() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            return new Socket(localHost, PORT_NUMBER);
        } catch (UnknownHostException ex) {
            System.out.println("ERROR at getLocalHost");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("ERROR at Socket");
            System.exit(1);
        }
        return null;
    }

    public void printSocket() {
        System.out.println(serverPort);
    }
}