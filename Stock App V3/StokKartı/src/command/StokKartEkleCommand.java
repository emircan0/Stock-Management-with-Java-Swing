package command;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.StokListelemeModeli;
import model.StokKartModel;
import view.MainFrame;
import view.StokKart;
import view.StokList;

import java.sql.SQLException;
import java.util.ArrayList;

public class StokKartEkleCommand implements Command {

    private StokKartModel stokModel;
    private StokKart stokKart;

    public StokKartEkleCommand(StokKart stokKart) {
        this.stokKart = stokKart;
    }

    @Override
    public void execute() {
        stokModel = createStokModelFromInput();

        try {
            // Eğer aynı stok koduna sahip kayıt varsa güncelle
            boolean stokVarMi = stokKoduVarMi(stokModel.getStokKodu());

            if (stokVarMi) {
                // Stok modelini veritabanında güncelle
                stokModel.stokVeritabanindaGuncelle();
                JOptionPane.showMessageDialog(stokKart, "Güncellendi", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Stok modelini veritabanına ekle
                stokModel.stokVeritabaninaEkle();
                JOptionPane.showMessageDialog(stokKart, "Kayıt Oluşturuldu", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(stokKart, "Bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
        }

    }

    private boolean stokKoduVarMi(String stokKodu) throws SQLException {
        ArrayList<StokKartModel> stokList = StokKartModel.BindList();
        for (StokKartModel stok : stokList) {
            if (stok.getStokKodu().equals(stokKodu)) {
                return true;
            }
        }
        return false;
    }

    private StokKartModel createStokModelFromInput() {
        String stokKodu = stokKart.getTxtStokKodu().getText();
        String stokAdi = stokKart.getTxtStokAdı().getText();
        int stokTipi = Integer.parseInt(stokKart.getBoxStokTipi().getSelectedItem().toString());
        String birimi = stokKart.getBoxBirimi().getSelectedItem().toString();
        String barkodu = stokKart.getTxtBarkodu().getText();
        Double kdvTipi = Double.parseDouble(stokKart.getBoxKDVTipi().getSelectedItem().toString());
        String aciklama = stokKart.getTxtAciklama().getText();
        String tarih = stokKart.getTxtTarih().getText();

        return new StokKartModel(stokKodu, stokAdi, stokTipi, birimi, barkodu, kdvTipi, aciklama, tarih);
    }
}
