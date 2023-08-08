package command;

import dbHelper.DbHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KdvTipiModel;
import model.StokTipiModel;
import view.KdvTipiKart;
import view.MainFrame;
import view.StokKart;
import view.StokList;
import view.StokTipiKart;

/**
 *
 * @author emirc
 */
public class KdvTipiKartSilCommand implements Command {

    private KdvTipiKart kdvTipi;
    private StokList stokList;
    private KdvTipiKart kdvTipiKart;
    private StokListCommand arrayListCont;
    private KdvTipiModel kdvTipiModel;
    private MainFrame mainFrame;

    public KdvTipiKartSilCommand(KdvTipiKart kdvTipiKart) {
        this.kdvTipiKart = kdvTipiKart;
    }

    public void kdvVeriTabanıSil() {
        String kdvTipiKodu = kdvTipiKart.getTxtKdvKodu().getText();

        kdvTipiModel = new KdvTipiModel(kdvTipiKodu, null, null);

        kdvTipiModel.kdvVeritabaninaSil();

        JOptionPane.showMessageDialog(mainFrame, "Stok Tipi başarıyla silindi.");

    }

    @Override
    public void execute() {
        kdvVeriTabanıSil();
    }

}
