package Controlers;

import Entities.Article;
import Entities.Pigiste;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlArticle
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlArticle() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Article> GetAllArticlesByIdMagazine(int idMag)
    {
        ArrayList<Article> lesArticles = new ArrayList<>();
        // A vous de jouer
        try{
            ps = cnx.prepareStatement(" SELECT idArticle, titreArticle, nbFeuillets\n" +
                    "FROM `article` \n" +
                    "WHERE numMag = ? ");
            ps.setInt(1, idMag);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Article unArtcile = new Article(rs.getInt("idArticle"), rs.getString("titreArticle"), rs.getInt("nbFeuillets"));
                lesArticles.add(unArtcile);

            }
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql3");
        }
        return lesArticles;
    }
    public void AjouterNouvelArticle(String titre,int nbFeuillets,int numPigiste,int numMagazine)
    {
        try {
            ps = cnx.prepareStatement("insert into article values (?,?,?,?,?)");
            ps.setObject(1, null);
            ps.setString(2, titre);
            ps.setInt(3, nbFeuillets);
            ps.setInt(4, numPigiste);
            ps.setInt(5, numMagazine);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
