package command;

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
        StokTipiModel firstStock = stokTipiModel.beforeNextStock("first", 0);
        if (firstStock != null) {
            stokTipiKart.getTxtStokTipKodu().setText(firstStock.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(firstStock.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(firstStock.getStokTipiAciklama());
        }
    }
}
