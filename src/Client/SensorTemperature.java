package Client;

import java.time.LocalDateTime;
import java.util.Random;

public class SensorTemperature {

    public int temperture() {
        Random randomTemperture = new Random();
        return randomTemperture.nextInt(1 + 50) + 10;
    }

    public SensorData generateTemperature() {

        SensorData sensorData = new SensorData();
        sensorData.setSensorType("Temperature");
        sensorData.setValue(temperture());
        sensorData.setTimeStamp(LocalDateTime.now());
        return sensorData;
    }
}
