package controller;

import command.Command;
import command.GeneralListener;
import command.StokKartEkleCommand;
import command.StokKartGeriCommand;
import command.StokKartSilCommand;
import command.StokKartSonKayıtCommand;
import command.StokKartİleriCommand;
import command.StokKartİlkKayıtCommand;
import command.StokListCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import model.KdvTipiModel;
import model.StokKartModel;
import view.MainFrame;
import view.StokKart;
import view.StokList;

public class StokKartController implements Command {
    
    private StokKart stokKart;
    private StokList stokList;
    private MainFrame mainFrame;
    private StokKartModel stokKartModel;

    
    public StokKartController(MainFrame mainFrame, StokKart stokKart) {
        this.mainFrame = mainFrame;
        this.stokKart = stokKart;
    }

    public void execute() {
        this.stokList = new StokList();
        this.stokKart = new StokKart();                
        initializeListeners();
    }

    public void initializeListeners() {
        MainFrame.DesktopPane.add(stokKart);
        stokKart.setVisible(true);
        
        this.stokKartModel = new StokKartModel( "0",  "", 0,"","",0.0,"",""); 

        stokKart.btnAdd.addActionListener(new GeneralListener(new StokKartEkleCommand(stokKart)));
        stokKart.btnDel.addActionListener(new GeneralListener(new StokKartSilCommand(stokKart)));  
        stokKart.btnİleri.addActionListener(new GeneralListener(new StokKartİleriCommand(stokKart,stokKartModel)));
        stokKart.btnGeri.addActionListener(new GeneralListener(new StokKartGeriCommand(stokKart,stokKartModel)));
        stokKart.btnİlk.addActionListener(new GeneralListener(new StokKartİlkKayıtCommand(stokKart,stokKartModel)));
        stokKart.btnSon.addActionListener(new GeneralListener(new StokKartSonKayıtCommand(stokKart,stokKartModel)));
    }
}
