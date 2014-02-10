package FromWeb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class SquareRootServer {
 
        /**
         * @param args
         */
        public static void main(String[] args)throws IOException {
                // TODO Auto-generated method stub
               
                final int SQRT_PORT=8888;
                ServerSocket server = new ServerSocket(SQRT_PORT);
               
                while(true)
                {
                        Socket s = server.accept();
                        System.out.println("Client Connected.");
                        SquareRootService service = new SquareRootService(s);
                        Thread t = new Thread(service);
                        t.start();
                }
 
        }
 
}
 