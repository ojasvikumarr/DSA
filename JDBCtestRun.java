import java.sql.* ;
import java.net.Socket ;
import java.net.ServerSocket;

import java.io.* ;
import java.net.*; 

public class JDBCtestRun {
    static final String JDBC_Driver = "jdbc.driver";
    static final String DB_URL = "hello.db.connection";
    static final String Uname = "hello";
    static final String Upass = "hello@123";

    public static void main(String[] argv){
        Connection con = null;
        Statement stmtt = null ;
        try {
            // class.forName("");
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL, Uname, Upass);
            System.out.println("Creating statement...");
            stmtt = con.createStatement();
            String sql = "Select id , fname , lname , age from students";
            ResultSet rts = stmtt.executeQuery(sql);
            while(rts.next()){
                int id = rts.getInt("id");
                String fname = rts.getString("fname");
                String lname = rts.getString("lname");
                int age =rts.getInt("age");
                System.out.println("ID : "+id+" Fullname : "+fname+" "+lname+" age : "+age);
            }
            rts.close();
            stmtt.close();
            con.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
         catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void TCPclient(String argv[]){
        // Socket(String host , int port);
        // getInputStream();
        // getOutputStream();c
        // close();

        ServerSocket(int port);
        socket.accept();

        String comment ; 
        String reply ;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("Hello" , 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inUser = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        comment = inUser.readLine() ; 
        outToServer.writeBytes("Hello host");
        reply = inFromUser.readLine();
        System.out.println("From server" + reply);
        clientSocket.close();

    }
    public void TCPserver(String argv[]){
        String clientSentence ; 
        String capitalizedSentence ; 
        int port = 6789 ;
        try {
            ServerSocket welcomeSocket = new ServerSocket(port);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase();
                outToClient.writeBytes(capitalizedSentence);
            }
            // welcomeSocket.close();
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }


    public void URLclass(String argv[]){
        try {
            URL urlConnect = new URL(DB_URL);
            
            InputStream in = urlConnect.openStream() ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line ;
            while((line = reader.readLine()) != null){
                System.out.println("Helo");
            }
            reader.close();
            in.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void URLConnectionClass(String argv[]){
        try {
            URL url = new URL(DB_URL);
            URLConnection connection = url.openConnection() ;
    
            InputStream in = connection.getInputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line ;
            while((line = reader.readLine())!= null){
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void httpURLConnection(String argv[]){
        try {
            URL url = new URL(DB_URL);
            httpURLConnection connect = (httpURLConnection)url.openStream();
            connect.setRequestMethod("GET");
            int responseCode = connect.getResponseCode();
            System.out.println(responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String line ;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void SocketServer(String argv[]){
        try {
            ServerSocket ss = new ServerSocket(777);
            System.out.println("Server is listening to port : 777");
            Socket s = ss.accept();
            System.out.println("Client connected");
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = reader.readLine();
            System.out.println("Client says : " + msg);
            reader.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void SocketClient(){
        try{
            Socket socket = new Socket("LocalHost" , 777);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("HEllo");
            writer.close();
            socket.close();
        }catch(Exception e){

        }
    }

    public static void datagram(){
        int port = 1898 ;
        try {
            DatagramSocket socket = new DatagramSocket(port) ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line ;

            while((line = reader.readLine()) != null){
                System.out.println("Helo");
            }
            socket.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // make a program for socket server and client
    
}
