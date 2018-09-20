import java.net.*;
import java.io.*;

public class Sender {
    private Socket serverPort;
    private final int PORT_NUMBER = 5000;
    private ObjectOutputStream stream;

    public Sender() {
        serverPort = openSocket();
        try {
            stream = new ObjectOutputStream(serverPort.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendObjectToStream(Object obj) {
        try {
            stream.writeObject(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    private Socket openSocket() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            return new Socket(localHost, PORT_NUMBER);
        } catch (UnknownHostException ex) {
            System.err.println("ERROR at getLocalHost");
            ex.printStackTrace();
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("ERROR at Socket");
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public String toString() {
        return serverPort.toString();
    }
}