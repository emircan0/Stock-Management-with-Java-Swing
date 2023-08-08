package command;

import javax.swing.JOptionPane;
import model.StokKartModel;
import view.MainFrame;
import view.StokKart;

public class StokKartSilCommand implements Command {

    private StokKartModel stokModel;
    private StokKart stokKart;

    public StokKartSilCommand(StokKart stokKart) {
        this.stokKart = stokKart;
    }

    @Override
    public void execute() {
        // Silinecek stok modelini oluştur
        stokModel = createStokModelFromInput();

        // Stok modelini veritabanından sil
        stokModel.stokVeritabanindanSil();

        JOptionPane.showMessageDialog(stokKart, "Silindi", "Uyarı", JOptionPane.INFORMATION_MESSAGE);

    }

    private StokKartModel createStokModelFromInput() {
        String stokKodu = stokKart.getTxtStokKodu().getText();
        return new StokKartModel(stokKodu, null, 0, null, null, 0.0, null, null);
    }
}
