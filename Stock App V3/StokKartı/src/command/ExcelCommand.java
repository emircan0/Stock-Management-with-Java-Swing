package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import model.StokListelemeModeli;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommand implements Command {

    private ArrayList<StokListelemeModeli> stoks;
    private String filePath;

    public ExcelCommand(ArrayList<StokListelemeModeli> stoks, String filePath) {
        this.stoks = stoks;
        this.filePath = filePath;

    }

    public void excel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Stoklar");

        // Başlık satırını oluşturma
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Stok Kodu");
        headerRow.createCell(1).setCellValue("Stok Adı");
        headerRow.createCell(2).setCellValue("Stok Tipi");
        headerRow.createCell(3).setCellValue("Birimi");
        headerRow.createCell(4).setCellValue("Barkodu");
        headerRow.createCell(5).setCellValue("KDV Tipi");
        headerRow.createCell(6).setCellValue("Açıklama");
        headerRow.createCell(7).setCellValue("Oluşturma Tarihi");
        headerRow.createCell(8).setCellValue("stokTipiId");
        headerRow.createCell(9).setCellValue("stokTipiKodu");
        headerRow.createCell(10).setCellValue("stokTipiAdi");
        headerRow.createCell(11).setCellValue("stokTipiAciklama");
        headerRow.createCell(12).setCellValue("kdvTipiID");
        headerRow.createCell(13).setCellValue("kdvTipiKodu");
        headerRow.createCell(14).setCellValue("kdvTipiAdi");
        headerRow.createCell(15).setCellValue("kdvTipiOrani");

        // Veri satırlarını oluşturma
        int rowIndex = 1;
        for (StokListelemeModeli stok : stoks) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(stok.getStokKodu());
            dataRow.createCell(1).setCellValue(stok.getStokAdi());
            dataRow.createCell(2).setCellValue(stok.getStokTipi());
            dataRow.createCell(3).setCellValue(stok.getBirimi());
            dataRow.createCell(4).setCellValue(stok.getBarkodu());
            dataRow.createCell(5).setCellValue(stok.getKDVTipi());
            dataRow.createCell(6).setCellValue(stok.getAciklama());
            dataRow.createCell(7).setCellValue(stok.getTarih());
            dataRow.createCell(8).setCellValue(stok.getStokTipiId());
            dataRow.createCell(9).setCellValue(stok.getStokTipiKodu());
            dataRow.createCell(10).setCellValue(stok.getStokTipiAdi());
            dataRow.createCell(11).setCellValue(stok.getStokTipiAciklama());
            dataRow.createCell(12).setCellValue(stok.getKdvTipiID());
            dataRow.createCell(13).setCellValue(stok.getKdvTipiKodu());
            dataRow.createCell(14).setCellValue(stok.getKdvTipiAdi());
            dataRow.createCell(15).setCellValue(stok.getKdvTipiOrani());
        }

        // Excel dosyasını oluşturma ve kaydetme
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
            System.out.println("Veriler Excel dosyasına aktarıldı.");

            // Excel dosyasını açma
            Runtime.getRuntime().exec("cmd /c start " + filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void execute() {
        excel();
    }
}
