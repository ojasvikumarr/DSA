import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.* ;

public class temppp {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            Socket clientSocket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String message = reader.readLine();
            System.out.println("Client says: " + message);

            reader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
