package exo2.cours;

import exo2.exceptions.PasAsseezDePlacesException;

public class Inscription implements Runnable {

    private final Cours cours;
    private final int nbPlaces;

    public Inscription(Cours cours, int nbPlaces) {
        this.cours = cours;
        this.nbPlaces = nbPlaces;
    }

    public void run() {
        synchronized (this) {
            try {
                cours.inscription(nbPlaces);
            } catch (PasAsseezDePlacesException e) {
                System.out.println(e);
            }
        }

    }

}
