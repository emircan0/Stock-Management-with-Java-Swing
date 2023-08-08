package command;

import model.KdvTipiModel;
import view.KdvTipiKart;
import javax.swing.JOptionPane;
import model.StokKartModel;

public class KdvTipiKartSilCommand implements Command {

    private KdvTipiKart kdvTipiKart;
    private KdvTipiModel kdvTipiModel;

    public KdvTipiKartSilCommand(KdvTipiKart kdvTipiKart) {
        this.kdvTipiKart = kdvTipiKart;
    }

    @Override
    public void execute() {
        // Silinecek stok modelini oluştur
        kdvTipiModel = createStokModelFromInput();

        // Stok modelini veritabanından sil
        kdvTipiModel.kdvVeritabaninaSil();

        JOptionPane.showMessageDialog(kdvTipiKart, "Silindi", "Uyarı", JOptionPane.INFORMATION_MESSAGE);

    }

    private KdvTipiModel createStokModelFromInput() {
        String kdvTipiKodu = kdvTipiKart.getTxtKdvKodu().getText();
        return new KdvTipiModel( kdvTipiKodu,  null, 0.0);
    }
}
