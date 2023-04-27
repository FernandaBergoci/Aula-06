package client;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Socket socket;
        final String HOST = "localhost";
        final int PORT = 12345;

        try {
            socket = new Socket(HOST, PORT);

            socket.close();
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
           
        }
    }
}