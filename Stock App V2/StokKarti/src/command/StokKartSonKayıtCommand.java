package command;

import model.StokKartModel;
import view.StokKart;

public class StokKartSonKayıtCommand implements Command {

    private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartSonKayıtCommand(StokKart stokKart, StokKartModel stokKartModel) {
        this.stokKart = stokKart;
        this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        StokKartModel lastStock = stokKartModel.getLastStock();
        if (lastStock != null) {
            stokKart.getTxtStokKodu().setText(lastStock.getStokKodu());
            stokKart.getTxtStokAdı().setText(lastStock.getStokAdi());
            stokKart.getBoxStokTipi().setSelectedItem(lastStock.getStokTipi());
            stokKart.getBoxBirimi().setSelectedItem(lastStock.getBirimi());
            stokKart.getTxtBarkodu().setText(lastStock.getBarkodu());
            stokKart.getBoxKDVTipi().setSelectedItem(lastStock.getKDVTipi());
            stokKart.getTxtAciklama().setText(lastStock.getAciklama());
            stokKart.getTxtTarih().setText(lastStock.getTarih());
        }
    }
}
