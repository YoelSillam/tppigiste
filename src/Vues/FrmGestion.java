package Vues;

import Controlers.CtrlArticle;
import Controlers.CtrlMagazine;
import Controlers.CtrlPigiste;
import Entities.Pigiste;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class FrmGestion extends JFrame {

    private JPanel rootPane;
    private JLabel lblTitre;
    private JLabel lblMagazine;
    private JTextField txtMontantMagazine;
    private JTextField txtNomPigiste;
    private JButton btnAjouter;
    private JLabel lblMontant;
    private JLabel lblPigiste;
    private JLabel lblAjouter;
    private JLabel lblTitreArticle;
    private JLabel lblChoixPigiste;
    private JLabel lblNbFeuillets;
    private JTextField txtTitreArticle;
    private JComboBox cboPigistes;
    private JSpinner spNbFeuillets;
    private JLabel lblArticle;
    private JTable tblTotauxPigistes;
    private JTable tblMagazines;
    private JTable tblArticles;
    ModelJTable mdl;
    CtrlArticle ctrlArtcile;
    CtrlMagazine ctrlMagazine;
    //Classe-> CtrlActivite et nom objet -> ctrlActivite
    CtrlPigiste ctrlPigiste;

    ConnexionBDD cnx;
    public FrmGestion() throws SQLException, ClassNotFoundException {
        this.setTitle("Gestion");
        this.setContentPane(rootPane);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        cnx = new ConnexionBDD();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // A vous de jouer
                mdl = new ModelJTable();
              //  ctrlArtcile = new CtrlArticle();
                ctrlMagazine= new CtrlMagazine();
                ctrlMagazine.GetAllMagazines();
                mdl.loadDatasMagazines(ctrlMagazine.GetAllMagazines());
                tblMagazines.setModel(mdl);

                ctrlPigiste = new CtrlPigiste();

                for (Pigiste pigiste:ctrlPigiste.GetNomsPigistes())
                {
                    cboPigistes.addItem(pigiste.getNomPigiste());
                }

            }
        });
        tblMagazines.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer
                int numArticle = Integer.parseInt(tblMagazines.getValueAt(tblMagazines.getSelectedRow(), 0).toString());
                mdl = new ModelJTable();
                ctrlArtcile = new CtrlArticle();
                mdl.loadDatasArticles(ctrlArtcile.GetAllArticlesByIdMagazine(numArticle));
                tblArticles.setModel(mdl);
                ctrlMagazine = new CtrlMagazine();
                txtMontantMagazine.setText(String.valueOf(ctrlMagazine.GetMontantMagazine(numArticle)));
                int numPigiste = Integer.parseInt(tblMagazines.getValueAt(tblMagazines.getSelectedRow(), 0).toString());
                mdl = new ModelJTable();
                ctrlPigiste = new CtrlPigiste();
                mdl.loadDatasPigiste(ctrlPigiste.GetAllPigisteByArticle(numPigiste));
                tblTotauxPigistes.setModel(mdl);

            }
        });
        tblArticles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer
                int numArticle = Integer.parseInt(tblArticles.getValueAt(tblArticles.getSelectedRow(), 0).toString());
                mdl = new ModelJTable();
                ctrlPigiste = new CtrlPigiste();
                txtNomPigiste.setText(String.valueOf(ctrlPigiste.GetNomPigiste(numArticle)));

            }
        });
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // A vous de jouer

            }
        });
    }
}
