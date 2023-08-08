package command;

import model.StokTipiModel;
import view.StokTipiKart;
import javax.swing.JOptionPane;

public class StokTipiKartİleriCommand implements Command {

    private StokTipiKart stokTipiKart;
    private StokTipiModel stokTipiModel;

    public StokTipiKartİleriCommand(StokTipiKart stokTipiKart, StokTipiModel stokTipiModel) {
        this.stokTipiKart = stokTipiKart;
        this.stokTipiModel = stokTipiModel;
    }

    @Override
    public void execute() {
        StokTipiModel nextStokTipi = stokTipiModel.getAdjacentStokTipi(stokTipiModel.getStokTipiID(), true);
        if (nextStokTipi != null) {
            stokTipiKart.getTxtStokTipKodu().setText(nextStokTipi.getStokTipiKodu());
            stokTipiKart.getTxtStokTipAdi().setText(nextStokTipi.getStokTipiAdi());
            stokTipiKart.getTxtStokTipAciklama().setText(nextStokTipi.getStokTipiAciklama());
            stokTipiModel.setStokTipiID(nextStokTipi.getStokTipiID());
        } else {
            // Eğer bir sonraki stok tipi yoksa veya hata oluşursa kullanıcıya bir hata iletilmesi için kullanabilirsiniz.
            JOptionPane.showMessageDialog(stokTipiKart, "Sonraki Stok Tipi bulunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
