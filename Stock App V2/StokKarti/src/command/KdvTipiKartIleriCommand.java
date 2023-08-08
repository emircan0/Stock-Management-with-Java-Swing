package command;

import model.KdvTipiModel;
import view.KdvTipiKart;
import javax.swing.JOptionPane;

public class KdvTipiKartIleriCommand implements Command {

    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartIleriCommand(KdvTipiKart kdvTipiKart, KdvTipiModel kdvTipiModel) {
        this.kdvTipiKart = kdvTipiKart;
        this.kdvTipiModel = kdvTipiModel;
    }

    @Override
    public void execute() {
        KdvTipiModel nextKdvTipi = kdvTipiModel.getAdjacentKdvTipi(kdvTipiModel.getKdvTipiID(), true);
        if (nextKdvTipi != null) {
            kdvTipiKart.getTxtKdvKodu().setText(nextKdvTipi.getKdvTipiKodu());
            kdvTipiKart.getTxtKdvAdı().setText(nextKdvTipi.getKdvTipiAdi());
            kdvTipiKart.getTxtKdvOrani().setText(Double.toString(nextKdvTipi.getKdvTipiOrani()));
            kdvTipiModel.setKdvTipiID(nextKdvTipi.getKdvTipiID());
        } else {
            // Eğer bir sonraki KDV tipi yoksa veya hata oluşursa kullanıcıya bir hata iletisi gösterilmesi için kullanabilirsiniz.
            JOptionPane.showMessageDialog(kdvTipiKart, "Sonraki KDV Tipi bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
