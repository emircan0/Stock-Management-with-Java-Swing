package command;

import command.Command;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import model.StokListelemeModeli;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import view.StokList;

public class EmailCommand implements Command {

    private String host;
    private String port;
    private String username;
    private String password;

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

    public EmailCommand(String host, String port, String username, String password, StokList stokList) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.stokList = stokList;
    }

    private byte[] generatePDF() throws JRException, IOException {
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

        // PDF oluşturma ve byteArrayOutputStream'a yazma
        byte[] pdfBytes;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            JasperExportManager.exportReportToPdfStream(filledReport, byteArrayOutputStream);
            pdfBytes = byteArrayOutputStream.toByteArray();
        }

        return pdfBytes;
    }

    public void sendEmail(String recipient, String subject, String body, byte[] pdfBytes) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smpt.ssl.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // E-posta metni
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            // PDF dosyası
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(new ByteArrayDataSource(pdfBytes, "application/pdf")));
            attachmentPart.setFileName("Stok.pdf");

            // E-posta içeriği oluşturma
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // E-postayı gönder
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        String recipient = "emircanmertt@gmail.com";
        String subject = "Stok Listesi";
        String body = "Merhaba, Stok listesi ekte bulunmaktadır.";

        try {
            byte[] pdfBytes = generatePDF();
            sendEmail(recipient, subject, body, pdfBytes);
        } catch (JRException ex) {
            Logger.getLogger(EmailCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
