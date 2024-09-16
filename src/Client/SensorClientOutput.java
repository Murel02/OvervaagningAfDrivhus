package Client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class SensorClientOutput {

    private String host;
    private int port;


    public SensorClientOutput(String hostname, int port) {
        this.host = hostname;
        this.port = port;
    }

    public void sendData(SensorData data) {
        try(Socket socket = new Socket(host, port)) {
            OutputStream output = socket.getOutputStream();
            DataOutputStream dataOutput = new DataOutputStream(output);
            dataOutput.writeUTF(data.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
