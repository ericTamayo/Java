import java.io.*;
import java.net.*;

public class socketClient{
	public static void main(String[] args) throws Exception {
		socketClient CLIENT = new socketClient();
		CLIENT.run();
	}

	public void run() throws Exception{
		Socket socket = new Socket("localhost",2000);
		PrintStream PS = new PrintStream(socket.getOutputStream());
		PS.println("Hello");

		InputStreamReader IR = new InputStreamReader(socket.getInputStream());
		BufferedReader BR = new BufferedReader(IR);

		String message = BR.readLine();
		System.out.println(message);
	}
}

