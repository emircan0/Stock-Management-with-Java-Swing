package command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import view.StokList;
import view.StokKart;

public class MouseListenerCommand implements Command {

    private StokKart stokKart;
    private StokList stokList;

    public MouseListenerCommand(StokKart stokKart, StokList stokList) {
        this.stokList = stokList;
        this.stokKart = stokKart;

    }

    @Override
    public void execute() {
        stokList.tblStoklar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRowIndex = stokList.tblStoklar.getSelectedRow();
                if (selectedRowIndex != -1) { // Bir satır seçildiyse
                    DefaultTableModel model = (DefaultTableModel) stokList.tblStoklar.getModel();

                    /* // Seçilen satırın bilgilerini text kutularına aktarma
                    stokKart.txtStokKodu.setText(model.getValueAt(selectedRowIndex, 0).toString());
                    stokKart.txtStokAdı.setText(model.getValueAt(selectedRowIndex, 1).toString());
                    stokKart.boxStokTipi.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
                    stokKart.boxBirimi.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
                    stokKart.txtBarkodu.setText(model.getValueAt(selectedRowIndex, 4).toString());
                    stokKart.boxKDVTipi.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
                    stokKart.txtAciklama.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    stokKart.txtTarih.setText(model.getValueAt(selectedRowIndex, 7).toString());*/
                } else {
                    stokList.tblStoklar.clearSelection();

                }
            }
        });
    }
}
