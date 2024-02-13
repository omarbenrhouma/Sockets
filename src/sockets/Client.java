package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Hashtable;

public class Client {
    public static void main(String[] args){

        try {
            Socket s = new Socket("localhost", 6500);

            InputStream in = s.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            final Hashtable <String,String> message = (Hashtable) ois.readObject();

            System.out.println(message.get("test"));



        }catch (IOException | ClassNotFoundException err){
            err.printStackTrace();
        }
    }

    }
