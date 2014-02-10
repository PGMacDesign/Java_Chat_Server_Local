import java.io.*;
import java.util.*;
import java.net.*;
import static java.lang.System.out;

public class ChatServer {
	Vector<String> users = new Vector<String>();
	Vector<HandleClient> clients = new Vector<HandleClient>();

	//Use localhost under port 9000
	int PORT = 9000;
	int NumClients = 10;

	public void process() throws Exception {
		ServerSocket server = new ServerSocket(PORT , NumClients);
		out.println("Server Connected...");
		
		while( true) {
			Socket client = server.accept();
			HandleClient c = new HandleClient(client);
			clients.add(c);
		} 
	}

	public static void main(String ... args) throws Exception {
		new ChatServer().process();
	} 

	public void broadcast(String user, String message) {
		//Send message to all users
		for (HandleClient c : clients)
			if (!c.getUserName().equals(user)) {
				c.sendMessage(user,message);
			}
	}

	class HandleClient extends Thread {
		String name = "";
		BufferedReader input;
		PrintWriter output;

		public HandleClient(Socket client) throws Exception {
			//Get streams from both input and output
			input = new BufferedReader(new InputStreamReader(client.getInputStream())) ;
			output = new PrintWriter (client.getOutputStream(),true);
			output.println("Welcome to Patrick's Chat Server!\n");
			//Read name
			output.println("Please Enter a User Name: ");
			name = input.readLine();
			//Add name
			users.add(name);
			output.println("Welcome "+name+" we hope you enjoy your chat today");
			start();
		}

		public void sendMessage(String uname,String msg) {
			output.println( uname + ":" + msg);
		}

		public String getUserName() {
			return name;
		}

		public void run() {
			String line;
			String line2;
			try {
				while(true)
				{
					line = input.readLine();
					if("CHAT".equals(line)){
						output.println("Type what you want to say");
						line2 = input.readLine();
						output.println(line2);
					}
					if("LOGOUT".equals(line)) {
						output.println("Closing Connection . . . Goodbye");
						clients.remove(this);
						users.remove(name);
						break;
					}
					else if(name.equals(line)) {
						output.println("OK");
					}
					//Send messages to all
					broadcast(name,line); 
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} 
	}
}
