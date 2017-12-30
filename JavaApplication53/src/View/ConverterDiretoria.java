package View;

import Controller.Controller;
import Model.EstiloProgramacao.EstiloProgramacao;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ConverterDiretoria extends javax.swing.JPanel implements Runnable {

    Controller Controller;
    Thread T;
    JPanel CardPanel;
    boolean UserFirst = true, DiretoriaFirst = true;
    ArrayList<Integer> IdEstilo;
    ArrayList<Integer> IdEstiloOutroUtilizador;

    public ConverterDiretoria(Controller Controller) {
        this.Controller = Controller;
        initComponents();
        jUsername.setVisible(false);
        jListaEstilosOutro.setVisible(false);
        jErroUtilizador.setVisible(false);
        jButton1.setVisible(false);
        IdEstilo = new ArrayList<>();
        IdEstiloOutroUtilizador = new ArrayList<>();
        if (Controller.getEstilosUtilizador() != null) {
            for (EstiloProgramacao EP : Controller.getEstilosUtilizador()) {
                jListaEstilos.add(EP.getNome());
            }
        }
        start();
    }

    public void setCardPanel(JPanel J) {
        CardPanel = J;
    }

    public void start() {
        if (T == null) {
            T = new Thread(this, "Thread2");
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

        jConverter = new javax.swing.JButton();
        jDiretoria = new javax.swing.JTextField();
        jProcurar = new javax.swing.JButton();
        jListaEstilos = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jAnalisa = new javax.swing.JButton();
        jUsername = new javax.swing.JTextField();
        jListaEstilosOutro = new java.awt.Choice();
        jEscolherOutro = new javax.swing.JButton();
        jErroUtilizador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jConverter.setText("Converter");
        jConverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jConverterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jConverterMouseEntered(evt);
            }
        });
        jConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConverterActionPerformed(evt);
            }
        });

        jDiretoria.setForeground(new java.awt.Color(204, 204, 204));
        jDiretoria.setText("C:\\Pasta1\\Pasta2");
        jDiretoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDiretoriaFocusGained(evt);
            }
        });

        jProcurar.setText("Procurar");
        jProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProcurarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Converter");

        jAnalisa.setText("Analisa");
        jAnalisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAnalisaMouseClicked(evt);
            }
        });

        jUsername.setForeground(new java.awt.Color(204, 204, 204));
        jUsername.setText("Nome Utilizador");
        jUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jUsernameFocusLost(evt);
            }
        });

        jEscolherOutro.setText("Escolher Outro");
        jEscolherOutro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEscolherOutroMouseClicked(evt);
            }
        });

        jErroUtilizador.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jErroUtilizador.setForeground(new java.awt.Color(153, 0, 0));
        jErroUtilizador.setText("Utilizador Inexistente");

        jButton1.setText("Pesquisa");
        jButton1.setName("PesquisaUtilizador"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jListaEstilos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDiretoria, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jProcurar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jListaEstilosOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jEscolherOutro)
                                            .addComponent(jErroUtilizador))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAnalisa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDiretoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jListaEstilos, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jEscolherOutro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jListaEstilosOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jErroUtilizador)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAnalisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jConverterMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jConverterMouseClicked
    {//GEN-HEADEREND:event_jConverterMouseClicked
        if (jListaEstilosOutro.getSelectedIndex() == -1) {
            if (Controller.ExisteEstiloID(IdEstilo.get(jListaEstilos.getSelectedIndex()))) {
                Controller.Converte(jDiretoria.getText(), IdEstilo.get(jListaEstilos.getSelectedIndex()), Controller.getUtilizadorAtualNome());
                CardLayout cl = (CardLayout) CardPanel.getLayout();
                cl.next(CardPanel);
            }
        } else {
             if (Controller.ExisteEstiloID(IdEstilo.get(jListaEstilos.getSelectedIndex()))) {
                Controller.Converte2(jDiretoria.getText(), IdEstiloOutroUtilizador.get(jListaEstilosOutro.getSelectedIndex()), Controller.getUtilizadorAtualNome());
                CardLayout cl = (CardLayout) CardPanel.getLayout();
                cl.next(CardPanel);
            }
        }
    }//GEN-LAST:event_jConverterMouseClicked

    private void jProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProcurarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                jDiretoria.setText(fc.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_jProcurarActionPerformed

    private void jAnalisaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jAnalisaMouseClicked
    {//GEN-HEADEREND:event_jAnalisaMouseClicked
        CardLayout cl = (CardLayout) CardPanel.getLayout();
        cl.previous(CardPanel);
    }//GEN-LAST:event_jAnalisaMouseClicked

    private void jEscolherOutroMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jEscolherOutroMouseClicked
    {//GEN-HEADEREND:event_jEscolherOutroMouseClicked
        if (jEscolherOutro.getFont().isBold()) {
            jEscolherOutro.setFont(jEscolherOutro.getFont().deriveFont(Font.PLAIN));
            jListaEstilosOutro.setVisible(true);
            jUsername.setVisible(true);
            jButton1.setVisible(true);
        } else {
            jEscolherOutro.setFont(jEscolherOutro.getFont().deriveFont(Font.BOLD));
            jListaEstilosOutro.setVisible(false);
            jUsername.setVisible(false);
            jButton1.setVisible(false);
            jErroUtilizador.setVisible(false);
        }

        validate();
    }//GEN-LAST:event_jEscolherOutroMouseClicked

    private void jUsernameFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jUsernameFocusGained
    {//GEN-HEADEREND:event_jUsernameFocusGained
        if (UserFirst) {
            jUsername.setText("");
        }
        jUsername.setForeground(Color.BLACK);
        UserFirst = false;
    }//GEN-LAST:event_jUsernameFocusGained

    private void jUsernameFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jUsernameFocusLost
    {//GEN-HEADEREND:event_jUsernameFocusLost

    }//GEN-LAST:event_jUsernameFocusLost

    private void jDiretoriaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jDiretoriaFocusGained
    {//GEN-HEADEREND:event_jDiretoriaFocusGained
        if (DiretoriaFirst) {
            jDiretoria.setText("");
        }
        jDiretoria.setForeground(Color.BLACK);
        DiretoriaFirst = false;
    }//GEN-LAST:event_jDiretoriaFocusGained

    private void jProcurarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jProcurarMouseClicked
    {//GEN-HEADEREND:event_jProcurarMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                jDiretoria.setText(fc.getSelectedFile().getCanonicalPath());
                jDiretoria.setForeground(Color.black);
                DiretoriaFirst = false;
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_jProcurarMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jListaEstilos.removeAll();
        if (Controller.getEstilosUtilizador() != null) {
            for (EstiloProgramacao EP : Controller.getEstilosUtilizador()) {
                jListaEstilos.add(EP.getNome());
                IdEstilo.add(EP.getId());
            }
        }
    }//GEN-LAST:event_formComponentShown

    private void jConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConverterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jConverterActionPerformed

    private void jConverterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jConverterMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jConverterMouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (Controller.ExisteUsername(jUsername.getText()) != -3 && Controller.ExisteUsername(jUsername.getText()) < 0) {
            jErroUtilizador.setVisible(true);
            return;
        }

        ArrayList<EstiloProgramacao> estilos = Controller.UtilizadorEstilos(jUsername.getText());

        if (estilos == null) {
            jErroUtilizador.setVisible(true);
            jErroUtilizador.setText("O utilizador não tem Estilos de Programação");
            return;
        }
        if(!IdEstiloOutroUtilizador.isEmpty())
            IdEstiloOutroUtilizador.clear();
        jListaEstilosOutro.removeAll();
        for (EstiloProgramacao estilo : estilos) {
            jListaEstilosOutro.add(estilo.getNome());
            IdEstiloOutroUtilizador.add(estilo.getId());
        }

    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAnalisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jConverter;
    private javax.swing.JTextField jDiretoria;
    private javax.swing.JLabel jErroUtilizador;
    private javax.swing.JButton jEscolherOutro;
    private javax.swing.JLabel jLabel1;
    private java.awt.Choice jListaEstilos;
    private java.awt.Choice jListaEstilosOutro;
    private javax.swing.JButton jProcurar;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        File DnDFile = null;
        while (true) {
            try {
                File Aux = Controller.getDnDFile();
                if (Aux == null) {
                    continue;
                }

                if (DnDFile != Aux && Aux.isDirectory()) {
                    DnDFile = Controller.getDnDFile();
                } else {
                    continue;
                }

                if (DnDFile != null) {
                    jDiretoria.setText(DnDFile.getCanonicalPath());
                }
            } catch (IOException ex) {
            }
        }

    }
}
