package Server;

import Client.SensorData;

public class AlarmManager {
    /* Alarm værdier */
    private static final int temperatureMaxThreshold = 30;
    private static final int temperatureMinThreshold = 10;
    private static final int airMoisterMaxThreshold = 70;
    private static final int airMoistureMinThreshold = 20;
    private static final int earthMoistureMinThreshold = 10;

    public boolean checkForAlarms(SensorData data){

        /*Kontrollere temperatur*/

        if(data.getSensorType().equals("Temperature") && data.getValue() >  temperatureMaxThreshold){

            System.out.println("Temperatur is exceeding the limit");
            return true;
       }
        else if (data.getSensorType().equals("Temperature") && data.getValue() < temperatureMinThreshold){

            System.out.println("Temperature is below the limit");
            return true;
        }


        /*Kontrollere luftfugtighed*/
        if (data.getSensorType().equals("Air moisture") && data.getValue() > airMoisterMaxThreshold) {

            System.out.println("Air moisture is exceeding the limit");
            return true;
        }
        else if(data.getSensorType().equals("Air moisture") && data.getValue() < airMoistureMinThreshold){

            System.out.println("Air moisture is below the limit");
            return true;
        }

        /*Kontrollere jordfugtighed*/
        if (data.getSensorType().equals("Earth moisture") && data.getValue() < earthMoistureMinThreshold){
            System.out.println("Earth moisture is below the limit");
            return true;
        }

        return false;
    }
      /*sender en beskiv hvor den foteller under eller over skiver values */
    private void triggerAlarm(String type, int value){
        System.out.println("ALARM: " + type + " value is out of range " + value);
    }
}
