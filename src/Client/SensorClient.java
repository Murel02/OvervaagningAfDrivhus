package Client;

import java.io.IOException;
import java.net.Socket;

public class SensorClient {
    private final String hostname;
    private final int port;

    public SensorClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start(){
        try (Socket socket = new Socket(hostname, port)){
            System.out.println("Client connected to server");

            //Send data til server
            SensorClientOutput output = new SensorClientOutput(socket);
            SensorClientInput input = new SensorClientInput(socket);

            new Thread(input::start).start();

            while(true){
                SensorTemperature sensorTemperature = new SensorTemperature();
                SensorEarthMoisture sensorEarthMoisture = new SensorEarthMoisture();
                SensorAirMoisture sensorAirMoisture = new SensorAirMoisture();

                output.sendData(sensorTemperature.generateTemperature());
                output.sendData(sensorAirMoisture.generateAirMoisture());
                output.sendData(sensorEarthMoisture.generateEarthMoisture());

                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


            public static void main(String[] args) {
       SensorClient client = new SensorClient("localhost", 5000);
       client.start();
    }

}
