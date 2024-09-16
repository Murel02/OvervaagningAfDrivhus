package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GreenhouseServerOutput {
    Socket socket;
    OutputStream outputStream;

    public GreenhouseServerOutput(Socket socket) {
        this.socket = socket;
    }

    public void alarm(String alarmMessage) {
        try {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println(alarmMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
