package Server;

import Client.SensorData;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GreenhouseServerInput implements AutoCloseable{

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private Socket socket;
    private BufferedReader reader;

    public GreenhouseServerInput(Socket socket) throws IOException{
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public SensorData inputData() {
        try {
            String sensorDataLine = reader.readLine();
            if (sensorDataLine == null) return null;

            String[] parts = sensorDataLine.split(", ");
            if (parts.length == 3) {
                String sensorType = parts[0].replace("SensorType: ", "").trim();

                String valueStr = parts[1].replace("Value: ", "").trim();
                int value = Integer.parseInt(valueStr.replaceAll("[^\\d]", ""));
               // int value = Integer.parseInt(parts[1].replace("Value: ", "").trim());
                String timeStamp = parts[2].replace("TimeStamp: ", "").trim();

                LocalDateTime parsedTimeSetup = LocalDateTime.parse(timeStamp, formatter);

                SensorData data = new SensorData(sensorType, value, parsedTimeSetup);

                return data;
            } else {
                throw new IllegalArgumentException("Invalid data format");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading input data", e);
        }
    }

    @Override
    public void close() throws IOException{
        if (reader != null) reader.close();
    }
}
