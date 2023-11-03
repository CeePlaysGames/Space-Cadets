import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);      // Scanner for console input
        String userInput;
        byte[] bytes;
        boolean connectionOpen = true;

        try
        {
            Socket socket = new Socket("localhost", 1600);      // Creates the socket
            OutputStream out = socket.getOutputStream();        // Sets socket output stream

            System.out.println("Connection with server open.\nType /endconnection at any time to close the connection.\n");

            while (true)
            {
                userInput = consoleInput.nextLine();

                if (userInput.equals("/endconnection"))         // Client can close connection by typing '/endconnection'
                {
                    break;
                }

                userInput = userInput + "\n";
                bytes = userInput.getBytes();       // Converts user input into byte array out outputs it
                out.write(bytes);
            }

            System.out.println("Connection closed!");
            socket.close();         // Closes connection
        } catch (Exception e)
        {
            System.out.println("Something went wrong!");
            System.out.println(e.toString());
        }

    }
}