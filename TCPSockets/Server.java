package TCPSockets;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
              // Server listens on port 5000
              ServerSocket serverSocket = new ServerSocket(5000);
              System.out.println("Server is waiting for client on port 5000...");
              
              // Accept the client connection
              Socket socket = serverSocket.accept();
              System.out.println("Client connected");
  
              // Input stream to receive data from client
              InputStream input = socket.getInputStream();
              BufferedReader reader = new BufferedReader(new InputStreamReader(input));
  
              // Output stream to send data to client
              OutputStream output = socket.getOutputStream();
              PrintWriter writer = new PrintWriter(output, true);
  
              // Read client message
              String message = reader.readLine();
              System.out.println("Client says: " + message);
  
              // Respond to client
              writer.println("Hello from Server!");
  
              // Close the socket connection
              socket.close();
              serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
