package TCPSockets;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
           // Connect to the server on localhost and port 5000
           Socket socket = new Socket("localhost", 5000);

           // Output stream to send data to the server
           OutputStream output = socket.getOutputStream();
           PrintWriter writer = new PrintWriter(output, true);

           // Input stream to receive data from the server
           InputStream input = socket.getInputStream();
           BufferedReader reader = new BufferedReader(new InputStreamReader(input));

           // Send a message to the server
           writer.println("Hello Server!");

           // Receive a response from the server
           String message = reader.readLine();
           System.out.println("Server says: " + message);

           // Close the socket connection
           socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
