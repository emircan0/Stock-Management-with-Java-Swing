package command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.StokList;
import view.StokKart;

public class SearchCommand implements KeyListener {

    private StokKart stokKart;
    private StokList stokList;
    private DefaultTableModel model;

    public SearchCommand(StokList stokList, StokKart stokKart) {
        this.stokList = stokList;
        this.stokKart = stokKart;
        model = (DefaultTableModel) stokList.tblStoklar.getModel();
    }

    public void txtSearchKeyReleased() {
        String searchKey = stokList.txtSearch.getText().trim();

        if (!searchKey.isEmpty()) {
            TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
            stokList.tblStoklar.setRowSorter(tableRowSorter);

            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("^" + searchKey + "$", 0);
            tableRowSorter.setRowFilter(rowFilter);

            int rowCount = stokList.tblStoklar.getRowCount();
            if (rowCount > 0) {
                stokList.tblStoklar.setRowSelectionInterval(0, 0);
            }
        } else {
            stokList.tblStoklar.setRowSorter(null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        txtSearchKeyReleased();
    }

}
