package command;

import model.KdvTipiModel;
import model.StokKartModel;
import view.StokKart;

public class StokKartİleriCommand implements Command {

    private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartİleriCommand(StokKart stokKart, StokKartModel stokKartModel) {
        this.stokKart = stokKart;
        this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        // İleri gitmek için bir sonraki stok verisini al
        StokKartModel nextStock = stokKartModel.beforNextStock("next", Integer.parseInt(stokKartModel.getStokKodu()));

        if (nextStock != null) {
            // Yeni stok verisini StokKart görünümüne yansıt
            stokKart.getTxtStokKodu().setText(nextStock.getStokKodu());
            stokKart.getTxtStokAdı().setText(nextStock.getStokAdi());
            stokKart.getBoxStokTipi().setSelectedItem(nextStock.getStokTipi());
            stokKart.getBoxBirimi().setSelectedItem(nextStock.getBirimi());
            stokKart.getTxtBarkodu().setText(nextStock.getBarkodu());
            stokKart.getBoxKDVTipi().setSelectedItem(nextStock.getKDVTipi());
            stokKart.getTxtAciklama().setText(nextStock.getAciklama());
            stokKart.getTxtTarih().setText(nextStock.getTarih());
            stokKartModel.setStokKodu(nextStock.getStokKodu());
        }
    }
}
