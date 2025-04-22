import java.net.*;
import java.io.*;

public class NATCheck {
    public static void main(String[] args) {
        try {
            // Get Private IP (Local)
            InetAddress localIP = InetAddress.getLocalHost();
            System.out.println("Private IP Address: " + localIP.getHostAddress());

            // Get Public IP (from an external web service)
            URL url = new URL("https://api.ipify.org");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String publicIP = br.readLine();
            System.out.println("Public IP Address: " + publicIP);

            System.out.println("\nThis shows NAT is working. Your private IP is hidden, and your router uses the public IP to access the internet.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}