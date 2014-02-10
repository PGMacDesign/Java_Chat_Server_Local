import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
//The square root service
public class ClientServer04 implements Runnable{
 
        private Socket s;
        private Scanner in;
        private PrintWriter out; 
       
        public ClientServer04(Socket aSocket)
        {
                s=aSocket;  
        }
       
        public void run()
        {
                try{
                        try{
                                in = new Scanner(s.getInputStream());
                                out = new PrintWriter(s.getOutputStream());
                                doService();
                        }
                finally
                {
                        s.close();
                               
                }
                }
                catch (IOException exception)
                {
                        exception.printStackTrace();
                }         
        }
       
        public void doService() throws IOException
        {
                while(true)
                {
                        if(!in.hasNextDouble()) return;
                        double number = in.nextDouble();
                        executeCommand(number);
                }
        }
       
        public void executeCommand(double number)
        {
                out.println(Math.sqrt(number));
                out.flush();
                return;  
        }
}