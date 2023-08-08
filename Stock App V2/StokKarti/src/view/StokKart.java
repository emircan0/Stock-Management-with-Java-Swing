
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.KdvTipiModel;
import model.StokTipiModel;

public class StokKart extends javax.swing.JInternalFrame {
   
    public StokKart() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        boxStokTipi = new javax.swing.JComboBox<>();
        boxBirimi = new javax.swing.JComboBox<>();
        boxKDVTipi = new javax.swing.JComboBox<>();
        txtTarih = new javax.swing.JFormattedTextField();
        lblCopy = new javax.swing.JLabel();
        txtCopy = new javax.swing.JTextField();
        btnCopy = new javax.swing.JButton();
        lblStokAdı = new javax.swing.JLabel();
        btnEkle = new javax.swing.JButton();
        txtStokAdı = new javax.swing.JTextField();
        txtStokKodu = new javax.swing.JTextField();
        lblStokKodu = new javax.swing.JLabel();
        lblStokTipi = new javax.swing.JLabel();
        lblBirimi = new javax.swing.JLabel();
        lblKDVTipi = new javax.swing.JLabel();
        txtBarkodu = new javax.swing.JTextField();
        lblBarkodu = new javax.swing.JLabel();
        lblAciklama = new javax.swing.JLabel();
        txtAciklama = new javax.swing.JTextField();
        lblTarihi = new javax.swing.JLabel();
        btnİlk = new javax.swing.JButton();
        btnGeri = new javax.swing.JButton();
        btnİleri = new javax.swing.JButton();
        btnSon = new javax.swing.JButton();

        setClosable(true);
        setTitle("Stok Kart");

        btnAdd.setText("Kaydet");

        btnDel.setText("Sil");

        boxStokTipi = new JComboBox<>();
        StokTipiModel.getStokipiList(boxStokTipi);
        boxStokTipi.setMaximumRowCount(50);

