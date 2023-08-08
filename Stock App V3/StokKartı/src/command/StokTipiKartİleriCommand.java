package command;

import model.StokTipiModel;
import view.MainFrame;
import view.StokTipiKart;

public class StokTipiKartİleriCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;

    public StokTipiKartİleriCommand(StokTipiKart stokTipiKart, StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel nextStock = stokTipiModel.beforeNextStock("next", stokTipiModel.getStokTipiID());
        if (nextStock != null) {
            stokTipiKart.getTxtStokTipKodu().setText(nextStock.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(nextStock.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(nextStock.getStokTipiAciklama());
            stokTipiModel.setStokTipiID(nextStock.getStokTipiID());
        }
    }

    public StokTipiModel getStokTipiModel() {
        return stokTipiModel;
    }
}
