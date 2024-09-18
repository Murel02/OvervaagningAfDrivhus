package Client;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class SensorEarthMoisture {
    public int earthMoisture() {
        Random randomEarthMoisture = new Random();
        return randomEarthMoisture.nextInt( 1 + 100) + 20;
    }

    public SensorData generateEarthMoisture() {
        SensorData sensorData = new SensorData();
        sensorData.setSensorType("earth-moisture");
        sensorData.setValue(earthMoisture());
        sensorData.setTimeStamp(LocalDateTime.now());
        return sensorData;
    }



    /*public void sendToClient(double earthMoisture) {

        Logger logger = Logger.getLogger(SensorAirMoisture.class.getName());
        logger.info("Moisture send to Client.SensorClient " + earthMoisture + "%");


    }

    public sensorRunner {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                double earthMoisture = earthMoisture();
                sendToClient(earthMoisture);

            }
        }, 0, 1000);
    }*/
}
