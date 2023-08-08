package command;

import model.KdvTipiModel;
import view.MainFrame;
import view.KdvTipiKart;

public class KdvTipiKartGeriCommand implements Command {

    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    private String KdvTipiKodu;
    private String KdvTipiAdi;
    private Double KdvTipiOrani;

    public KdvTipiKartGeriCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel previousStock = kdvTipiModel.beforNextStock("before", kdvTipiModel.getKdvTipiID());
        if (previousStock != null) {
            kdvTipiKart.getTxtKdvKodu().setText(previousStock.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(previousStock.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(previousStock.getKdvTipiOrani()));
            kdvTipiModel.setKdvTipiID(previousStock.getKdvTipiID());
        }
    }

    public KdvTipiModel getKdvTipiModel() {
        return kdvTipiModel;
    }
}
