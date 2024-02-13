package socketstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6500);
            Socket client = ss.accept();


            BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()));
            PrintStream ps = new PrintStream(client.getOutputStream());
            String messageFromClient = br.readLine();


            System.out.println("Message reçu du client : " + messageFromClient);

            System.out.println("Message intercepté avec succès !");

            ss.close();
            client.close();

        }catch (IOException err){
            err.printStackTrace();
        }
    }
}
