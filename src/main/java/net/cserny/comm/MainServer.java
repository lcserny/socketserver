package net.cserny.comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(9090)) {
            while (true) {
                Socket socket = listener.accept();
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    out.println("Hello World!");
                }
            }
        }
    }
}
