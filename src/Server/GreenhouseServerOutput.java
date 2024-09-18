package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GreenhouseServerOutput implements AutoCloseable {
    private Socket socket;
    private PrintWriter writer;

    public GreenhouseServerOutput(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void alarm(String alarmMessage) {
        writer.println(alarmMessage);
    }

    @Override
    public void close() throws IOException{
        if (writer != null) writer.close();
    }
}
