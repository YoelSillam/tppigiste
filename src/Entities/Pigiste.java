package Entities;

public class Pigiste
{
    private int numPigiste;
    private String nomPigiste;
    private double prixFeuillet;

    public Pigiste(int numPigiste, String nomPigiste, double prixFeuillet) {
        this.numPigiste = numPigiste;
        this.nomPigiste = nomPigiste;
        this.prixFeuillet = prixFeuillet;
    }

    public int getNumPigiste() {
        return numPigiste;
    }

    public String getNomPigiste() {
        return nomPigiste;
    }

    public double getPrixFeuillet() {
        return prixFeuillet;
    }
}
