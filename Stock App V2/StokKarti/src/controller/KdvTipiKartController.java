package controller;

import command.Command;
import command.ExcelCommand;
import command.GeneralListener;
import command.KdvTipiKartGeriCommand;
import command.KdvTipiKartIleriCommand;
import command.KdvTipiKartIlkKayitCommand;
import command.KdvTipiKartKartEkleCommand;
import command.KdvTipiKartSilCommand;
import command.KdvTipiKartSonKayitCommand;
import command.StokListCommand;
import model.KdvTipiModel;
import view.KdvTipiKart;
import model.StokListelemeModeli;
import view.MainFrame;
import view.StokKart;
import view.StokList;
import view.StokTipiKart;

public class KdvTipiKartController implements Command{
    private KdvTipiKart kdvTipiKart;
    private MainFrame mainFrame;
    private StokKart stokKart;
    private ExcelCommand excel;
    private StokTipiKart stokTipi;
    
    private KdvTipiModel kdvTipiModel;
 
    
    public KdvTipiKartController(MainFrame mainFrame,KdvTipiKart kdvTipiKart) {
        this.mainFrame = mainFrame;
        this.kdvTipiKart = kdvTipiKart;
    }
    
     public void execute() {
        this.kdvTipiKart = new KdvTipiKart();
        initializeListeners();
    }
    
  private void initializeListeners() {

                MainFrame.DesktopPane.add(kdvTipiKart);
                kdvTipiKart.setVisible(true);
                this.kdvTipiModel = new KdvTipiModel( "",  "",  0.0); 
                 
                kdvTipiKart.btnKdvTipiEkle.addActionListener(new GeneralListener(new KdvTipiKartKartEkleCommand (kdvTipiKart)));
                kdvTipiKart.btnKdvTipiSil.addActionListener(new GeneralListener(new KdvTipiKartSilCommand(kdvTipiKart)));
                kdvTipiKart.btnİleri.addActionListener(new GeneralListener(new KdvTipiKartIleriCommand(kdvTipiKart,kdvTipiModel)));
                kdvTipiKart.btnGeri.addActionListener(new GeneralListener(new KdvTipiKartGeriCommand(kdvTipiKart,kdvTipiModel)));
                kdvTipiKart.btnSon.addActionListener(new GeneralListener(new KdvTipiKartSonKayitCommand(kdvTipiKart,kdvTipiModel)));
                kdvTipiKart.btnİlk.addActionListener(new GeneralListener (new KdvTipiKartIlkKayitCommand(kdvTipiKart,kdvTipiModel)));

         
      
      
  }
  }
