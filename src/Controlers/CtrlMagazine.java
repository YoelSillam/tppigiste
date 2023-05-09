package Controlers;

import Entities.Article;
import Entities.Magazine;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CtrlMagazine
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMagazine() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Magazine> GetAllMagazines()
    {
        ArrayList<Magazine> lesMagazines = new ArrayList<>();
        // A vous de jouer
        try{
            ps = cnx.prepareStatement("SELECT idMag, nomMag, specialite.nomSpe FROM magazine INNER JOIN specialite on specialite.idSpe =  magazine.numSpecialite");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Magazine Magazine = new Magazine(rs.getInt("idMag"), rs.getString("nomMag"), rs.getString("nomSpe"));
                lesMagazines.add(Magazine);

            }
            ps.close();
            rs.close();
            }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql2");
        }
        return lesMagazines;
    }

    public double GetMontantMagazine(int idMag)
    {
        double montants = 0;

        // A vous de jouer
        try{
            ps = cnx.prepareStatement("SELECT magazine.nomMag, SUM(prixFeuillet*article.nbFeuillets) AS montant\n" +
                            "FROM pigiste\n" +
                            "INNER JOIN article ON article.numPig = pigiste.idPigiste\n" +
                            "INNER JOIN magazine ON magazine.idMag = article.numMag\n" +
                            "WHERE magazine.idMag = ?\n");
            ps.setInt(1, idMag);
            rs = ps.executeQuery();
            if (rs.next()) {
                montants = rs.getDouble("montant");}
            ps.close();
            rs.close();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erreur requete sql1");
        }

        return montants;
    }

}
