package command;

import model.StokTipiModel;
import view.StokTipiKart;

public class StokTipiKartSonKayıtCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;
    
    public StokTipiKartSonKayıtCommand(StokTipiKart stokTipiKart,  StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel lastStock = stokTipiModel.beforeNextStock("last", 0);
        if (lastStock != null) {
            stokTipiKart.getTxtStokTipKodu().setText(lastStock.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(lastStock.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(lastStock.getStokTipiAciklama());
        }
    }
}
