package command;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.StokListelemeModeli;
import view.StokList;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.StokListelemeModeli;
import view.StokList;

public class StokListCommand implements Command {

    private StokList stokList;
    private StokListelemeModeli stokModel;
    private DefaultTableModel model;

    public StokListCommand(StokList stokList, StokListelemeModeli stokModel, DefaultTableModel model) {
        this.stokList = stokList;
        this.stokModel = stokModel;
        this.model = (DefaultTableModel) stokList.tblStoklar.getModel();
    }

    @Override
    public void execute() {
        listele();
    }

    void listele() {
        ArrayList<StokListelemeModeli> stockData = stokModel.getStok();
        model.setRowCount(0);

        for (StokListelemeModeli stockRow : stockData) {
            Vector<Object> row = new Vector<>();
            row.add(stockRow.getStokKodu());
            row.add(stockRow.getStokAdi());
            row.add(stockRow.getStokTipi());
            row.add(stockRow.getBirimi());
            row.add(stockRow.getBarkodu());
            row.add(stockRow.getKDVTipi());
            row.add(stockRow.getAciklama());
            row.add(stockRow.getTarih());
            row.add(stockRow.getStokTipiId());
            row.add(stockRow.getStokTipiKodu());
            row.add(stockRow.getStokTipiAdi());
            row.add(stockRow.getStokTipiAciklama());
            row.add(stockRow.getKdvTipiID());
            row.add(stockRow.getKdvTipiKodu());
            row.add(stockRow.getKdvTipiAdi());
            row.add(stockRow.getKdvTipiOrani());

            model.addRow(row);
        }
    }
}
