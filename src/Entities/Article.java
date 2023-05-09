package Entities;

public class Article
{
    private int idArticle;
    private String titreArticle;
    private int nbFeuillets;

    public Article(int idArticle, String titreArticle, int nbFeuillets) {
        this.idArticle = idArticle;
        this.titreArticle = titreArticle;
        this.nbFeuillets = nbFeuillets;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public int getNbFeuillets() {
        return nbFeuillets;
    }
}
