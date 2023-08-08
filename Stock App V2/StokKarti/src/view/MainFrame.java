package view;

import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MainFrame extends javax.swing.JFrame {
     
    public MainFrame() {
        initComponents();
      
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        popupList = new javax.swing.JMenuItem();
        popupKart = new javax.swing.JMenuItem();
        popupStokTipi = new javax.swing.JMenuItem();
        popupKdvTipi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        DesktopPane.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1398, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        jMenu3.setText("Menü");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu(evt);
            }
        });

        popupList.setText("Stok Listesi");
        popupList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupListActionPerformed(evt);
            }
        });
        jMenu3.add(popupList);

        popupKart.setText("Stok Kart");
        jMenu3.add(popupKart);

        popupStokTipi.setText("Stok Tipi Kart");
        jMenu3.add(popupStokTipi);

        popupKdvTipi.setText("Kdv Tipi Kart");
        jMenu3.add(popupKdvTipi);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu

    private void popupListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupListActionPerformed

    public JDesktopPane getDesktopPane() {
        return DesktopPane;
    }

    public void setDesktopPane(JDesktopPane DesktopPane) {
        this.DesktopPane = DesktopPane;
    }


    public JMenuItem getPopupKart() {
        return popupKart;
    }

    public void setPopupKart(JMenuItem popupKart) {
        this.popupKart = popupKart;
    }

    public JMenuItem getPopupKdvTipi() {
        return popupKdvTipi;
    }

    public void setPopupKdvTipi(JMenuItem popupKdvTipi) {
        this.popupKdvTipi = popupKdvTipi;
    }

    public JMenuItem getPopupList() {
        return popupList;
    }

    public void setPopupList(JMenuItem popupList) {
        this.popupList = popupList;
    }

    public JMenuItem getPopupStokTipi() {
        return popupStokTipi;
    }

    public void setPopupStokTipi(JMenuItem popupStokTipi) {
        this.popupStokTipi = popupStokTipi;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DesktopPane;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem popupKart;
    public javax.swing.JMenuItem popupKdvTipi;
    public javax.swing.JMenuItem popupList;
    public javax.swing.JMenuItem popupStokTipi;
    // End of variables declaration//GEN-END:variables
}
