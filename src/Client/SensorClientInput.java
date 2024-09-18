package Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SensorClientInput {
    private BufferedReader reader;
    private Socket socket;

    public SensorClientInput(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response;

            while ((response = reader.readLine()) != null){
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
