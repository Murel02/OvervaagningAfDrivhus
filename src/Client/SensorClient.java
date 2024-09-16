package Client;

import java.io.IOException;
import java.net.Socket;

public class SensorClient {
    private String hostname;
    private int port;
    private SensorData data;

    public SensorClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start(){
        try (Socket socket = new Socket(hostname, port)){
            System.out.println("Client connected to server");

            //Modtag data fra sensorData

            //Send data til server
            SensorClientOutput output = new SensorClientOutput(hostname, port);

            while(true){
                output.sendData(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

       SensorClient client = new SensorClient("localhost", 5000);
       client.start();
    }

}
