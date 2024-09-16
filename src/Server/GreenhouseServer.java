package Server;

import Client.SensorData;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GreenhouseServer {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        SensorData recievedData = null;

        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            socket = serverSocket.accept();
            System.out.println("New client connected");

            GreenhouseServerInput greenhouseServerInput = new GreenhouseServerInput(socket);
            GreenhouseServerOutput greenhouseServerOutput = new GreenhouseServerOutput(socket);

            recievedData = greenhouseServerInput.inputData();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
