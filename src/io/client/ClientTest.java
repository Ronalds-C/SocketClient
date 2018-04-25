package io.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Client started...");
		Socket socket = new Socket("localhost", 1234);

		ClientRead clientRead = new ClientRead();
		clientRead.setSocket(socket);
		Thread cRead = new Thread(clientRead);
		cRead.start();

		ClientWrite clientWrite = new ClientWrite();
		clientWrite.setSocket(socket);
		Thread cWrite = new Thread(clientWrite);
		cWrite.start();
	}
}
