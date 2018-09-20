import java.net.*;
import java.io.*;

public class Sender {
    private Socket serverPort;
    // private final int PORT_NUMBER = 5000;
    private ObjectOutputStream stream;
    private final int MAX_TRIES = 10;

    public Sender(int portNumber) {
        serverPort = openSocket(portNumber);
        try {
            stream = new ObjectOutputStream(serverPort.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
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

    private Socket openSocket(int portNumber) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            try {
                System.out.println("Attempting to connect.. [" + tries + "/" + MAX_TRIES + "]");
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println(localHost);
                return new Socket(localHost, portNumber);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
                System.exit(1);
            } catch (IOException ex) {
                System.out.println("Going to sleep..");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                tries++;
            }
        }
        System.err.println("Error: Tried connecting " + tries + " times but could not connect.");
        System.exit(1);
        return null;
    }

    public String toString() {
        return serverPort.toString();
    }
}