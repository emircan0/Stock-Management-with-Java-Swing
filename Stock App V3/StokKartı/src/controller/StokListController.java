package controller;

import command.Command;
import command.ExcelCommand;
import command.EmailCommand;
import command.GeneralListener;
import command.MouseListenerCommand;
import command.PdfCommand;
import command.SearchCommand;
import command.StokListCommand;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StokListelemeModeli;
import view.MainFrame;
import view.StokKart;
import view.StokList;

public class StokListController implements Command {

    private MainFrame mainFrame;
    private StokList stokList;
    private StokKart stokKart;
    private ExcelCommand excel;
    private StokListCommand arrayListCont;
    private StokListelemeModeli stokModel;
    private StokListCommand stokListCommand;
    
     private String StokKodu;
    private String StokAdi;
    private int StokTipi;
    private String Birimi;
    private String Barkodu;
    private Double KDVTipi;
    private String Aciklama;
    private String Tarih;

    private int StokTipiId;
    private String StokTipiKodu;
    private String StokTipiAdi;
    private String StokTipiAciklama;

    private int KdvTipiID;
    private String KdvTipiKodu;
    private String KdvTipiAdi;
    private Double KdvTipiOrani;
    
    private DefaultTableModel model;

    public StokListController(MainFrame mainFrame,StokListelemeModeli stokModel, StokList stokList) {
        this.mainFrame = mainFrame;
        this.stokModel = new StokListelemeModeli(
         StokKodu,  StokAdi,  StokTipi,  Birimi,
             Barkodu,  KDVTipi,  Aciklama,  Tarih,  StokTipiId,
             StokTipiKodu,  StokTipiAdi,  StokTipiAciklama,  KdvTipiID,  KdvTipiKodu,
             KdvTipiAdi,  KdvTipiOrani
                
        );
        this.stokList = stokList;
        
    }

    public void execute() {
        this.stokList = new StokList();
        initializeListeners();
    }

    private void initializeListeners() {
        MainFrame.DesktopPane.add(stokList);
        stokList.setVisible(true);

        arrayListCont = new StokListCommand(stokList, stokModel, model);
        arrayListCont.execute(); // StokList'i doldurmak için execute yöntemini çağırıyoruz

        stokList.txtSearch.addKeyListener(new SearchCommand(stokList,stokKart));
        stokList.MenuItemStokKart.addActionListener(new GeneralListener (new StokKartController(mainFrame,stokKart)));
        stokList.MenuItemPdf.addActionListener(new GeneralListener(new PdfCommand(stokList)));

        ArrayList<StokListelemeModeli> stoks = stokModel.getStok();
        String filePath = "D:\\Work\\javaSwing\\file.xlsx";
        excel = new ExcelCommand(stoks, filePath);
        stokList.MenuItemExcel.addActionListener(new GeneralListener(new ExcelCommand(stoks, filePath)));

        String recipient = "smtp.gmail.com";
        String subject = "587";
        String body = "babamdosya@gmail.com";
        String attachmentPath = "tcbixenxstcvfuij";
        stokList.MenuItemMail.addActionListener(new GeneralListener(new EmailCommand(recipient, subject, body, attachmentPath,stokList)));

        stokList.tblStoklar.addMouseListener(new GeneralListener(new MouseListenerCommand(stokKart,stokList)));

    }

}
