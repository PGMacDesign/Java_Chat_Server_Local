import java.io.*;
import java.net.Socket;
import java.util.*;

/*This program is an edited version of the WebGet program. 
 *It is edited so that it prints only the HTTP header
 */
public class WebGetEdit {
	
	public static void main(String[] args) throws IOException {
		//Get command line arguments
		
		String host;
		String resource;
		
		if (args.length ==2){
			host = args[0];
			resource = args[1];
		} else {
			System.out.println("Getting / from horstmann.com");
			host = "horstmann.com";
			resource = "/";
		}
		
		//open socket
		final int HTTP_PORT = 80;
		Socket s = new Socket(host, HTTP_PORT);
		
		//get Streams
		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();
		
		//streams into scanners and writers
		Scanner in = new Scanner(instream);
		PrintWriter out = new PrintWriter(outstream);
		
		//send command
		String command = "HEAD " + resource + " HTTP/1.1\n" + "Host: " + host + "\n\n";
		out.print(command);
		out.flush();
		
		//read server response
		while(in.hasNext()){
			String input = in.nextLine();
			if(input == "blank line"){
				break;
			} else {
				System.out.println(input);
			}	
		}	
		//Close the socket
		s.close();
	}
}
