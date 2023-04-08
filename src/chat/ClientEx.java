package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
    public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 9999);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                System.out.print("Send: ");
                String outMsg = sc.nextLine();

                if(outMsg.equalsIgnoreCase("quit")){
                    out.write(outMsg + "\n" );
                    out.flush();
                    System.out.println("Disconnected");
                    break;
                }
                out.write(outMsg+"\n");
                out.flush();
                String inMsg = in.readLine();
                System.out.println("Server : "+ inMsg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                sc.close();
                in.close();
                out.close();
                socket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
