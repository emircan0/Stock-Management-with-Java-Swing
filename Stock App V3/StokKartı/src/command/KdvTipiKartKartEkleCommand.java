package command;

import controller.KdvTipiKartController;
import controller.StokListController;
import dbHelper.DbHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.KdvTipiModel;
import view.StokList;
import view.StokKart;
import view.KdvTipiKart;
import view.MainFrame;

public class KdvTipiKartKartEkleCommand implements Command {

    private KdvTipiModel kdvTipiModel;
    private KdvTipiKart kdvTipiKart;
    private MainFrame mainFrame;

    public KdvTipiKartKartEkleCommand(KdvTipiKart kdvTipiKart) {
        this.kdvTipiKart = kdvTipiKart;

    }

    @Override
    public void execute() {
        VeritabaninaEkle();
    }

    private void VeritabaninaEkle() {
        try {

            String kdvTipiKodu = kdvTipiKart.getTxtKdvKodu().getText();
            String kdvTipiAdi = kdvTipiKart.getTxtKdvAdı().getText();
            String kdvTipiOraniText = kdvTipiKart.getTxtKdvOrani().getText();
            Double kdvTipiOrani = Double.parseDouble(kdvTipiOraniText);

            kdvTipiModel = new KdvTipiModel(kdvTipiKodu, kdvTipiAdi, kdvTipiOrani);

            kdvTipiModel.kdvVeritabaninaEkle();

            JOptionPane.showMessageDialog(mainFrame, "KDV Tipi başarıyla eklendi.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainFrame, "KDV Tipi Oranı geçersiz. Lütfen geçerli bir sayı girin.");
        }

    }

}
