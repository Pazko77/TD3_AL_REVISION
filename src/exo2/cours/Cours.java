package exo2.cours;

import exo2.exceptions.PasAsseezDePlacesException;

public class Cours {
    public Cours(int numeroCours, String intitule, int nbPlacesMax) {
        this.numeroCours = numeroCours;
        this.intitule = intitule;
        this.nbPlacesMax = nbPlacesMax;
        this.nbInscrits = 0;
    }

    private final int nbPlacesMax;

    private final int numeroCours;
    private final String intitule;
    private int nbInscrits;
    public void inscription(int nbPlaces) throws PasAsseezDePlacesException {
        synchronized (this) {
            if (this.nombrePlacesRestant() < nbPlaces)
                throw new PasAsseezDePlacesException(this, nbPlaces);
            this.nbInscrits += nbPlaces;
            System.out.println(nbPlaces + " inscriptions reussies au cours " + this);
            try {
                Thread.sleep(2);
            } catch (Exception ignored) {
            }
        }
    }

    private int nombrePlacesRestant() {
        return (this.nbPlacesMax - this.nbInscrits);
    }

    public int getNumeroCours() {
        return numeroCours;
    }

    @Override
    public String toString() {
        return this.numeroCours + " : " + intitule + " " + this.nombrePlacesRestant() + " places restants";
    }

}
