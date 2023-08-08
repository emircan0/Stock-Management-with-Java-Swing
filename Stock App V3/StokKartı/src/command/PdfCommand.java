package command;

import view.StokList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StokListelemeModeli;

public class PdfCommand implements Command {

    private StokList stokList;

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

    public PdfCommand(StokList stokList) {
        this.stokList = stokList;
    }

    public void generatePDF() throws JRException, IOException, SQLException {
        StokListelemeModeli dataRetriever = new StokListelemeModeli(StokKodu, StokAdi, StokTipi, Birimi,
                Barkodu, KDVTipi, Aciklama, Tarih, StokTipiId,
                StokTipiKodu, StokTipiAdi, StokTipiAciklama, KdvTipiID, KdvTipiKodu,
                KdvTipiAdi, KdvTipiOrani);

        ArrayList<StokListelemeModeli> stoks = dataRetriever.getStok();

        List<Map<String, ?>> stockMaps = new ArrayList<>();
        for (StokListelemeModeli stok : stoks) {
            Map<String, Object> data = new HashMap<>();
            data.put("StokKodu", stok.getStokKodu());
            data.put("StokAdi", stok.getStokAdi());
            data.put("StokTipi", stok.getStokTipi());
            data.put("Birimi", stok.getBirimi());
            data.put("Barkodu", stok.getBarkodu());
            data.put("KDVTipi", stok.getKDVTipi());
            data.put("Aciklama", stok.getAciklama());
            data.put("OlusturmaTarihi", stok.getTarih());
            data.put("stokTipiId", stok.getStokTipiId());
            data.put("stokTipiKodu", stok.getStokTipiKodu());
            data.put("stokTipiAdi", stok.getStokTipiAdi());
            data.put("stokTipiAciklama", stok.getStokTipiAciklama());
            data.put("kdvTipiID", stok.getKdvTipiID());
            data.put("kdvTipiKodu", stok.getKdvTipiKodu());
            data.put("kdvTipiAdi", stok.getKdvTipiAdi());
            data.put("kdvTipiOrani", stok.getKdvTipiOrani());
            stockMaps.add(data);
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(stockMaps);
        String sourceName = "D:/Work/javaSwing/deneme.jrxml";

        JasperReport report = JasperCompileManager.compileReport(sourceName);
        JasperPrint filledReport = JasperFillManager.fillReport(report, null, dataSource);
        JasperViewer.viewReport(filledReport);
        stokList.pack();

        byte[] pdfBytes = JasperExportManager.exportReportToPdf(filledReport);
        String pdfPath = "D:/Work/javaSwing/Stok.pdf";
        FileOutputStream fos = new FileOutputStream(pdfPath);
        fos.write(pdfBytes);
        fos.close();
    }

    @Override
    public void execute() {
        try {
            generatePDF();
        } catch (JRException ex) {
            Logger.getLogger(PdfCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PdfCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PdfCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
