package FromWeb;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class NumberClient {
 
        /**
         * @param args
         */
        public static void main(String[] args) throws IOException{
                // TODO Auto-generated method stub
               
               
                final int SQRT_PORT = 8888;
               
                Socket s = new Socket("localhost", SQRT_PORT);
                Scanner input = new Scanner(System.in);
                InputStream instream = s.getInputStream();
                Scanner in = new Scanner(instream);
                OutputStream outstream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outstream);
                System.out.print("Enter a number: ");
                double number = input.nextDouble();
                out.print(number);
                out.flush();
                double response = in.nextDouble();
                System.out.println(response);
               
       
        }
 
}