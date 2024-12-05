import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            // Prepare message to send
            String message = "Hello UDP Server!";
            byte[] sendData = message.getBytes();

            // Send packet to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            // Buffer to store server response
            byte[] buffer = new byte[1024];

            // Packet to receive server response
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivePacket); // Receive response from server

            // Extract server response
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server says: " + serverResponse);

            // Close the socket
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
