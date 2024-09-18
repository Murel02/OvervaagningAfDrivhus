package Client;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class SensorEarthMoisture {
    public int earthMoisture() {
        Random randomEarthMoisture = new Random();
        return randomEarthMoisture.nextInt( 1 + 80) + 20;
    }

    public SensorData generateEarthMoisture() {
        SensorData sensorData = new SensorData();
        sensorData.setSensorType("Earth moisture");
        sensorData.setValue(earthMoisture());
        sensorData.setTimeStamp(LocalDateTime.now());
        return sensorData;
    }

}
