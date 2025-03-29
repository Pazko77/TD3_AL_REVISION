package exo2.services;

import exo2.cours.Cours;
import exo2.exceptions.PasAsseezDePlacesException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServiceInscription implements Runnable{
    private Socket socket;
    private static List<Cours> coursList;

    public ServiceInscription(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(listFormat());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(listFormat()); // ecrire cote client ma liste
            String idCours = in.readLine();
            String nbPlace = in.readLine();
            Cours cours = findCoursById(Integer.parseInt(idCours));
            String reponse;

            if (cours != null){
                try {
                    cours.inscription(Integer.parseInt(nbPlace));
                    reponse = "Inscription OK GOOD JOB";
                }catch (PasAsseezDePlacesException e) {
                    reponse = e.getMessage();
                }
            }
            else {
                reponse = "Cours not found TRY AGAIN NEXT TIME LOOSER";                       //Vanessa
            }
            out.println(reponse);
        }
        catch (IOException e) {
            System.out.println("A l'aide");
        }


    }
    public void setCoursList(List<Cours> coursList){
        this.coursList = coursList;
    }

    public String listFormat(){
        StringBuilder sb = new StringBuilder();
        for(Cours cours : coursList){
            sb.append(cours.toString()).append(",");
        }
        return sb.toString();
    }

    public Cours findCoursById(int id) {
        for (Cours cours : coursList)
            if(id == cours.getNumeroCours()){
                return cours;
            }
        return null;
    }
}
