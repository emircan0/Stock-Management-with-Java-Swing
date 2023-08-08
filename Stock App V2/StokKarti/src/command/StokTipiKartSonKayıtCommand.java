package command;

import view.StokTipiKart;
import model.StokTipiModel;

public class StokTipiKartSonKayıtCommand implements Command {

    private StokTipiKart stokTipiKart;

    public StokTipiKartSonKayıtCommand(StokTipiKart stokTipiKart) {
        this.stokTipiKart = stokTipiKart;
    }

    @Override
    public void execute() {
        StokTipiModel lastStokTipi = StokTipiModel.getLastStokTipi();
        if (lastStokTipi != null) {
            stokTipiKart.getTxtStokTipKodu().setText(lastStokTipi.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(lastStokTipi.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(lastStokTipi.getStokTipiAciklama());
        }
    }
}
