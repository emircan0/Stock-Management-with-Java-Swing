package command;

import model.StokKartModel;
import view.StokKart;
import javax.swing.JOptionPane;

public class StokKartİleriCommand implements Command {

    private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartİleriCommand(StokKart stokKart, StokKartModel stokKartModel) {
        this.stokKart = stokKart;
        this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        try {
            // Get the next stock
            StokKartModel nextStock = stokKartModel.getAdjacentStock(stokKartModel.getStokKodu(), true);

            if (nextStock != null) {
                // Update the properties of stokKartModel directly with the values from nextStock
                stokKartModel.setStokKodu(nextStock.getStokKodu());
                stokKartModel.setStokAdi(nextStock.getStokAdi());
                stokKartModel.setStokTipi(nextStock.getStokTipi());
                stokKartModel.setBirimi(nextStock.getBirimi());
                stokKartModel.setBarkodu(nextStock.getBarkodu());
                stokKartModel.setKDVTipi(nextStock.getKDVTipi());
                stokKartModel.setAciklama(nextStock.getAciklama());
                stokKartModel.setTarih(nextStock.getTarih());

                // Update the StokKart view with the next stock data
                stokKart.getTxtStokKodu().setText(nextStock.getStokKodu());
                stokKart.getTxtStokAdı().setText(nextStock.getStokAdi());
                stokKart.getBoxStokTipi().setSelectedItem(nextStock.getStokTipi());
                stokKart.getBoxBirimi().setSelectedItem(nextStock.getBirimi());
                stokKart.getTxtBarkodu().setText(nextStock.getBarkodu());
                stokKart.getBoxKDVTipi().setSelectedItem(nextStock.getKDVTipi());
                stokKart.getTxtAciklama().setText(nextStock.getAciklama());
                stokKart.getTxtTarih().setText(nextStock.getTarih());
            }
        } catch (NumberFormatException ex) {
            // Handle the case where stokKartModel.getStokKodu() is not a valid integer
            // You can show an error message to the user here
            JOptionPane.showMessageDialog(stokKart, "Invalid Stok Kodu", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
