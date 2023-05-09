package Tools;

import Entities.Article;
import Entities.Magazine;
import Entities.TotalPigiste;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel
{
    private String[] nomsColonnes;
    private Object[][] rows;
    
    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public String getColumnName(int index)
    {
        return nomsColonnes[index];
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    public void loadDatasMagazines(ArrayList<Magazine> desMagazines)
    {
        nomsColonnes = new String[]{"Numéro","Nom","La spécialité"};
        rows = new Object[desMagazines.size()][3];
        int i = 0;
        for(Magazine mag : desMagazines)
        {
            rows[i][0] = mag.getNumMagazine();
            rows[i][1] = mag.getNomMagazine();
            rows[i][2] = mag.getLaSpecialite();
            i++;
        }
        fireTableChanged(null);
    }
    public void loadDatasArticles(ArrayList<Article> desArticles)
    {
        nomsColonnes = new String[]{"Numéro","Titre","Nombre de feuillets"};
        rows = new Object[desArticles.size()][3];
        int i = 0;
        for(Article art : desArticles)
        {
            rows[i][0] = art.getIdArticle();
            rows[i][1] = art.getTitreArticle();
            rows[i][2] = art.getNbFeuillets();
            i++;
        }
        fireTableChanged(null);
    }
    public void loadDatasPigiste(ArrayList<TotalPigiste> desPigistes)
    {
        nomsColonnes = new String[]{"Nom","Montant"};
        rows = new Object[desPigistes.size()][2];
        int i = 0;
        for(TotalPigiste pig : desPigistes)
        {
            rows[i][0] = pig.getNomPigiste();
            rows[i][1] = pig.getTotal();
            i++;
        }
        fireTableChanged(null);
    }

}
