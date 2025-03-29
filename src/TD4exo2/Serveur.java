package TD4exo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable{

    private ServerSocket serverSocket;
    private Class <? extends Service> service;


    public Serveur(Class< ? extends Service> service , int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.service = service;
    }

    @Override
    public void run() {
        try{
            Socket client = serverSocket.accept();
            //Service service1 = service.getConstructor(Socket.class).newInstance(client);
            new Thread(service.getConstructor(Socket.class).newInstance(client)).start();


        }catch(Exception e){
            e.printStackTrace();}
    }
    public  static void main(String[] args) throws IOException {
        new Thread(new Serveur(ServiceTxt.class, 1234)).start();
    }
}
