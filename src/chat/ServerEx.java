package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
    public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);
        try {
            server = new ServerSocket(9999);
            System.out.println("Waiting Connection..");
            socket = server.accept();
            System.out.println("Connected");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                String inMsg = in.readLine();
                if(inMsg.equalsIgnoreCase("quit")){
                    System.out.println("Disconnected");
                    break;
                }

                System.out.println("Client : "+ inMsg);
                System.out.print("Send: ");
                String outMsg = sc.nextLine();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
