package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StokTipiKart extends javax.swing.JInternalFrame {

    public StokTipiKart() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStokTipKodu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStokTipAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStokTipAciklama = new javax.swing.JTextField();
        btnStokTipiEkle = new javax.swing.JButton();
        btnStokTipiSil = new javax.swing.JButton();
        btnİlk = new javax.swing.JButton();
        btnGeri = new javax.swing.JButton();
        btnİleri = new javax.swing.JButton();
        btnSon = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Stok Tipi Kart");

        jLabel1.setText("Stop Tip Kodu");

        jLabel2.setText("Stok Tipi Adı");

        jLabel3.setText("Stok Tipi Açıklama");

        btnStokTipiEkle.setText("Kaydet");

        btnStokTipiSil.setText("Sil");

        btnİlk.setText("İlk Kayıt");

        btnGeri.setText("Geri");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriActionPerformed(evt);
            }
        });

        btnİleri.setText("İleri");
        btnİleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnİleriActionPerformed(evt);
            }
        });

        btnSon.setText("Son Kayıt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnStokTipiEkle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStokTipiSil)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtStokTipKodu, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(txtStokTipAdi)
                    .addComponent(txtStokTipAciklama))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnİlk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnGeri)
                .addGap(18, 18, 18)
                .addComponent(btnİleri)
                .addGap(18, 18, 18)
                .addComponent(btnSon)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnİlk)
                    .addComponent(btnİleri)
                    .addComponent(btnSon)
                    .addComponent(btnGeri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStokTipKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStokTipAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStokTipAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStokTipiEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStokTipiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeriActionPerformed

    private void btnİleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnİleriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnİleriActionPerformed

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

    public JButton getBtnStokTipiEkle() {
        return btnStokTipiEkle;
    }

    public void setBtnStokTipiEkle(JButton btnStokTipiEkle) {
        this.btnStokTipiEkle = btnStokTipiEkle;
    }

    public JButton getBtnStokTipiSil() {
        return btnStokTipiSil;
    }

    public void setBtnStokTipiSil(JButton btnStokTipiSil) {
        this.btnStokTipiSil = btnStokTipiSil;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JTextField getTxtStokTipAciklama() {
        return txtStokTipAciklama;
    }

    public void setTxtStokTipAciklama(JTextField txtStokTipAciklama) {
        this.txtStokTipAciklama = txtStokTipAciklama;
    }

    public JTextField getTxtStokTipAdi() {
        return txtStokTipAdi;
    }

    public void setTxtStokTipAdi(JTextField txtStokTipAdi) {
        this.txtStokTipAdi = txtStokTipAdi;
    }

    public JTextField getTxtStokTipKodu() {
        return txtStokTipKodu;
    }

    public void setTxtStokTipKodu(JTextField txtStokTipKodu) {
        this.txtStokTipKodu = txtStokTipKodu;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGeri;
    public javax.swing.JButton btnSon;
    public javax.swing.JButton btnStokTipiEkle;
    public javax.swing.JButton btnStokTipiSil;
    public javax.swing.JButton btnİleri;
    public javax.swing.JButton btnİlk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField txtStokTipAciklama;
    public javax.swing.JTextField txtStokTipAdi;
    public javax.swing.JTextField txtStokTipKodu;
    // End of variables declaration//GEN-END:variables
}
