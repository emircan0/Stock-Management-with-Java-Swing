package command;

import model.KdvTipiModel;
import view.MainFrame;
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
        KdvTipiModel sonKayit = kdvTipiModel.beforNextStock("last", 0);
        if (sonKayit != null) {
            kdvTipiKart.getTxtKdvKodu().setText(sonKayit.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(sonKayit.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(sonKayit.getKdvTipiOrani()));
        } else {
            System.out.println("Veritabanında kayıtlı KDV Tipi bulunamadı.");
        }
    }
}
