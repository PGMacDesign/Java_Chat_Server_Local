import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
//The square root server
public class ClientServer03 {
 
        /**
         * @param args
         */
        public static void main(String[] args)throws IOException {
        	
                final int SQRT_PORT=5000;
                ServerSocket server = new ServerSocket(SQRT_PORT);
               
                while(true)
                {
                        Socket s = server.accept();
                        System.out.println("Client Connected.");
                        ClientServer04 service = new ClientServer04(s);
                        Thread t = new Thread(service);
                        t.start();
                }
        }
}