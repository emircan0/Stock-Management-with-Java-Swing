package command;

import model.KdvTipiModel;
import view.MainFrame;
import view.KdvTipiKart;

public class KdvTipiKartIleriCommand implements Command {

    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartIleriCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel nextStock = kdvTipiModel.beforNextStock("next", kdvTipiModel.getKdvTipiID());
        if (nextStock != null) {
            kdvTipiKart.getTxtKdvKodu().setText(nextStock.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(nextStock.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(nextStock.getKdvTipiOrani()));
            kdvTipiModel.setKdvTipiID(nextStock.getKdvTipiID());
        }
    }

    public KdvTipiModel getKdvTipiModel() {
        return kdvTipiModel;
    }
}
