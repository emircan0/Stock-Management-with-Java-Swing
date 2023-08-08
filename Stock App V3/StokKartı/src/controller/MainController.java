package controller;

import command.GeneralListener;
import command.StokListCommand;
import model.StokListelemeModeli;
import view.KdvTipiKart;
import view.MainFrame;
import view.StokKart;
import view.StokList;
import view.StokTipiKart;



public class MainController {
    private MainFrame mainFrame;

    private StokList stokList;
    private StokListelemeModeli stokModel;
    
    private  StokKart stokKart;
    private StokListCommand stokListCommand;
    
    private StokTipiKart stokTipiKart;
    
    private KdvTipiKart kdvTipiKart;
      
    public MainController() {
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        initializeListeners();
    }


    private void initializeListeners() {

        mainFrame.popupList.addActionListener(new GeneralListener(new StokListController( mainFrame, stokModel, stokList)));
        mainFrame.popupKart.addActionListener(new GeneralListener(new StokKartController(mainFrame,stokKart)));
        mainFrame.popupStokTipi.addActionListener(new GeneralListener(new StokTipiKartController (mainFrame, stokTipiKart)));
        mainFrame.popupKdvTipi.addActionListener(new GeneralListener(new KdvTipiKartController(mainFrame,kdvTipiKart)));   
    }
}
