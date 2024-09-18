package Server;

import Client.SensorData;

public class AlarmManager {

    public void checkForAlarms(SensorData data){

    }

    private void triggerAlarm(String type, int value){
        System.out.println("ALARM: " + type + " value is out of range " + value);
    }
}
