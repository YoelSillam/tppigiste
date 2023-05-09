package Controlers;

import Entities.Article;
import Entities.Magazine;
import Entities.Pigiste;
import Entities.TotalPigiste;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlPigiste
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPigiste()
    {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Pigiste> GetNomsPigistes()
    {
        ArrayList<Pigiste> lesNomDesPigistes = new ArrayList<>();
        // A vous de jouer
        try{
            ps = cnx.prepareStatement(" SELECT idPigiste, nomPigiste, prixFeuillet FROM pigiste ");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Pigiste unPigiste = new Pigiste(rs.getInt("idPigiste"), rs.getString("nomPigiste"), rs.getDouble("prixFeuillet"));
                lesNomDesPigistes.add(unPigiste);

            }
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql4");
        }
        return lesNomDesPigistes;
    }


    public ArrayList<TotalPigiste> GetAllPigisteByArticle(int idArticle)
    {
        ArrayList<TotalPigiste> lesPigistes = new ArrayList<>();
        // A vous de jouer
        try{
            ps = cnx.prepareStatement("select pigiste.nomPigiste, round(sum(pigiste.prixFeuillet * article.nbFeuillets),2) as total from pigiste inner join article on article.numPig = pigiste.idPigiste where article.numMag =? group by pigiste.nomPigiste");
            ps.setInt(1, idArticle);
            rs = ps.executeQuery();
            while (rs.next())
            {
                TotalPigiste unPigiste = new TotalPigiste(rs.getString("nomPigiste"), rs.getDouble("total"));
                lesPigistes.add(unPigiste);

            }
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql3");
        }
        return lesPigistes;
    }

    public String GetNomPigiste(int idArticle)
    {
        String Nom = "";

        // A vous de jouer
        try{
            ps = cnx.prepareStatement("SELECT idArticle, titreArticle, nbFeuillets, pigiste.nomPigiste\n" +
                    "FROM `article`\n" +
                    "INNER JOIN pigiste on pigiste.idPigiste = article.numPig\n" +
                    "WHERE idArticle =?");
            ps.setInt(1, idArticle);
            rs = ps.executeQuery();
            if (rs.next()) {
                Nom = rs.getString("nomPigiste");}
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql5");
        }

        return Nom;
    }
}
