package command;

import model.KdvTipiModel;
import view.KdvTipiKart;
import javax.swing.JOptionPane;

public class KdvTipiKartGeriCommand implements Command {

    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartGeriCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel previousKdvTipi = kdvTipiModel.getAdjacentKdvTipi(kdvTipiModel.getKdvTipiID(), false);
        if (previousKdvTipi != null) {
            kdvTipiKart.getTxtKdvKodu().setText(previousKdvTipi.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(previousKdvTipi.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(previousKdvTipi.getKdvTipiOrani()));
            kdvTipiModel.setKdvTipiID(previousKdvTipi.getKdvTipiID());
        } else {
            // Eğer bir önceki KDV tipi yoksa veya hata oluşursa kullanıcıya bir hata iletisi gösterilmesi için kullanabilirsiniz.
            JOptionPane.showMessageDialog(kdvTipiKart, "Önceki KDV Tipi bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
