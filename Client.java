package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
    public static void main(String [] args)
    {
        try
        {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            Socket socket = new Socket(serverAddress, 9080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(input.readLine());
            out.println("This Was Sent from The Client");
            input.close();
            out.close();
            socket.close();

        }
        catch(Exception e)
        {
            System.out.println("Other exceptions " + e.toString());
        }
    }
}
