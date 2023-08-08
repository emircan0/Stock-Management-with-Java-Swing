package command;

import model.StokTipiModel;
import view.MainFrame;
import view.StokTipiKart;

public class StokTipiKartGeriCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;

    public StokTipiKartGeriCommand(StokTipiKart stokTipiKart, StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel previousStock = stokTipiModel.beforeNextStock("before", stokTipiModel.getStokTipiID());
        if (previousStock != null) {
            stokTipiKart.getTxtStokTipKodu().setText(previousStock.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(previousStock.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(previousStock.getStokTipiAciklama());
            stokTipiModel.setStokTipiID(previousStock.getStokTipiID());
        }
    }

    public StokTipiModel getStokTipiModel() {
        return stokTipiModel;
    }
}
