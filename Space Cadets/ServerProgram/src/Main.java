import java.io.*;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {

        int nextCharacterInt;

        try{
            ServerSocket serverSocket = new ServerSocket(1600);     // Creates a ServerSocket on port 1600
            Socket socket = serverSocket.accept();      // Gets the Socket after the connection has been accepted
            InputStream in = socket.getInputStream();       // Sets the input stream of the socket

            nextCharacterInt = in.read();

            while (nextCharacterInt != -1)      // While the connection is open, output what the client types
            {
                System.out.print((char)nextCharacterInt);      // Outputs one byte at a time by converting it to char
                nextCharacterInt = in.read();
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong!");
            System.out.println(e.toString());
        }

        System.out.println("Client has disconnected.");

    }
}