import java.net.*;
import java.io.*;

public class Receiver {
    private final int PORT_NUMBER = 5000;
    private ServerSocket openSocket;
    private Socket connection;
    private ObjectInputStream stream;

    public Receiver() {
        try {
            openSocket = new ServerSocket(PORT_NUMBER);
            getConnection();
            System.out.println("Connection established: " + openSocket);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public void getConnection() throws IOException {
        connection = openSocket.accept();
        stream = new ObjectInputStream(connection.getInputStream());
    }

    public Object receiveObjectFromStream() {
        try {
            return stream.readObject();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: Class of invalid type received.");
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public String toString() {
        return openSocket.toString();
    }
}