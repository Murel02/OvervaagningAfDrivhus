package Client;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SensorData {

    private String sensorType;
    private int value;
    private LocalDateTime timeStamp;

    public SensorData(){

    }

    public SensorData(String sensorType, int value, LocalDateTime timeStamp) {
        this.sensorType = sensorType;
        this.value = value;
        this.timeStamp = timeStamp;
    }

    private String getFormattedTimeStamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timeStamp.format(formatter);
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String toString(){
        return "SensorType: " + sensorType + ", Value: " + value + ", TimeStamp: " + getFormattedTimeStamp();
    }
}
