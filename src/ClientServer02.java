import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
//The number client
public class ClientServer02 {
 
        public static void main(String[] args) throws IOException{  
               
                final int SQRT_PORT = 5000;
               
                Socket s = new Socket("localhost", SQRT_PORT);
                Scanner input = new Scanner(System.in);
                InputStream instream = s.getInputStream();
                Scanner in = new Scanner(instream);
                OutputStream outstream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outstream);
                System.out.print("Enter a number: ");
                double number = input.nextDouble();
                System.out.println(number);
                out.print(number);
                out.flush();
                double response = in.nextDouble();
                System.out.println(response);
        }
}