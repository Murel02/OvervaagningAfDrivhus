package Server;

import Client.SensorData;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class GreenhouseServerInput {
    private Socket socket;
    private SensorData data;

    public GreenhouseServerInput(Socket socket) {
        this.socket = socket;
    }

    public SensorData inputData() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String sensorDataLine = reader.readLine();

            String[] parts = sensorDataLine.split(",");
            if (parts.length == 3) {
                String sensorType = parts[0];
                int value = Integer.parseInt(parts[1]);
                String timeStamp = parts[2];

                data = new SensorData();
                data.setSensorType(sensorType);
                data.setValue(value);
                data.setTimeStamp(LocalDateTime.parse(timeStamp));

                return data;
            } else {
                throw new IllegalArgumentException("Invalid data format");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading input data", e);
        }
    }
}
