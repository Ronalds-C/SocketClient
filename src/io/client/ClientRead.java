package io.client;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientRead implements Runnable {

	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				String o = scanner.nextLine();

				OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
				PrintWriter pw = new PrintWriter(os);
				pw.println(o);
				os.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			scanner.close();
		}
	}

}
