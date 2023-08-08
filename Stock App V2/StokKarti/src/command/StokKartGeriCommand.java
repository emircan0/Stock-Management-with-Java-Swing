package command;

import model.StokKartModel;
import view.StokKart;
import javax.swing.JOptionPane;

public class StokKartGeriCommand implements Command {

    private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartGeriCommand(StokKart stokKart, StokKartModel stokKartModel) {
        this.stokKart = stokKart;
        this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        // Get the current stokKodu from the stokKartModel
        String currentStokKodu = stokKartModel.getStokKodu();

        if (currentStokKodu != null) {
            try {
                // Parse the stokKodu to an integer
                int currentStokKoduInt = Integer.parseInt(currentStokKodu);

                // Get the previous stock
                StokKartModel previousStock = stokKartModel.getAdjacentStock(currentStokKodu, false);

                if (previousStock != null) {
                    // Update the properties of stokKartModel directly with the values from previousStock
                    stokKartModel.setStokKodu(previousStock.getStokKodu());
                    stokKartModel.setStokAdi(previousStock.getStokAdi());
                    stokKartModel.setStokTipi(previousStock.getStokTipi());
                    stokKartModel.setBirimi(previousStock.getBirimi());
                    stokKartModel.setBarkodu(previousStock.getBarkodu());
                    stokKartModel.setKDVTipi(previousStock.getKDVTipi());
                    stokKartModel.setAciklama(previousStock.getAciklama());
                    stokKartModel.setTarih(previousStock.getTarih());

                    // Update the StokKart view with the previous stock data
                    stokKart.getTxtStokKodu().setText(previousStock.getStokKodu());
                    stokKart.getTxtStokAdı().setText(previousStock.getStokAdi());
                    stokKart.getBoxStokTipi().setSelectedItem(previousStock.getStokTipi());
                    stokKart.getBoxBirimi().setSelectedItem(previousStock.getBirimi());
                    stokKart.getTxtBarkodu().setText(previousStock.getBarkodu());
                    stokKart.getBoxKDVTipi().setSelectedItem(previousStock.getKDVTipi());
                    stokKart.getTxtAciklama().setText(previousStock.getAciklama());
                    stokKart.getTxtTarih().setText(previousStock.getTarih());
                }
            } catch (NumberFormatException ex) {
                // Handle the case where stokKartModel.getStokKodu() is not a valid integer
                // You can show an error message to the user here
                JOptionPane.showMessageDialog(stokKart, "Invalid Stok Kodu", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle the case where stokKartModel.getStokKodu() is null
            // You can show an error message to the user here
            JOptionPane.showMessageDialog(stokKart, "Stok Kodu is null", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
