package command;

import model.KdvTipiModel;
import view.KdvTipiKart;

public class KdvTipiKartSonKayitCommand implements Command {
    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartSonKayitCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel lastKdvTipi = KdvTipiModel.getLastKdvTipi();
        if (lastKdvTipi != null) {
            kdvTipiKart.getTxtKdvKodu().setText(lastKdvTipi.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(lastKdvTipi.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(String.valueOf(lastKdvTipi.getKdvTipiOrani()));
        }
    }
}

