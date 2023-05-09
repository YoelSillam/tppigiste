package Entities;

public class Magazine
{
    private int numMagazine;
    private String nomMagazine;
    private String laSpecialite;

    public Magazine(int numMagazine, String nomMagazine, String laSpecialite) {
        this.numMagazine = numMagazine;
        this.nomMagazine = nomMagazine;
        this.laSpecialite = laSpecialite;
    }

    public int getNumMagazine() {
        return numMagazine;
    }

    public String getNomMagazine() {
        return nomMagazine;
    }

    public String getLaSpecialite() {
        return laSpecialite;
    }
}
