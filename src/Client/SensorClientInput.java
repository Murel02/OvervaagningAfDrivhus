package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SensorClientInput {
    DataInputStream dataInputStream = null;
    String response;
    Socket socket;

    public SensorClientInput(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            response = dataInputStream.readUTF();

            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
