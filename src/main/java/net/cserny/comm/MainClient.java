package net.cserny.comm;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP address of a machine that is\n" +
                "running the date service on port 9090:"
        );
        Socket socket = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);

        System.exit(0);
    }
}
