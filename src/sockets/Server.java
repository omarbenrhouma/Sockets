package sockets;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(6500);

            System.out.println("Attente de connexion du client...");

            Socket client = s.accept();

            System.out.println("Client connecté avec succès!");

            Hashtable<String, String> message = new Hashtable<>();
            message.put("test", "message recu");

            OutputStream out = client.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(message);

            client.close();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
