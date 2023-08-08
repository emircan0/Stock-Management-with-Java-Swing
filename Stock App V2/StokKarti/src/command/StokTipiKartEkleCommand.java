package command;

import dbHelper.DbHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.StokTipiModel;
import view.StokTipiKart;

public class StokTipiKartEkleCommand implements Command {

    private StokTipiModel stokTipiModel;
    private StokTipiKart stokTipiKart;

    public StokTipiKartEkleCommand(StokTipiKart stokTipiKart) {
        this.stokTipiKart = stokTipiKart;
    }

    @Override
    public void execute() {
        veritabaninaEkle();
    }

    private void veritabaninaEkle() {
        try {
            // Get the input data from the StokTipiKart view
            String stokTipiKodu = stokTipiKart.getTxtStokTipKodu().getText();
            String stokTipiAdi = stokTipiKart.getTxtStokTipAdi().getText();
            String stokTipiAciklama = stokTipiKart.getTxtStokTipAciklama().getText();

          
            stokTipiModel = new StokTipiModel(stokTipiKodu, stokTipiAdi, stokTipiAciklama);

            stokTipiModel.stokTipiVeritabaninaEkle();

            JOptionPane.showMessageDialog(null, "Stok Tipi başarıyla eklendi.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Stok Tipi eklenirken bir hata oluştu. Lütfen geçerli değerler girin.");
        }
    }
}
