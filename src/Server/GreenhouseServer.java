package Server;

import Client.SensorData;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GreenhouseServer {

    private static final int port = 5000;
    private static final int threadPoolSize = 10;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);


            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

               threadPool.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
