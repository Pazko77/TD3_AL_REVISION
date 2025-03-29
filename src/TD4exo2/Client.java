package TD4exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Client implements Runnable {
    private Socket socket;
    private int port;
    private String ip;

    public Client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        this.socket = new Socket(ip,port);
 //  url « BTTP:host:port » - par exemple « BTTP:localhost:1234 »
    }

    @Override
    public void run() {
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner sc = new Scanner(System.in);

                String line;

                System.out.println("tapez un text : ");
                line = sc.nextLine();
                out.println(line);

                line = in.readLine(); //retour du serv
                System.out.println(line);

                out.close();
                in.close();

            }catch (Exception e){
                System.out.println("Error: " + e+"on est gentil");
            }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
       String host = in.nextLine();
       int port = in.nextInt();
      //  Client client = new Client("localhost", 1234);
     //   new Thread(client).start();
        new Thread(new Client("localhost" , 1234)).start();
    }
}
