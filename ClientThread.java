package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try
        {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello From The Server");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientInput = input.readLine();
                out.println(clientInput.toUpperCase());
                System.out.println(clientInput.toUpperCase());
                input.close();
                out.close();
                socket.close();

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
