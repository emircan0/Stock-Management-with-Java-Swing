package view;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.MainFrame;


public class StokList extends javax.swing.JInternalFrame   {
    public DefaultTableModel model;

    
    public StokList() {
        initComponents();

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenuList = new javax.swing.JPopupMenu();
        MenuItemExcel = new javax.swing.JMenuItem();
        MenuItemPdf = new javax.swing.JMenuItem();
        MenuItemMail = new javax.swing.JMenuItem();
        MenuItemStokKart = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStoklar = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        MenuItemExcel.setText("Excel");
        PopupMenuList.add(MenuItemExcel);

        MenuItemPdf.setText("PDF");
        PopupMenuList.add(MenuItemPdf);

        MenuItemMail.setText("Mail Gönder");
        PopupMenuList.add(MenuItemMail);

        MenuItemStokKart.setText("Stok Kart");
        PopupMenuList.add(MenuItemStokKart);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Stok Listesi");
        setComponentPopupMenu(PopupMenuList);

        tblStoklar.setAutoCreateRowSorter(true);
        tblStoklar.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        tblStoklar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama", "Oluşturma Tarihi", "Stok Tipi ID", "Stok Tipi Kodu", "Stok Tipi Adı", "Stok Tipi Aciklama", "Kdv Tip ID", "Kdv Tip Kodu", "Kdv Tip Adı", "Kdv Tip Oranı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblStoklar.setFocusable(false);
        tblStoklar.setGridColor(new java.awt.Color(204, 255, 204));
        tblStoklar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStoklarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStoklar);

        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setText("Arama Çubuğu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 474, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStoklarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStoklarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStoklarMouseClicked

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JMenuItem getMenuItemExcel() {
        return MenuItemExcel;
    }

    public void setMenuItemExcel(JMenuItem MenuItemExcel) {
        this.MenuItemExcel = MenuItemExcel;
    }

    public JMenuItem getMenuItemMail() {
        return MenuItemMail;
    }

    public void setMenuItemMail(JMenuItem MenuItemMail) {
        this.MenuItemMail = MenuItemMail;
    }

    public JMenuItem getMenuItemPdf() {
        return MenuItemPdf;
    }

    public void setMenuItemPdf(JMenuItem MenuItemPdf) {
        this.MenuItemPdf = MenuItemPdf;
    }

    public JMenuItem getMenuItemStokKart() {
        return MenuItemStokKart;
    }

    public void setMenuItemStokKart(JMenuItem MenuItemStokKart) {
        this.MenuItemStokKart = MenuItemStokKart;
    }

    public JPopupMenu getPopupMenuList() {
        return PopupMenuList;
    }

    public void setPopupMenuList(JPopupMenu PopupMenuList) {
        this.PopupMenuList = PopupMenuList;
    }

    public JTable getTblStoklar() {
        return tblStoklar;
    }

    public void setTblStoklar(JTable tblStoklar) {
        this.tblStoklar = tblStoklar;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuItemExcel;
    public javax.swing.JMenuItem MenuItemMail;
    public javax.swing.JMenuItem MenuItemPdf;
    public javax.swing.JMenuItem MenuItemStokKart;
    public javax.swing.JPopupMenu PopupMenuList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblStoklar;
    public javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
