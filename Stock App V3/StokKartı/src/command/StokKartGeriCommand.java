package command;


import model.StokKartModel;
import view.StokKart;


public class StokKartGeriCommand implements Command {

   private StokKart stokKart;
    private StokKartModel stokKartModel;

    public StokKartGeriCommand(StokKart stokKart, StokKartModel stokKartModel) {
       
       this.stokKart = stokKart;
       this.stokKartModel = stokKartModel;
    }

    @Override
    public void execute() {
        // İleri gitmek için bir sonraki stok verisini al
        StokKartModel previousStock = stokKartModel.beforNextStock("before", Integer.parseInt(stokKartModel.getStokKodu()));

        if (previousStock != null) {
            // Yeni stok verisini StokKart görünümüne yansıt
            stokKart.getTxtStokKodu().setText(previousStock.getStokKodu());
            stokKart.getTxtStokAdı().setText(previousStock.getStokAdi());
            stokKart.getBoxStokTipi().setSelectedItem(previousStock.getStokTipi());
            stokKart.getBoxBirimi().setSelectedItem(previousStock.getBirimi());
            stokKart.getTxtBarkodu().setText(previousStock.getBarkodu());
            stokKart.getBoxKDVTipi().setSelectedItem(previousStock.getKDVTipi());
            stokKart.getTxtAciklama().setText(previousStock.getAciklama());
            stokKart.getTxtTarih().setText(previousStock.getTarih());
            stokKartModel.setStokKodu(previousStock.getStokKodu());
        }
    }
        
    }
    
