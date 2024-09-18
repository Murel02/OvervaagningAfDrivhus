package Client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class SensorClientOutput {

    private final Socket socket;
    private PrintWriter writer;


    public SensorClientOutput(Socket socket) throws IOException{
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendData(SensorData data) {
        try{
            writer.println(data.toString());
            writer.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
