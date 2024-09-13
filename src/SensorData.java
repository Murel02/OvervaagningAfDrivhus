public class SensorData {

    private String sensorType;
    private int value;
    private int timeStamp;

    public SensorData(String sensorType, int value, int timeStamp) {
        this.sensorType = sensorType;
        this.value = value;
        this.timeStamp = timeStamp;
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

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
