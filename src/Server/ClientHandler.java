package Server;

import Client.SensorData;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket socket;
    private AlarmManager alarmManager = new AlarmManager();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try(GreenhouseServerInput inputHandler = new GreenhouseServerInput(socket);
            GreenhouseServerOutput outputHandler = new GreenhouseServerOutput(socket)){

            SensorData data;
            while ((data = inputHandler.inputData()) != null){
                System.out.println("Received data: " + data);

                alarmManager.checkForAlarms(data);
            }
        }catch (IOException e){
            System.err.println("Client handling error: " + e.getMessage());
        }
    }
}
