package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(9080);
            while(!false) {
                System.out.println("Waiting For Clients");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client Is Connected");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
