package Client;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class SensorAirMoisture {
        public int moisture() {
        Random randomMoisture = new Random();
        return randomMoisture.nextInt(1 + 70) + 30;
    }
    public SensorData generateAirMoisture() {
            SensorData sensorData = new SensorData();
            sensorData.setSensorType("moisture");
            sensorData.setValue(moisture());
            sensorData.setTimeStamp(LocalDateTime.now());
            return sensorData;
    }



        }


