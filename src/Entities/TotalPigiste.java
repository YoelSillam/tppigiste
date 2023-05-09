package Entities;

public class TotalPigiste
{
    private String nomPigiste;
    private double total;

    public TotalPigiste(String unNom, double unTotal)
    {
        nomPigiste = unNom;
        total = unTotal;
    }

    public String getNomPigiste() {
        return nomPigiste;
    }

    public double getTotal() {
        return total;
    }
}
