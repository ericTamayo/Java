import java.io.*;
import java.net.*;

public class socketServer{
	public static void main(String[] args) throws Exception {
		socketServer SERVER = new socketServer();
		SERVER.run();
	}

	public void run() throws Exception{
		ServerSocket SRVSOCK = new ServerSocket(444); //server socket
		Socket SOCK = SRVSOCK.accept(); //normal socket
		InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());//input stream
		BufferedReader BR = new BufferedReader(IR);

		String MESSAGE = BR.readLine(); //read line from stream, store in MESSAGE
		System.out.println(MESSAGE); //Print out read line

		if(MESSAGE != null){
			PrintStream PS = new PrintStream(SOCK.getOutputStream());//output stream
			PS.println("Message Recieved.");//prints to client
		}
	}
}