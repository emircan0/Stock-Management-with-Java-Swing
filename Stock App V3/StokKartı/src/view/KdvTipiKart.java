
package view;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.ArrayList;
import model.KdvTipiModel;


public class KdvTipiKart extends javax.swing.JInternalFrame {
        private ArrayList<KdvTipiModel> kdvStoks;

    public KdvTipiModel model;
    public KdvTipiKart() {
        initComponents();  
        model = new KdvTipiModel("", "", Double.NaN);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtKdvAdı = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKdvOrani = new javax.swing.JTextField();
        btnKdvTipiEkle = new javax.swing.JButton();
        btnKdvTipiSil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtKdvKodu = new javax.swing.JTextField();
        btnİlk = new javax.swing.JButton();
        btnGeri = new javax.swing.JButton();
        btnİleri = new javax.swing.JButton();
        btnSon = new javax.swing.JButton();

        setClosable(true);
        setTitle("KDV Tipi Kart");

        jLabel2.setText("Kdv Adı");

        jLabel3.setText("Kdv Oranı");

        btnKdvTipiEkle.setText("Kaydet");

        btnKdvTipiSil.setText("Sil");

        jLabel1.setText("Kdv Kodu");

        btnİlk.setText("İlk Kayıt");
        btnİlk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Performed(evt);
            }
        });

        btnGeri.setText("Geri");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctionPerformed(evt);
            }
        });

        btnİleri.setText("İleri");

        btnSon.setText("Son Kayıt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnİlk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnGeri)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKdvKodu)
                                    .addComponent(txtKdvAdı)
                                    .addComponent(txtKdvOrani, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btnİleri)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSon))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnKdvTipiEkle)
                        .addGap(46, 46, 46)
                        .addComponent(btnKdvTipiSil)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnİlk)
                    .addComponent(btnİleri)
                    .addComponent(btnSon)
                    .addComponent(btnGeri))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKdvKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKdvAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKdvOrani, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKdvTipiEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKdvTipiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ctionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctionPerformed

    }//GEN-LAST:event_ctionPerformed

    private void Performed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Performed
    
    }//GEN-LAST:event_Performed

    public ArrayList<KdvTipiModel> getKdvStoks() {
        return kdvStoks;
    }

    public void setKdvStoks(ArrayList<KdvTipiModel> kdvStoks) {
        this.kdvStoks = kdvStoks;
    }
    
    public JButton getBtnGeri() {
        return btnGeri;
    }

    public void setBtnGeri(JButton btnGeri) {
        this.btnGeri = btnGeri;
    }

    public JButton getBtnKdvTipiEkle() {
        return btnKdvTipiEkle;
    }

    public void setBtnKdvTipiEkle(JButton btnKdvTipiEkle) {
        this.btnKdvTipiEkle = btnKdvTipiEkle;
    }

    public JButton getBtnKdvTipiSil() {
        return btnKdvTipiSil;
    }

    public void setBtnKdvTipiSil(JButton btnKdvTipiSil) {
        this.btnKdvTipiSil = btnKdvTipiSil;
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

    public JTextField getTxtKdvAdı() {
        return txtKdvAdı;
    }

    public void setTxtKdvAdı(JTextField txtKdvAdı) {
        this.txtKdvAdı = txtKdvAdı;
    }

    public JTextField getTxtKdvKodu() {
        return txtKdvKodu;
    }

    public void setTxtKdvKodu(JTextField txtKdvKodu) {
        this.txtKdvKodu = txtKdvKodu;
    }

    public JTextField getTxtKdvOrani() {
        return txtKdvOrani;
    }

    public void setTxtKdvOrani(JTextField txtKdvOrani) {
        this.txtKdvOrani = txtKdvOrani;
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGeri;
    public javax.swing.JButton btnKdvTipiEkle;
    public javax.swing.JButton btnKdvTipiSil;
    public javax.swing.JButton btnSon;
    public javax.swing.JButton btnİleri;
    public javax.swing.JButton btnİlk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField txtKdvAdı;
    public javax.swing.JTextField txtKdvKodu;
    public javax.swing.JTextField txtKdvOrani;
    // End of variables declaration//GEN-END:variables
}
