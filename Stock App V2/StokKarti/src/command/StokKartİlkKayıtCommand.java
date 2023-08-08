package command;

import model.StokKartModel;
import model.StokTipiModel;
import view.StokKart;

public class StokKartİlkKayıtCommand implements Command {
    private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartİlkKayıtCommand(StokKart stokKart, StokKartModel stokKartModel) {
        this.stokKart = stokKart;
        this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        StokKartModel firstStock = StokKartModel.getFirstStock();
        if (firstStock != null) {
            stokKart.getTxtStokKodu().setText(firstStock.getStokKodu());
            stokKart.getTxtStokAdı().setText(firstStock.getStokAdi());
            stokKart.getBoxStokTipi().setSelectedItem(firstStock.getStokTipi());
            stokKart.getBoxBirimi().setSelectedItem(firstStock.getBirimi());
            stokKart.getTxtBarkodu().setText(firstStock.getBarkodu());
            stokKart.getBoxKDVTipi().setSelectedItem(firstStock.getKDVTipi());
            stokKart.getTxtAciklama().setText(firstStock.getAciklama());
            stokKart.getTxtTarih().setText(firstStock.getTarih());
        }
    }
}

