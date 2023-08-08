package stok;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;

public class Stoklar extends javax.swing.JFrame implements MouseListener{
    
    DefaultTableModel model;
    public Stoklar() {
        initComponents();
        addTableSelectionListener();
        populateTable();
        tblStoklar.addMouseListener(this);
    }

    private void addStokToDatabasee(Object[] rowData) {
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    
    try {
        connection = dbHelper.getConnection();
        String sql = "INSERT INTO alanadi (StokKodu, StokAdi, StokTipi, Birimi, Barkodu, KDVTipi, Aciklama, OlusturmaTarihi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, rowData[0].toString());
        statement.setString(2, rowData[1].toString());
        statement.setString(3, rowData[2].toString());
        statement.setString(4, rowData[3].toString());
        statement.setString(5, rowData[4].toString());
        statement.setString(6, rowData[5].toString());
        statement.setString(7, rowData[6].toString());
        statement.setString(8, rowData[7].toString());
        
        int affectedRows = statement.executeUpdate();
        populateTable(); // Tabloyu güncelle
    } catch (Exception ex) {
        dbHelper.showErrorMessage((SQLException) ex);
    } finally {
        // Kaynakları kapatma
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


   private void addStokToDatabase(Object[] rowData) throws SQLException {
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    
    try {
        connection = dbHelper.getConnection();
        String sql = "INSERT INTO alanadi (StokKodu, StokAdi, StokTipi, Birimi, Barkodu, KDVTipi, Aciklama, OlusturmaTarihi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, txtStokKodu.getText());
        statement.setString(2, txtStokAdı.getText());
        statement.setString(3, boxStokTipi.getSelectedItem().toString());
        statement.setString(4, boxBirimi.getSelectedItem().toString());
        statement.setString(5, txtBarkodu.getText());
        statement.setString(6, boxKDVTipi.getSelectedItem().toString());
        statement.setString(7, txtAciklama.getText());
        statement.setString(8, txtTarih.getText());

        int result = statement.executeUpdate(); 

        populateTable(); // Tabloyu güncelle
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    } finally {
        // Kaynakları kapatma
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    

   public void populateTable(){ 
        model = (DefaultTableModel)tblStoklar.getModel();
        model.setRowCount(0);
        try{
            ArrayList<Stok> stoks = getStok();
            for(Stok stok : stoks){    
            Object[] row = {stok.getStokKodu(),stok.getStokAdi(),stok.getStokTipi(),
            stok.getBirimi(),stok.getBarkodu(),stok.getKDVTipi(), stok.getAciklama(),stok.getTarih()};
            model.addRow(row);   
    }
        }
        catch(SQLException ex){
            
        }
   }
    private void refreshTable() {
        model.setRowCount(0); // Tablonun tüm satırlarını temizle
        populateTable();
    }


        
    public ArrayList<Stok> getStok() throws SQLException{
        Connection connection =null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Stok> stoks = null;
        
        
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM alanadi;");
            stoks = new ArrayList<Stok>();
            while(resultSet.next()){
                stoks.add(new Stok(
                        resultSet.getString("StokKodu"),
                        resultSet.getString("StokAdi"),
                        resultSet.getInt("StokTipi"),
                        resultSet.getString("Birimi"),
                        resultSet.getString("Barkodu"),
                        resultSet.getDouble("KDVTipi"),
                        resultSet.getString("Aciklama"),
                        resultSet.getString("OlusturmaTarihi")

                ));                        
            }
        }catch(SQLException e) {
            dbHelper.showErrorMessage(e);
        }
        finally{
             statement.close();
             connection.close();
        }
        return stoks;
        
    }
    
     @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) { // Sağ tıklama kontrolü
        int[] selectedRows = tblStoklar.getSelectedRows(); // Seçili satırların indekslerini al
        int[] selectedColumns = tblStoklar.getSelectedColumns(); // Seçili sütunların indekslerini al
        
        if (selectedRows.length > 0 && selectedColumns.length > 0) { // En az bir satır ve bir sütun seçiliyse
            StringBuilder data = new StringBuilder();
            
            for (int row : selectedRows) {
                for (int col : selectedColumns) {
                    Object value = tblStoklar.getValueAt(row, col); // Hücrenin değerini al
                    if (value != null) {
                        data.append(value.toString()).append("\t"); // Değeri veriye ekle
                    }
                }
                data.append("\n"); // Satır sonu karakteri ekle
            }
            
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // Clipboard nesnesini al
            StringSelection selection = new StringSelection(data.toString()); // Kopyalanacak veriyi StringSelection nesnesine ekle
            clipboard.setContents(selection, null); // Clipboard'e veriyi kopyala
            
            JOptionPane.showMessageDialog(null, "Veri kopyalandı:\n" + data.toString());
        }
    }
    }
    
        @Override
        public void mousePressed(MouseEvent e) {}
    
        @Override
        public void mouseReleased(MouseEvent e) {}
    
        @Override
        public void mouseEntered(MouseEvent e) {}
    
        @Override
        public void mouseExited(MouseEvent e) {}
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStoklar = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblStokAdı = new javax.swing.JLabel();
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
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnUpd = new javax.swing.JButton();
        boxStokTipi = new javax.swing.JComboBox<>();
        boxBirimi = new javax.swing.JComboBox<>();
        boxKDVTipi = new javax.swing.JComboBox<>();
        txtTarih = new javax.swing.JFormattedTextField();
        lblCopy = new javax.swing.JLabel();
        txtCopy = new javax.swing.JTextField();
        btnCopy = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStoklar.setAutoCreateRowSorter(true);
        tblStoklar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama", "Oluşturma Tarihi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStoklar);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Arama Çubuğu");

