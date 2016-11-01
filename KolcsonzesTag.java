/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.IModel;
import model.Tag;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
public class KolcsonzesTag extends javax.swing.JDialog {
        private Frame parent;
        private IModel model;
        private Vector<Tag> tagok;
        private DefaultTableModel dtm;
        private int kolcsozoId;
    /**
     * Creates new form KolcsonzesTag
     */
    public KolcsonzesTag(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        this.model = model;
        this.parent = parent;
        this.dtm = (DefaultTableModel)jtTagok.getModel();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTagok = new javax.swing.JTable();
        jbKolcsonzes = new javax.swing.JButton();
        jbMegsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtTagok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Név", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTagok);

        jbKolcsonzes.setText("Kölcsönzés");
        jbKolcsonzes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbKolcsonzesActionPerformed(evt);
            }
        });

        jbMegsem.setText("Rendben");
        jbMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbKolcsonzes, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jbMegsem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbKolcsonzes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbMegsem))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbKolcsonzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbKolcsonzesActionPerformed
        
        int selected = jtTagok.getSelectedRow()+1;
        if(selected >=1 && selected <= jtTagok.getRowCount()){
            Tag tag = tagok.elementAt(selected);
            this.kolcsozoId = tag.getId();
            setVisible(false);
        
        }else JOptionPane.showMessageDialog(rootPane, "Nincs tag kiválasztva!", "Hibás adat!", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jbKolcsonzesActionPerformed

    private void jbMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMegsemActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbMegsemActionPerformed

    public int getKolcsozoId() {
        return kolcsozoId;
    }

    /**
     * @param args the command line arguments
     */

   private void updateTable() {
        dtm.getDataVector().removeAllElements();
            try {
                tagok = model.getTagok();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
            }
        for(Tag t : tagok){
            
            Vector sor = new Vector<>();
            if (t.getId()!= 0){
            sor.add(t.getId());
            sor.add(t.getNev());
            sor.add(t.getEmail());
            dtm.addRow(sor);
         }
        }
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbKolcsonzes;
    private javax.swing.JButton jbMegsem;
    private javax.swing.JTable jtTagok;
    // End of variables declaration//GEN-END:variables
}
