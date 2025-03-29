package exo1;

import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;


public class Serveur implements Runnable {

    protected ServerSocket serverSocket;
    protected int Port;
    protected Class <? extends Service> ServiceInversion;

    
    public Serveur(, int Port) {
        this.serverSocket = serverSocket;
        this.Port = Port;

    }

    @Override
    public void run() {
        try {
            ServerSocket serveur = new ServerSocket(1234);
            Socket client = serveur.accept(); //récupération par le serveur du socket client
            Thread t = new Thread(new ServiceInversion(client));    //lancer le service
            t.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {

    }
}
