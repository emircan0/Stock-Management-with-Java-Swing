package command;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.StokKartModel;
import view.StokList;

import javax.swing.table.DefaultTableModel;
import model.StokKartModel;
import view.StokList;

public class StokListCommand implements Command {

    private StokList stokList;

    public StokListCommand(StokList stokList) {
        this.stokList = stokList;
    }

    @Override
    public void execute() {
        // Verileri al
        List<StokKartModel> stoklar = StokKartModel.BindList();

        // Tabloyu temizle
        DefaultTableModel model = stokList.getModel();
        model.setRowCount(0);

        // Yeni verilerle tabloyu doldur
        for (StokKartModel stok : stoklar) {
            Object[] row = {
                stok.getStokKodu(),
                stok.getStokAdi(),
                stok.getStokTipi(),
                stok.getBirimi(),
                stok.getBarkodu(),
                stok.getKDVTipi(),
                stok.getAciklama(),
                stok.getTarih()
            };
            model.addRow(row);
        }
    }
}

