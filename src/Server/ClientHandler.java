package Server;
import Client.SensorData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientHandler implements Runnable {

    final private Socket socket;
    final private AlarmManager alarmManager = new AlarmManager();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (GreenhouseServerInput inputHandler = new GreenhouseServerInput(socket);
             GreenhouseServerOutput outputHandler = new GreenhouseServerOutput(socket)) {

            SensorData data;
            while ((data = inputHandler.inputData()) != null) {
                System.out.println("Received data: " + data);

                if(alarmManager.checkForAlarms(data)){
                    logAlarmIfTriggered(data);
                }

                logDataToFile(data); // Kalder metoden for at logge data til en fil

            }
        } catch (IOException e) {
            System.err.println("Client handling error: " + e.getMessage());
        }
    }

    private void logDataToFile(SensorData data) {
        // Angiver filstien til logfilen i src-mappen
        Path filePath = Paths.get("src", "SensorDataLog.txt");

        // Skriver sensordata til filen og tilføjer det til slutningen af filen
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString(), true))) {
            writer.write(data.toString()); // Skriver sensordata til filen
            writer.newLine(); // Tilføjer en ny linje efter hver data post
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    private void logAlarmIfTriggered(SensorData data) {
        Path alarmFilePath = Paths.get("src", "AlarmLog.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(alarmFilePath.toString(), true))) {
            writer.write("ALARM: " + data.getSensorType() + " value is out of range: " + data.getValue());
            writer.newLine();
            writer.flush(); // tvinger data til at blive skrevet i txt-filen med det samme.
        } catch (IOException e) {
            System.err.println("Error writing to alarm log file: " + e.getMessage());
        }
    }
}
