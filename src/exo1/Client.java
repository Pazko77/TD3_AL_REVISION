package exo1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client  {
    private final int PORT = 1234;
    private String host = "localhost";
    private Socket socket;

    public Client() throws IOException {
        this.socket = new Socket(host,PORT);
    }

    public static void main(String[] args)  {
        try {
            Client client = new Client();
            //ecrire dans le tube
            PrintWriter out = new PrintWriter(client.getSocket().getOutputStream(), true);
            //lire dans le tube
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()));
            // clavier
            Scanner clavier = new Scanner(System.in);
            String line = "";

            System.out.println("Tapez une chaine de caractères :)");
            line = clavier.nextLine(); // recuperer l'information
            out.println(line); // envoyer l'info

            line = in.readLine(); // recuper la reponse du serveur
            System.out.println(line); // afficher la response


            in.close();
            out.close();
            client.close();


        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("le prog plant mais continue !");
        }
    }

    public int getPORT() {
        return PORT;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public void close() throws IOException {
        socket.close();
    }
}
