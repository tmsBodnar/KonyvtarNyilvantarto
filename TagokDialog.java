/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.IModel;
import model.Tag;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
public class TagokDialog extends javax.swing.JDialog {
        private Frame parent;
        private IModel model;
        private Vector<Tag> tagok;
        private DefaultTableModel dtm;
                
                
    /**
     * Creates new form TagokDialog
     */
    public TagokDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        this.model = model;
        this.parent = parent;
        dtm = (DefaultTableModel) jtTagok.getModel();
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
        jbAddTag = new javax.swing.JButton();
        jbRemoveTag = new javax.swing.JButton();
        jbUpdateTag = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbTagAdatok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtTagok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Név", "Cím"
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

        jbAddTag.setText("Hozzáadás");
        jbAddTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddTagActionPerformed(evt);
            }
        });

        jbRemoveTag.setText("Eltávolítás");
        jbRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveTagActionPerformed(evt);
            }
        });

        jbUpdateTag.setText("Szerkesztés");
        jbUpdateTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateTagActionPerformed(evt);
            }
        });

        jButton4.setText("Mégsem");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jbTagAdatok.setText("Tag adatai");
        jbTagAdatok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTagAdatokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAddTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbUpdateTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbRemoveTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTagAdatok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAddTag)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemoveTag)
                        .addGap(18, 18, 18)
                        .addComponent(jbUpdateTag)
                        .addGap(18, 18, 18)
                        .addComponent(jbTagAdatok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddTagActionPerformed
        jdTagSzerkeszt tsz = new jdTagSzerkeszt(parent, true, null);
        tsz.setVisible(true);
        if(tsz.isMentes()){
            try {
                model.addTag(tsz.getTag());
                updateTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbAddTagActionPerformed

    private void jbUpdateTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateTagActionPerformed
        int selected = jtTagok.getSelectedRow()+1;
        if(selected >= 1 && selected <= jtTagok.getRowCount()){
        Tag tag = tagok.elementAt(selected); 
        jdTagSzerkeszt tsz = new jdTagSzerkeszt(parent, true, tag);
        tsz.setVisible(true);
        if(tsz.isMentes()){
            try {
                model.updateTag(tsz.getTag());
                updateTable();
                selected = 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
            }
        }
        }else JOptionPane.showMessageDialog(rootPane, "Nincs tag kiválasztva!", "Hibás adat!", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jbUpdateTagActionPerformed

    private void jbRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveTagActionPerformed
        int selected = jtTagok.getSelectedRow()+1;
        if(selected >=1 && selected <= jtTagok.getRowCount()){
        Tag tag = tagok.elementAt(selected);
        int reply = JOptionPane.showConfirmDialog(rootPane, "Biztosan törlöd?","Törlési megerősítés!", JOptionPane.YES_NO_OPTION);
        if(reply == 0){
            try {
                model.removeTag(tag);
                updateTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
            }
        }
        }else JOptionPane.showMessageDialog(rootPane, "Nincs tag kiválasztva!", "Hibás adat!", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jbRemoveTagActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbTagAdatokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTagAdatokActionPerformed
        int selected = jtTagok.getSelectedRow()+1;
        if(selected>=1&& selected<=jtTagok.getRowCount()){
            Tag tag = tagok.elementAt(selected);
            Adatok ja = new Adatok(parent, true, model, tag);
            ja.setVisible(true);
        }else JOptionPane.showMessageDialog(rootPane, "Nincs tag kiválasztva!", "Hibás adat!", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jbTagAdatokActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAddTag;
    private javax.swing.JButton jbRemoveTag;
    private javax.swing.JButton jbTagAdatok;
    private javax.swing.JButton jbUpdateTag;
    private javax.swing.JTable jtTagok;
    // End of variables declaration//GEN-END:variables

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

    public JTable getJtTagok() {
        return jtTagok;
    }
}
