package exo2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private final int PORT = 1234;
    private String host  = "localhost";

    public Client() throws IOException {
        this.socket = new Socket(host, PORT);
    }

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public int getPORT() {
        return PORT;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host; //O:
    }

    public static void main(String[] args) {
        try{
            Client client = new Client();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(client.getSocket().getOutputStream(), true);
            Scanner clavier = new Scanner(System.in);

            // envoie la liste

           // String LaListDesCours = in.readLine();
          //  System.out.println("test");
//System.out.println(format(LaListDesCours));

            String request;
            System.out.println("ID cours : ");
            request = clavier.nextLine();
            out.println(request);
        // recuperer id

            System.out.println("nb places : ");
            request = clavier.nextLine();
            out.println(request);

            // recuper nb

            // inscrit(id, nb) -> rep

            // envoyer une rep
            String resp;
            resp = in.readLine(); //recup info du serveur
            System.out.println(resp); //afficher la reponse au client

            in.close();
            out.close();

        }catch ( Exception e){
            System.out.println(e.getMessage() +"Le prog plante mais il continue !");
        }
    }

    public static String format(String input){
        StringBuilder sb = new StringBuilder();
        for(String text : input.split(",")){
            sb.append(text).append("\n");
        }
        return sb.toString();
    }
}
/*package exo2client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class AppliClient {
    private static int PORT = 3000;
    private static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
            BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
            PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
            // Informe l'utilisateur de la connection
            System.out.println("Connect� au serveur " + socket.getInetAddress() + ":"+ socket.getPort());

            String line;
            line = sin.readLine(); // 1�re question
            System.out.println(line);
            // prompt d'invite � la saisie
            System.out.print("->");
            line = clavier.readLine();
            sout.println(line);
            line = sin.readLine(); // 2�me question
            System.out.println(line);
            // prompt d'invite � la saisie
            System.out.print("->");
            line = clavier.readLine();
            sout.println(line);

            System.out.println(sin.readLine()); // r�ponse finale

            socket.close();
        }
        catch (IOException e) { System.err.println("Fin du service"); }
        // Refermer dans tous les cas la socket
        try { if (socket != null) socket.close(); }
        catch (IOException e2) { ; }
    }

    private static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
*/