        boxBirimi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "G", "L", "ML", "M", "CM" }));

        boxKDVTipi = new JComboBox<>();
        KdvTipiModel.getKDVTipiList(boxKDVTipi);
        boxKDVTipi.setMaximumRowCount(50);

        lblCopy.setText("Stok Kodu Giriniz:");
        lblCopy.setToolTipText("");
        lblCopy.setVisible(false);

        txtCopy.setVisible(false);

        btnCopy.setText("Kopyala");
        btnCopy.setVisible(false);
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        lblStokAdı.setText("Stok Adı");

        btnEkle.setText("Hızlı Ekle");
        btnEkle.setVisible(false);

        lblStokKodu.setText("Stok Kodu");

        lblStokTipi.setText("Stok Tipi");

        lblBirimi.setText("Birimi");

        lblKDVTipi.setText("KDV Tipi");

        lblBarkodu.setText("Barkodu");

        lblAciklama.setText("Açıklama");

        lblTarihi.setText("Tarihi");

        btnİlk.setText("İlk Kayıt");

        btnGeri.setText("Geri");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriActionPerformed(evt);
            }
        });

        btnİleri.setText("İleri");

        btnSon.setText("Son Kayıt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boxStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBarkodu))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtAciklama, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTarih))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnİlk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGeri))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStokKodu, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(btnİleri)
                                .addGap(78, 78, 78)
                                .addComponent(btnSon))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boxKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnİlk)
                    .addComponent(btnİleri)
                    .addComponent(btnSon)
                    .addComponent(btnGeri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCopy))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeriActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCopyActionPerformed

    public JComboBox<String> getBoxBirimi() {
        return boxBirimi;
    }

    public void setBoxBirimi(JComboBox<String> boxBirimi) {
        this.boxBirimi = boxBirimi;
    }

    public JComboBox<String> getBoxKDVTipi() {
        return boxKDVTipi;
    }

    public void setBoxKDVTipi(JComboBox<String> boxKDVTipi) {
        this.boxKDVTipi = boxKDVTipi;
    }

    public JComboBox<String> getBoxStokTipi() {
        return boxStokTipi;
    }

    public void setBoxStokTipi(JComboBox<String> boxStokTipi) {
        this.boxStokTipi = boxStokTipi;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnCopy() {
        return btnCopy;
    }

    public void setBtnCopy(JButton btnCopy) {
        this.btnCopy = btnCopy;
    }

    public JButton getBtnDel() {
        return btnDel;
    }

    public void setBtnDel(JButton btnDel) {
        this.btnDel = btnDel;
    }

    public JButton getBtnEkle() {
        return btnEkle;
    }

    public void setBtnEkle(JButton btnEkle) {
        this.btnEkle = btnEkle;
    }

    public JButton getBtnGeri() {
        return btnGeri;
    }

    public void setBtnGeri(JButton btnGeri) {
        this.btnGeri = btnGeri;
    }

    public JButton getBtnSon() {
        return btnSon;
    }

    public void setBtnSon(JButton btnSon) {
        this.btnSon = btnSon;
    }


    public JButton getBtnİleri() {
        return btnİleri;
    }

    public void setBtnİleri(JButton btnİleri) {
        this.btnİleri = btnİleri;
    }

    public JButton getBtnİlk() {
        return btnİlk;
    }

    public void setBtnİlk(JButton btnİlk) {
        this.btnİlk = btnİlk;
    }

    public JLabel getLblBarkodu() {
        return lblBarkodu;
    }

    public void setLblBarkodu(JLabel lblBarkodu) {
        this.lblBarkodu = lblBarkodu;
    }

    public JLabel getLblCopy() {
        return lblCopy;
    }

    public void setLblCopy(JLabel lblCopy) {
        this.lblCopy = lblCopy;
    }

    public JLabel getLblStokKodu() {
        return lblStokKodu;
    }

    public void setLblStokKodu(JLabel lblStokKodu) {
        this.lblStokKodu = lblStokKodu;
    }

    public JTextField getTxtAciklama() {
        return txtAciklama;
    }

    public void setTxtAciklama(JTextField txtAciklama) {
        this.txtAciklama = txtAciklama;
    }

    public JTextField getTxtBarkodu() {
        return txtBarkodu;
    }

    public void setTxtBarkodu(JTextField txtBarkodu) {
        this.txtBarkodu = txtBarkodu;
    }

    public JTextField getTxtCopy() {
        return txtCopy;
    }

    public void setTxtCopy(JTextField txtCopy) {
        this.txtCopy = txtCopy;
    }

    public JTextField getTxtStokAdı() {
        return txtStokAdı;
    }

    public void setTxtStokAdı(JTextField txtStokAdı) {
        this.txtStokAdı = txtStokAdı;
    }

    public JTextField getTxtStokKodu() {
        return txtStokKodu;
    }

    public void setTxtStokKodu(JTextField txtStokKodu) {
        this.txtStokKodu = txtStokKodu;
    }

    public JFormattedTextField getTxtTarih() {
        return txtTarih;
    }

    public void setTxtTarih(JFormattedTextField txtTarih) {
        this.txtTarih = txtTarih;
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> boxBirimi;
    public javax.swing.JComboBox<String> boxKDVTipi;
    public javax.swing.JComboBox<String> boxStokTipi;
    public javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCopy;
    public javax.swing.JButton btnDel;
    private javax.swing.JButton btnEkle;
    public javax.swing.JButton btnGeri;
    public javax.swing.JButton btnSon;
    public javax.swing.JButton btnİleri;
    public javax.swing.JButton btnİlk;
    private javax.swing.JLabel lblAciklama;
    public javax.swing.JLabel lblBarkodu;
    private javax.swing.JLabel lblBirimi;
    private javax.swing.JLabel lblCopy;
    private javax.swing.JLabel lblKDVTipi;
    private javax.swing.JLabel lblStokAdı;
    public javax.swing.JLabel lblStokKodu;
    private javax.swing.JLabel lblStokTipi;
    private javax.swing.JLabel lblTarihi;
    public javax.swing.JTextField txtAciklama;
    public javax.swing.JTextField txtBarkodu;
    private javax.swing.JTextField txtCopy;
    public javax.swing.JTextField txtStokAdı;
    public javax.swing.JTextField txtStokKodu;
    public javax.swing.JFormattedTextField txtTarih;
    // End of variables declaration//GEN-END:variables
}
