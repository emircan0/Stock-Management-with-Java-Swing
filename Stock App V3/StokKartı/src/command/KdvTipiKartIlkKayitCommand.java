package command;

import model.KdvTipiModel;
import view.MainFrame;
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
        KdvTipiModel ilkKayit = kdvTipiModel.beforNextStock("first", kdvTipiModel.getKdvTipiID());
        if (ilkKayit != null) {
            kdvTipiKart.getTxtKdvKodu().setText(ilkKayit.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(ilkKayit.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(ilkKayit.getKdvTipiOrani()));
        } else {
            System.out.println("Veritabanında kayıtlı KDV Tipi bulunamadı.");
        }
    }
}
