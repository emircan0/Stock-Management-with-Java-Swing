package command;

import model.StokTipiModel;
import view.StokTipiKart;
import javax.swing.JOptionPane;

public class StokTipiKartGeriCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;

    public StokTipiKartGeriCommand(StokTipiKart stokTipiKart, StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel previousStokTipi = stokTipiModel.getAdjacentStokTipi(stokTipiModel.getStokTipiID(), false);
        if (previousStokTipi != null) {
            stokTipiKart.getTxtStokTipKodu().setText(previousStokTipi.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(previousStokTipi.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(previousStokTipi.getStokTipiAciklama());
            stokTipiModel.setStokTipiID(previousStokTipi.getStokTipiID());
        } else {
            // Eğer bir önceki stok tipi yoksa veya hata oluşursa kullanıcıya bir hata iletilmesi için kullanabilirsiniz.
            JOptionPane.showMessageDialog(stokTipiKart, "Önceki Stok Tipi bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
