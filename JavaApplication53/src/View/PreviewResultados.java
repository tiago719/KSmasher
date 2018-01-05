/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.FicheirosAlterasdos;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author andre
 */
public class PreviewResultados extends javax.swing.JPanel implements Runnable {

    Controller controller;
    JPanel CardPanel;
    Thread T;
    ArrayList<FicheirosAlterasdos> temp1;

    public PreviewResultados() {

        initComponents();
    }

    PreviewResultados(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    public void setCardPanel(JPanel J) {
        CardPanel = J;
    }

    public void start() {
        if (T == null) {
            T = new Thread(this, "Thread3");
            T.start();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Novo");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -10, 50, 30));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Antigo");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -10, 50, 30));

        jScrollPane1.setViewportView(jTextPane1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 290, 450));

        jTextPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextPane2.setName(""); // NOI18N
        jScrollPane3.setViewportView(jTextPane2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 290, 450));

        jButton1.setText("Concluir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 110, 30));

        jLabel2.setText("jLabel1");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 394, -1, 50));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        return;

    }//GEN-LAST:event_formFocusGained

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged

        if (controller.DevolveListaFicheiros() != null) {

            jList1.removeAll();
            DefaultListModel<String> temp = new DefaultListModel<>();
            temp1 = controller.DevolveListaFicheiros();
            for (int i = 0; i < temp1.size(); i++) {
                temp.add(i, temp1.get(i).getNome());

            }

            jList1.setModel(temp);
            jList1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                  jTextPane1.setText(controller.DevolveFicheiroAntigo(temp1.get(jList1.getSelectedIndex()).getCaminho(),temp1.get(jList1.getSelectedIndex()).getNome()));
                  jTextPane2.setText(controller.DevolveFicheiroNovo(temp1.get(jList1.getSelectedIndex()).getCaminhoNovo(),temp1.get(jList1.getSelectedIndex()).getNome()));
                }
            });
            //  JScrollPane jscroll = new JScrollPane(jList1);
        }
    }//GEN-LAST:event_formHierarchyChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            controller.LimpaDiretoria();
            temp1.clear();
            
            CardLayout cl = (CardLayout) CardPanel.getLayout();        
            cl.previous(CardPanel);
      
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
