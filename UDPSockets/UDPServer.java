import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 5000
            DatagramSocket serverSocket = new DatagramSocket(5000);
            System.out.println("Server is waiting for client messages on port 5000...");

            // Buffer to store incoming data
            byte[] buffer = new byte[1024];

            // Packet to receive data
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket); // Receive data from client

            // Extract client message
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client says: " + clientMessage);

            // Prepare response to client
            String response = "Hello from UDP Server!";
            byte[] responseData = response.getBytes();

            // Send response to client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket); // Send response

            // Close the socket
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
