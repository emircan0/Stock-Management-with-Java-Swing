package command;

import javax.swing.JOptionPane;
import model.StokTipiModel;
import view.StokTipiKart;

public class StokTipiKartSilCommand implements Command {

    private StokTipiModel stokTipiModel;
    private StokTipiKart stokTipiKart;

    public StokTipiKartSilCommand(StokTipiKart stokTipiKart) {
        this.stokTipiKart = stokTipiKart;
    }

    @Override
    public void execute() {
        veritabanindanSil();
    }

    private void veritabanindanSil() {
        String stokTipiKodu = stokTipiKart.getTxtStokTipKodu().getText();

        stokTipiModel = new StokTipiModel(stokTipiKodu, null, null);

        stokTipiModel.stokTipiVeritabanindanSil();

        JOptionPane.showMessageDialog(null, "Stok Tipi başarıyla silindi.");
    }
}
