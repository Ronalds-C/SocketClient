package io.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientWrite implements Runnable {

	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String x = br.readLine();
				System.out.println("Server: " + x);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
