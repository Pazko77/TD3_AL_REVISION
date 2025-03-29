package exo2.server;

import exo2.cours.Cours;
import exo2.services.ServiceInscription;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
    public static void main(String[] args)  {

        List<Cours> listCours = new ArrayList<Cours>();

        Cours cours0 = new Cours (1,"AppRefJavaLeCafe",30);
        Cours cours1 = new Cours (2,"AppRefCLaLettre",30);
        Cours cours2 = new Cours (3,"AppRefPythonLeSerpent",30);
        Cours cours3 = new Cours (4,"AppRefJavaLajava",30);
        Cours cours4 = new Cours (5,"AppRefQualiteNonRelationnelleAudela",30);

        listCours.add(cours0);
        listCours.add(cours1);
        listCours.add(cours2);
        listCours.add(cours3);
        listCours.add(cours4);

        try {
            ServerSocket serveur = new ServerSocket(1234);
            Socket client = serveur.accept(); //récupération par le serveur du socket client
            ServiceInscription serviceInscription = new ServiceInscription(client);
            serviceInscription.setCoursList(listCours);
            Thread t = new Thread(serviceInscription);    //lancer le service
            t.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
