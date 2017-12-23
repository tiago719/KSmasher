/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
 
import Controller.Controller;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Coutinho
 */
public class Registo extends javax.swing.JPanel
{
    Controller Controller;
    boolean UserFirst=true,EmailFirst=true,PassFirst=true,CPassFirst=true, Inicio=true;
    boolean UserOk = false,Emailok=false, Passok = false;
    public Registo()
    {
        initComponents();
    }

    Registo(Controller Controller)
    {
        this.Controller=Controller;
        initComponents();
        jPassword.setEchoChar((char) 0);
        jCPassword.setEchoChar((char) 0);
        jErroPass.setVisible(false);
        jErroUser.setVisible(false);
        jErroEmail.setVisible(false);
        jErroCPass.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jRegistar = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jCPassword = new javax.swing.JPasswordField();
        jErroUser = new javax.swing.JLabel();
        jErroEmail = new javax.swing.JLabel();
        jErroPass = new javax.swing.JLabel();
        jErroCPass = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Registar");

        jUsername.setForeground(new java.awt.Color(204, 204, 204));
        jUsername.setText("Nome de Utilizador");
        jUsername.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jUsername.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jUsernameFocusLost(evt);
            }
        });

        jEmail.setForeground(new java.awt.Color(204, 204, 204));
        jEmail.setText("Email");
        jEmail.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jEmailFocusLost(evt);
            }
        });

        jRegistar.setText("Registar");
        jRegistar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jRegistarMouseClicked(evt);
            }
        });
        jRegistar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRegistarActionPerformed(evt);
            }
        });

        jPassword.setForeground(new java.awt.Color(204, 204, 204));
        jPassword.setText("Password");
        jPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jPasswordFocusLost(evt);
            }
        });
        jPassword.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordActionPerformed(evt);
            }
        });

        jCPassword.setForeground(new java.awt.Color(204, 204, 204));
        jCPassword.setText("Confirmar Password");
        jCPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jCPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jCPasswordFocusLost(evt);
            }
        });
        jCPassword.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCPasswordActionPerformed(evt);
            }
        });

        jErroUser.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jErroUser.setForeground(new java.awt.Color(153, 0, 0));
        jErroUser.setText("Utilizador entre 7-15 Caracteres");

        jErroEmail.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jErroEmail.setForeground(new java.awt.Color(153, 0, 0));
        jErroEmail.setText("Email Já Existente");

        jErroPass.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jErroPass.setForeground(new java.awt.Color(153, 0, 0));
        jErroPass.setText("Palavra-Passe entre 8-15 caracteres");

        jErroCPass.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jErroCPass.setForeground(new java.awt.Color(153, 0, 0));
        jErroCPass.setText("Palavras-Passe não Correspondem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jErroUser)
                            .addComponent(jErroEmail)
                            .addComponent(jErroPass)
                            .addComponent(jErroCPass)
                            .addComponent(jCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jRegistar)))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jErroUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jErroEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jErroPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jErroCPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRegistar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRegistarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRegistarActionPerformed
    {//GEN-HEADEREND:event_jRegistarActionPerformed

    }//GEN-LAST:event_jRegistarActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordActionPerformed
    {//GEN-HEADEREND:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jUsernameFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jUsernameFocusGained
    {//GEN-HEADEREND:event_jUsernameFocusGained
        if(Inicio)
        {
            jLabel1.requestFocus();
            Inicio=false;
            return;
        }
        if(UserFirst)
            jUsername.setText("");
        jUsername.setForeground(Color.BLACK);
        jErroCPass.setVisible(false);
        UserFirst=false;
        
    }//GEN-LAST:event_jUsernameFocusGained

    private void jEmailFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jEmailFocusGained
    {//GEN-HEADEREND:event_jEmailFocusGained
        
        if(EmailFirst)
            jEmail.setText("");
        jEmail.setForeground(Color.BLACK);
        jErroCPass.setVisible(false);
        EmailFirst=false;
    }//GEN-LAST:event_jEmailFocusGained

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jPasswordFocusGained
    {//GEN-HEADEREND:event_jPasswordFocusGained
        if(PassFirst)
            jPassword.setText("");
        
        jPassword.setForeground(Color.BLACK);
        jPassword.setEchoChar('•');
        jErroCPass.setVisible(false);
        PassFirst=false;
    }//GEN-LAST:event_jPasswordFocusGained

    private void jRegistarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jRegistarMouseClicked
    {//GEN-HEADEREND:event_jRegistarMouseClicked

        if(jPassword.getText().equals(jPassword.getText()))
        {
            Passok = true;
        }
        if(UserOk == true && Emailok == true && Passok == true)
        {
            Controller.Regista(jUsername.getText(), jEmail.getText(), jPassword.getText()); 
            jErroCPass.setText("Registado com Sucesso!");
            jErroCPass.setForeground(Color.green);
            jErroCPass.setVisible(true);   
            UserOk = false;
            Emailok = false;
            Passok = false;
            jCPassword.setText("");
            jPassword.setText("");
            jEmail.setText("");
            jUsername.setText("");
        }
        else
        {
        }
         
    }//GEN-LAST:event_jRegistarMouseClicked

    private void jCPasswordFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jCPasswordFocusGained
    {//GEN-HEADEREND:event_jCPasswordFocusGained
        if(CPassFirst)
            jCPassword.setText("");
        
        jCPassword.setForeground(Color.BLACK);
        jCPassword.setEchoChar('•');
        CPassFirst=false;
        
        jErroCPass.setVisible(false);  
    }//GEN-LAST:event_jCPasswordFocusGained

    private void jCPasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCPasswordActionPerformed
    {//GEN-HEADEREND:event_jCPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCPasswordActionPerformed

    private void jUsernameFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jUsernameFocusLost
    {//GEN-HEADEREND:event_jUsernameFocusLost
        if(UserFirst)
            return;
        if(Controller.ExisteUsername(jUsername.getText())<0)
        {
            jErroUser.setVisible(true);
            if(Controller.ExisteUsername(jUsername.getText())==-1)
            {
                jErroUser.setText("Utilizador entre 7-15 Caracteres");
            }
            else if(Controller.ExisteUsername(jUsername.getText())==-2)
            {
                jErroUser.setText("Contém Caracteres Especiais");
            }
            else if(Controller.ExisteUsername(jUsername.getText())==-3)
            {
                jErroUser.setText("Nome de Utilizador Já Existente");
            }
            else
            {
                jErroUser.setVisible(false);
                
            }
        }
        else
        {
          jErroUser.setVisible(false);
          UserOk = true; 
        }
        
    }//GEN-LAST:event_jUsernameFocusLost

    private void jEmailFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jEmailFocusLost
    {//GEN-HEADEREND:event_jEmailFocusLost
       
        int ret=Controller.ExisteEmail(jEmail.getText());

        if(ret==1)
        {
            jErroEmail.setText("Email Já Existente");
            jErroEmail.setVisible(true);
        }
        else if(ret==-2)
        {
            jErroEmail.setText("Email Inválido");
            jErroEmail.setVisible(true);
        }
        else
        {
            jErroEmail.setVisible(false);
            Emailok = true;
        }
    }//GEN-LAST:event_jEmailFocusLost

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jPasswordFocusLost
    {//GEN-HEADEREND:event_jPasswordFocusLost
        if(jPassword.getText().length()<=8 || jPassword.getText().length()>15)
        {
            jErroPass.setText("Palavras-Passe entre 8 e 15");
            jErroPass.setVisible(true);
        }
        else
          jErroPass.setVisible(false);
    }//GEN-LAST:event_jPasswordFocusLost

    private void jCPasswordFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jCPasswordFocusLost
    {//GEN-HEADEREND:event_jCPasswordFocusLost
        if(jPassword.getText().equals(jCPassword.getText()))
        {
            jErroCPass.setVisible(false);
            Passok = true;
        }
        else
          jErroCPass.setVisible(true);
    }//GEN-LAST:event_jCPasswordFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField jCPassword;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jErroCPass;
    private javax.swing.JLabel jErroEmail;
    private javax.swing.JLabel jErroPass;
    private javax.swing.JLabel jErroUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jRegistar;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
