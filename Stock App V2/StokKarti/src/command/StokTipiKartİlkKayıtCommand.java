package command;

import javax.swing.JOptionPane;
import model.StokTipiModel;
import view.StokTipiKart;

public class StokTipiKartİlkKayıtCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;

    public StokTipiKartİlkKayıtCommand(StokTipiKart stokTipiKart, StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel firstStock = stokTipiModel.getFirstStokTipi();
        if (firstStock != null) {
            stokTipiKart.getTxtStokTipKodu().setText(firstStock.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(firstStock.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(firstStock.getStokTipiAciklama());
            stokTipiModel.setStokTipiID(firstStock.getStokTipiID());
        } else {

             JOptionPane.showMessageDialog(stokTipiKart, "Stok Tipi bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
