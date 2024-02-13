package socketstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 6500);

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps = new PrintStream(client.getOutputStream());


            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez un message à envoyer au serveur: ");
            String messageToSend = scanner.nextLine();


            ps.println(messageToSend);


            scanner.close();

            client.close();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
