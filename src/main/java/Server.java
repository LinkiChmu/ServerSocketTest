import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    private static final int PORT = 32768;


    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

//            System.out.println("Server started!");
//            InetAddress address = InetAddress.getLocalHost();
//            System.out.println(address.getHostAddress());
            //System.out.println(address);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(
                             clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("New connection accepted");
                    String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}