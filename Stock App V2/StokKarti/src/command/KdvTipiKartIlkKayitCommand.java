package command;

import model.KdvTipiModel;
import view.KdvTipiKart;

public class KdvTipiKartIlkKayitCommand implements Command {
    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartIlkKayitCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel firstKdvTipi = KdvTipiModel.getFirstKdvTipi();
        if (firstKdvTipi != null) {
            kdvTipiKart.getTxtKdvKodu().setText(firstKdvTipi.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(firstKdvTipi.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(String.valueOf(firstKdvTipi.getKdvTipiOrani()));
        }
    }
}
