package net.cserny.comm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static final int port = 4444;
    private ServerSocket ss = null;

    public void  runServer() throws IOException, ClassNotFoundException{
        ss = new ServerSocket(port);
        System.out.println("System is ready to accept connections");
        Socket socket = ss.accept();

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        Message m = (Message) is.readObject();
        doSomething(m);

        os.writeObject(m);
        socket.close();
    }

    private void doSomething(Message m) {
        m.setResult(m.getA() * m.getB());
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new MainServer().runServer();
    }
}
