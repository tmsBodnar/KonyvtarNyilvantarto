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
import model.IModel;
import model.Konyv;
import model.Tag;

/**
 *
 * @author Bodnár Tamás <tms.bodnar@gmail.com> | www.kalandlabor.hu
 */
public class Adatok extends javax.swing.JDialog {
    private Frame parent;
    private IModel model;
    private Konyv konyv;
    private Vector<Konyv> konyvek;
    private Tag tag;
    /**
     * Creates new form Adatok
     */
    public Adatok(java.awt.Frame parent, boolean modal, IModel model, Konyv konyv) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.model = model;
        this.konyv = konyv;
        updateListKonyv();
    }
    public Adatok(java.awt.Frame parent, boolean modal, IModel model, Tag tag) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.model = model;
        this.tag = tag;
        updateListTag();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbRendben = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaAdatok = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbRendben.setText("Rendben");
        jbRendben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRendbenActionPerformed(evt);
            }
        });

        jtaAdatok.setColumns(20);
        jtaAdatok.setRows(5);
        jScrollPane2.setViewportView(jtaAdatok);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(508, Short.MAX_VALUE)
                .addComponent(jbRendben)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbRendben)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRendbenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRendbenActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbRendbenActionPerformed
    private void updateListKonyv(){
        try {
            konyv = model.getKonyv(konyv.getId());
            if(konyv.getTagId()!=0){
            jtaAdatok.setText(konyv.toString( )+"\n"+"A könyvet kikölcsönözte: "+model.getTag(konyv.getTagId()).getNev());
            }else jtaAdatok.setText(konyv.toString( )+"\n"+"A könyv kölcsönözhető");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateListTag() {
        try {
            Tag ezaTag = model.getTag(tag.getId());
            konyvek = model.getKonyvek();
            StringBuffer konyvei = new StringBuffer();
            for(Konyv k : konyvek){
                if(k.getTagId() == ezaTag.getId()){
                    konyvei.append(k.getCim() + "\n");
            }
            }
            jtaAdatok.setText(ezaTag.toString()+ "\n" +"A kikölcsönzött könyvei: " +"\n" +konyvei.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbRendben;
    private javax.swing.JTextArea jtaAdatok;
    // End of variables declaration//GEN-END:variables

    
}