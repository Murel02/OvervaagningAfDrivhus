package Server;

import Client.SensorData;

public class AlarmManager {
    /* Alarm værdier */
    private static final int temperatureMaxThreshold = 30;
    private static final int temperatureMinThreshold = 10;
    private static final int airMoisterMaxThreshold = 70;
    private static final int airMoistureMinThreshold = 20;
    private static final int earthMoistureMinThreshold = 10;

    public void checkForAlarms(SensorData data){

    }

    private void triggerAlarm(String type, int value){
        System.out.println("ALARM: " + type + " value is out of range " + value);
    }
}
