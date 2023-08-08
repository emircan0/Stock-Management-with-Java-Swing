
package controller;

import command.Command;
import command.GeneralListener;
import command.StokListCommand;
import command.StokTipiKartEkleCommand;
import command.StokTipiKartGeriCommand;
import command.StokTipiKartSilCommand;
import command.StokTipiKartSonKayıtCommand;
import command.StokTipiKartİleriCommand;
import command.StokTipiKartİlkKayıtCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.KdvTipiModel;
import model.StokTipiModel;
import view.KdvTipiKart;
import view.MainFrame;
import view.StokKart;
import view.StokList;
import view.StokTipiKart;


public class StokTipiKartController implements Command {
     private MainFrame mainFrame;
       private StokKart stokKart;
       private KdvTipiKart kdvTipi;
       private KdvTipiKart kdvKart;
       private StokTipiKart stokTipiKart;
       private StokTipiKart stokTipi;
       private StokTipiModel stokTipiModel;

    public StokTipiKartController(MainFrame mainFrame, StokTipiKart stokTipiKart){
      this.mainFrame = mainFrame;
      this.stokTipiKart = stokTipiKart;
        
    }
    
    @Override
    public void execute() {
        this.stokTipiKart = new StokTipiKart();
	initializeListeners();
    }
    
    
     private void initializeListeners() {
       
                
         MainFrame.DesktopPane.add(stokTipiKart);
         stokTipiKart.setVisible(true);
         this.stokTipiModel = new StokTipiModel( "",  "",  ""); 
         
         stokTipiKart.btnStokTipiEkle.addActionListener(new GeneralListener (new StokTipiKartEkleCommand(stokTipiKart)));
         stokTipiKart.btnStokTipiSil.addActionListener(new GeneralListener (new StokTipiKartSilCommand(stokTipiKart)));
         stokTipiKart.btnİleri.addActionListener(new GeneralListener (new StokTipiKartİleriCommand(stokTipiKart,stokTipiModel)));
         stokTipiKart.btnGeri.addActionListener(new GeneralListener (new StokTipiKartGeriCommand(stokTipiKart,stokTipiModel)));
         stokTipiKart.btnSon.addActionListener(new GeneralListener(new StokTipiKartSonKayıtCommand(stokTipiKart,stokTipiModel)));
         stokTipiKart.btnİlk.addActionListener(new GeneralListener(new StokTipiKartİlkKayıtCommand(stokTipiKart,stokTipiModel)));
 
     }

    
    
}
