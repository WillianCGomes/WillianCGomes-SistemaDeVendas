/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import controller.MenuController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author earodrigues
 */
public class LoginView extends javax.swing.JFrame {

    private LoginController controller = new LoginController(LoginView.this);
    
    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
        controller.botaoMostrarSenha();
        setResizable(false);
    }

    public LoginView(MenuController aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        lbIconeLogin = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        ckbxMostrarSenha = new javax.swing.JCheckBox();
        pfSenha = new javax.swing.JPasswordField();
        jPanelSistema = new javax.swing.JPanel();
        lbIconeSistema = new javax.swing.JLabel();
        lbDeVendas = new javax.swing.JLabel();
        lbSistemaDeControle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login - Sistema de Vendas");

        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbIconeLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Login.png"))); // NOI18N

        lbLogin.setText("Login:");

        lbSenha.setText("Senha:");

        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.setMaximumSize(new java.awt.Dimension(132, 46));
        btCancelar.setMinimumSize(new java.awt.Dimension(132, 46));
        btCancelar.setPreferredSize(new java.awt.Dimension(132, 40));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Confirmar.png"))); // NOI18N
        btConfirmar.setText("CONFIRMAR");
        btConfirmar.setPreferredSize(new java.awt.Dimension(132, 40));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        ckbxMostrarSenha.setText("Mostrar senha");
        ckbxMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbxMostrarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIconeLogin)
                .addGap(25, 25, 25)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin)
                            .addComponent(lbSenha))
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(pfSenha)))
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(ckbxMostrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIconeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSenha)
                            .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ckbxMostrarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanelSistema.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelSistema.setLayout(null);

        lbIconeSistema.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbIconeSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system.png"))); // NOI18N
        jPanelSistema.add(lbIconeSistema);
        lbIconeSistema.setBounds(90, 0, 64, 72);

        lbDeVendas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDeVendas.setText("DE VENDAS");
        jPanelSistema.add(lbDeVendas);
        lbDeVendas.setBounds(200, 40, 79, 19);

        lbSistemaDeControle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSistemaDeControle.setText("SISTEMA DE CONTROLE");
        jPanelSistema.add(lbSistemaDeControle);
        lbSistemaDeControle.setBounds(160, 10, 165, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        try {
            controller.botaoSair();
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        controller.botaoConfirma();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void ckbxMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbxMostrarSenhaActionPerformed
        controller.botaoMostrarSenha();
    }//GEN-LAST:event_ckbxMostrarSenhaActionPerformed

    public JCheckBox getCkbxMostrarSenha() {
        return ckbxMostrarSenha;
    }

    public void setCkbxMostrarSenha(JCheckBox ckbxMostrarSenha) {
        this.ckbxMostrarSenha = ckbxMostrarSenha;
    }

    public JPasswordField getPfSenha() {
        return pfSenha;
    }

    public void setPfSenha(JPasswordField ftfSenha) {
        this.pfSenha = ftfSenha;
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public void setTfLogin(JTextField tfLogin) {
        this.tfLogin = tfLogin;
    }
    

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JCheckBox ckbxMostrarSenha;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelSistema;
    private javax.swing.JLabel lbDeVendas;
    private javax.swing.JLabel lbIconeLogin;
    private javax.swing.JLabel lbIconeSistema;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSistemaDeControle;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables
}