        lblStokAdı.setText("Stok Adı");

        txtStokKodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokKoduActionPerformed(evt);
            }
        });

        lblStokKodu.setText("Stok Kodu");

        lblStokTipi.setText("Stok Tipi");

        lblBirimi.setText("Birimi");

        lblKDVTipi.setText("KDV Tipi");

        lblBarkodu.setText("Barkodu");

        lblAciklama.setText("Açıklama");

        lblTarihi.setText("Tarihi");

        btnAdd.setText("Ekle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setText("Sil");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnUpd.setText("Güncelle");
        btnUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdActionPerformed(evt);
            }
        });

        boxStokTipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        boxStokTipi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxStokTipiActionPerformed(evt);
            }
        });

        boxBirimi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "G", "L", "ML", "M", "CM" }));
        boxBirimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBirimiActionPerformed(evt);
            }
        });

        boxKDVTipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        boxKDVTipi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxKDVTipiActionPerformed(evt);
            }
        });

        lblCopy.setText("Stok Kodu Giriniz:");
        lblCopy.setToolTipText("");
        lblCopy.setVisible(false);

        txtCopy.setVisible(false);

        btnCopy.setText("Kopyala");
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        btnEkle.setText("Hızlı Ekle");
        btnEkle.setVisible(false);
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStokKodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(lblKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(lblStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxStokTipi, 0, 269, Short.MAX_VALUE)
                                    .addComponent(txtAciklama))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTarih)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStokAdı, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(boxStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxKDVTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBarkodu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
         String searchKey = txtSearch.getText().trim();
    
    if (!searchKey.isEmpty()) {
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblStoklar.setRowSorter(tableRowSorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("^" + searchKey + "$", 0);
        tableRowSorter.setRowFilter(rowFilter);
        
        int rowCount = tblStoklar.getRowCount();
        if (rowCount > 0) {
            tblStoklar.setRowSelectionInterval(0, 0); // İlk satırı seç
            int selectedRow = tblStoklar.getSelectedRow();
            showSelectedRowData(selectedRow);
        }
    } else {
        tblStoklar.setRowSorter(null);
    }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtStokKoduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokKoduActionPerformed
        
    }//GEN-LAST:event_txtStokKoduActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       try {
           Object[] rowData = null;
        addStokToDatabase(rowData);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Stok ekleme sırasında bir hata oluştu.");
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void addTableSelectionListener() {
    tblStoklar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
            int selectedRowIndex = tblStoklar.getSelectedRow();
            if (selectedRowIndex != -1) { // Bir satır seçildiyse
                DefaultTableModel model = (DefaultTableModel) tblStoklar.getModel();

                // Seçilen satırın bilgilerini text kutularına aktarma
                txtStokKodu.setText(model.getValueAt(selectedRowIndex, 0).toString());
                txtStokAdı.setText(model.getValueAt(selectedRowIndex, 1).toString());
                boxStokTipi.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
                boxBirimi.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
                txtBarkodu.setText(model.getValueAt(selectedRowIndex, 4).toString());
                boxKDVTipi.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
                txtAciklama.setText(model.getValueAt(selectedRowIndex, 6).toString());
                txtTarih.setText(model.getValueAt(selectedRowIndex, 7).toString());
 
            } else {     
                tblStoklar.clearSelection();
                clearComponents();
            }
        }
    });
}


    
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
    DefaultTableModel model = (DefaultTableModel) tblStoklar.getModel();

    int selectedRowIndex = tblStoklar.getSelectedRow();
    if (selectedRowIndex != -1) { // Bir satır seçilmişse
        String stokKodu = model.getValueAt(selectedRowIndex, 0).toString(); // Stok Kodu sütunu varsayılan olarak 0. sütun olarak kabul edildi.

        // Veritabanı işlemleri
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Veritabanı bağlantısını kurma
            DbHelper dbHelper = new DbHelper();
            connection = dbHelper.getConnection();

            // Silme işlemi için SQL sorgusu
            String sql = "DELETE FROM alanadi WHERE stokKodu = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, stokKodu);

            // Kaydı veritabanından silme
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Tablo modelinden satırı silme
                model.removeRow(selectedRowIndex);
                JOptionPane.showMessageDialog(null, "Seçilen satır başarıyla silindi.");
            } else {
                JOptionPane.showMessageDialog(null, "Satır silinirken bir hata oluştu.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            // Kaynakları kapatma
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Lütfen silmek için bir satır seçin.");
    }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdActionPerformed

    int selectedRowIndex = tblStoklar.getSelectedRow();
    
    if (selectedRowIndex != -1) { // Bir satır seçilmişse
        // Tablo modelini al
        DefaultTableModel model = (DefaultTableModel) tblStoklar.getModel();

        try {
            // Güncellenecek verileri al
            String stokKodu = model.getValueAt(selectedRowIndex, 0).toString();
            String stokAdi = txtStokAdı.getText();
            String stokTipi = boxStokTipi.getSelectedItem().toString();
            String birimi = boxBirimi.getSelectedItem().toString();
            String barkodu = txtBarkodu.getText();
            String kdvTipi = boxKDVTipi.getSelectedItem().toString();
            String aciklama = txtAciklama.getText();
            String olusturmaTarihi = txtTarih.getText();

            // Veritabanı işlemleri
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                // Veritabanı bağlantısını kurma
                DbHelper dbHelper = new DbHelper();
                connection = dbHelper.getConnection();

                // Güncelleme işlemi için SQL sorgusu
                String sql = "UPDATE alanadi SET StokAdi = ?, StokTipi = ?, birimi = ?, barkodu = ?, KDVTipi = ?, aciklama = ?, OlusturmaTarihi = ? WHERE StokKodu = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, stokAdi);
                statement.setString(2, stokTipi);
                statement.setString(3, birimi);
                statement.setString(4, barkodu);
                statement.setString(5, kdvTipi);
                statement.setString(6, aciklama);
                statement.setString(7, olusturmaTarihi);
                statement.setString(8, stokKodu);

                // Kaydı veritabanında güncelleme
                int affectedRows = statement.executeUpdate();

                if (affectedRows > 0) {
                    // Tablo modelindeki ilgili satırı güncelleme
                    model.setValueAt(stokAdi, selectedRowIndex, 1);
                    model.setValueAt(stokTipi, selectedRowIndex, 2);
                    model.setValueAt(birimi, selectedRowIndex, 3);
                    model.setValueAt(barkodu, selectedRowIndex, 4);
                    model.setValueAt(kdvTipi, selectedRowIndex, 5);
                    model.setValueAt(aciklama, selectedRowIndex, 6);
                    model.setValueAt(olusturmaTarihi, selectedRowIndex, 7);

                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Seçilen satır başarıyla güncellendi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Satır güncellenirken bir hata oluştu.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            } finally {
                // Kaynakları kapatma
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lütfen geçerli veriler girin.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Lütfen güncellemek için bir satır seçin.");
    }
    
    }//GEN-LAST:event_btnUpdActionPerformed

    private void boxStokTipiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStokTipiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxStokTipiActionPerformed

    private void boxBirimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBirimiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxBirimiActionPerformed

    private void boxKDVTipiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxKDVTipiActionPerformed
        
    
    }//GEN-LAST:event_boxKDVTipiActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        txtCopy.setVisible(true);
        lblCopy.setVisible(true);
        btnEkle.setVisible(true);
        int[] selectedRows = tblStoklar.getSelectedRows(); // Seçili satırların indekslerini al
          
        
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
           
       int[] selectedRows = tblStoklar.getSelectedRows(); // Seçili satırların indekslerini al
    
    if (selectedRows.length > 0) { // En az bir satır seçiliyse
        DefaultTableModel model = (DefaultTableModel) tblStoklar.getModel();
        
        String newStokKodu = txtCopy.getText(); // Kullanıcının girdiği yeni stok kodunu al
        
        if (!newStokKodu.isEmpty()) { // Girilen stok kodu boş değilse
            for (int row : selectedRows) {
                Object[] rowData = new Object[model.getColumnCount()];
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col); // Hücrenin değerini al
                    rowData[col] = value;
                }
                // Stok kodunu değiştirerek aynı verileri ekle
                rowData[0] = newStokKodu;
                model.addRow(rowData);
                
                addStokToDatabasee(rowData); // Veritabanına yeni stok eklemek için bir metot çağır
            }
            
            JOptionPane.showMessageDialog(null, "Seçili satırlar başarıyla kopyalandı ve eklendi.");
        } else {
            JOptionPane.showMessageDialog(null, "Lütfen yeni stok kodunu girin.");
        }
    }
    }//GEN-LAST:event_btnEkleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stoklar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stoklar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stoklar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stoklar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stoklar().setVisible(true);
            }
        });
    }
    
   public void showSelectedRowData(int selectedRow) {
    if (selectedRow != -1) {
        String stokKodu = tblStoklar.getValueAt(selectedRow, 0).toString();
        String stokAdi = tblStoklar.getValueAt(selectedRow, 1).toString();
        String stokTipi = tblStoklar.getValueAt(selectedRow, 2).toString();
        String birimi = tblStoklar.getValueAt(selectedRow, 3).toString();
        String barkodu = tblStoklar.getValueAt(selectedRow, 4).toString();
        String kdvTipi = tblStoklar.getValueAt(selectedRow, 5).toString();
        String aciklama = tblStoklar.getValueAt(selectedRow, 6).toString();
        String tarih = tblStoklar.getValueAt(selectedRow, 7).toString();
        
        txtStokKodu.setText(stokKodu);
        txtStokAdı.setText(stokAdi);
        boxStokTipi.setSelectedItem(stokTipi);
        boxBirimi.setSelectedItem(birimi);
        txtBarkodu.setText(barkodu);
        boxKDVTipi.setSelectedItem(kdvTipi);
        txtAciklama.setText(aciklama);
        txtTarih.setText(tarih);
    } else {
        clearComponents();
    }
    
    
}
private void clearComponents() {
    // Bileşenlerin içeriğini temizle
    txtStokKodu.setText("");
    txtStokAdı.setText("");
    boxStokTipi.setSelectedIndex(0);
    boxBirimi.setSelectedIndex(0);
    txtBarkodu.setText("");
    boxKDVTipi.setSelectedIndex(0);
    txtAciklama.setText("");
    txtTarih.setText("");
}

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxBirimi;
    private javax.swing.JComboBox<String> boxKDVTipi;
    private javax.swing.JComboBox<String> boxStokTipi;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnUpd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAciklama;
    private javax.swing.JLabel lblBarkodu;
    private javax.swing.JLabel lblBirimi;
    private javax.swing.JLabel lblCopy;
    private javax.swing.JLabel lblKDVTipi;
    private javax.swing.JLabel lblStokAdı;
    private javax.swing.JLabel lblStokKodu;
    private javax.swing.JLabel lblStokTipi;
    private javax.swing.JLabel lblTarihi;
    private javax.swing.JTable tblStoklar;
    private javax.swing.JTextField txtAciklama;
    private javax.swing.JTextField txtBarkodu;
    private javax.swing.JTextField txtCopy;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStokAdı;
    private javax.swing.JTextField txtStokKodu;
    private javax.swing.JFormattedTextField txtTarih;
    // End of variables declaration//GEN-END:variables
}
