package net.cserny.comm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Welcome client");

        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");

        Message message = new Message(new Integer(15), new Integer(32));
        os.writeObject(message);
        System.out.println("Retrieving message from server...");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Message returnMessage = (Message) is.readObject();
        System.out.println("Return Message is=" + returnMessage);

        socket.close();
    }
}
