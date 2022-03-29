package view;

import controller.MenuController;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;

/**
 *
 * @author Willian Carlos Gomes
 */
public class MenuView extends javax.swing.JFrame {
    private MenuController controller = new MenuController(MenuView.this);
    private ImageIcon ImageIcon;

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
        setResizable(false);
        controller.usuarioLogado();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/background.png"));
        Image image = icon.getImage();
        PainelBackground = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g) {
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        btSair = new javax.swing.JButton();
        btClientes = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();
        btVendas = new javax.swing.JButton();
        btFornecedor = new javax.swing.JButton();
        btCompras = new javax.swing.JButton();
        btFuncionarios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbHora = new javax.swing.JLabel();
        lbNomeDoUsuario = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbUsuario1 = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuEstoque = new javax.swing.JMenu();
        jMenuControleDeEstoque = new javax.swing.JMenu();
        jMenuItemEntradaDeEstoque = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuItemProdutosEmFalta = new javax.swing.JMenuItem();
        jMenuVendas = new javax.swing.JMenu();
        jMenuItemEfetiarVenda = new javax.swing.JMenuItem();
        jMenuCompras = new javax.swing.JMenu();
        jMenuItemEfetuarCompras = new javax.swing.JMenuItem();
        jMenuContas = new javax.swing.JMenu();
        jMenuItemContasAReceber = new javax.swing.JMenuItem();
        jMenuItemContasAPagar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SIstema Comercial de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PainelBackground.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PainelBackground.setPreferredSize(new java.awt.Dimension(1366, 500));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.setPreferredSize(new java.awt.Dimension(150, 70));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        btClientes.setText("Clientes");
        btClientes.setPreferredSize(new java.awt.Dimension(150, 70));
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });

        btProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estoque.png"))); // NOI18N
        btProdutos.setText("Produtos");
        btProdutos.setPreferredSize(new java.awt.Dimension(150, 70));
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        btVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        btVendas.setText("Vendas");
        btVendas.setPreferredSize(new java.awt.Dimension(150, 70));
        btVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendasActionPerformed(evt);
            }
        });

        btFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fornecedor.png"))); // NOI18N
        btFornecedor.setText("Fornecedores");
        btFornecedor.setPreferredSize(new java.awt.Dimension(150, 70));
        btFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFornecedorActionPerformed(evt);
            }
        });

        btCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compras (1).png"))); // NOI18N
        btCompras.setText("Compras");
        btCompras.setPreferredSize(new java.awt.Dimension(150, 70));
        btCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprasActionPerformed(evt);
            }
        });

        btFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/funcionario.png"))); // NOI18N
        btFuncionarios.setText("Funcionários");
        btFuncionarios.setPreferredSize(new java.awt.Dimension(150, 70));
        btFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFuncionariosActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbHora.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        lbNomeDoUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        lbData.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        lbUsuario1.setText("<html> <strong>Usuário:</strong></html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lbNomeDoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1295, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNomeDoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbUsuario1)
                    .addContainerGap()))
        );

        btLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        btLogout.setText("Logout");
        btLogout.setPreferredSize(new java.awt.Dimension(150, 70));
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelBackgroundLayout = new javax.swing.GroupLayout(PainelBackground);
        PainelBackground.setLayout(PainelBackgroundLayout);
        PainelBackgroundLayout.setHorizontalGroup(
            PainelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelBackgroundLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(PainelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelBackgroundLayout.createSequentialGroup()
                        .addComponent(btClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PainelBackgroundLayout.setVerticalGroup(
            PainelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBackgroundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PainelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelBackground.setLayer(btSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btVendas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btFornecedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btCompras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btFuncionarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelBackground.setLayer(btLogout, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuCadastro.setText("Cadastro");

        jMenuItemClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemClientes);

        jMenuItemFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemFornecedores);

        jMenuItemProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemProdutos.setText("Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemProdutos);

        jMenuItemFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItemFuncionarios.setText("Funcionários");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemFuncionarios);

        jMenuBar1.add(jMenuCadastro);

        jMenuEstoque.setText("Estoque");

        jMenuControleDeEstoque.setText("Controle de Estoque");

        jMenuItemEntradaDeEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItemEntradaDeEstoque.setText("Entrada de Estoque");
        jMenuItemEntradaDeEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEntradaDeEstoqueActionPerformed(evt);
            }
        });
        jMenuControleDeEstoque.add(jMenuItemEntradaDeEstoque);

        jMenuEstoque.add(jMenuControleDeEstoque);

        jMenuRelatorios.setText("Relatórios");

        jMenuItemProdutosEmFalta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItemProdutosEmFalta.setText("Produtos em Falta");
        jMenuRelatorios.add(jMenuItemProdutosEmFalta);

        jMenuEstoque.add(jMenuRelatorios);

        jMenuBar1.add(jMenuEstoque);

        jMenuVendas.setText("Vendas");

        jMenuItemEfetiarVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItemEfetiarVenda.setText("Efetuar Venda");
        jMenuItemEfetiarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEfetiarVendaActionPerformed(evt);
            }
        });
        jMenuVendas.add(jMenuItemEfetiarVenda);

        jMenuBar1.add(jMenuVendas);

        jMenuCompras.setText("Compras");

        jMenuItemEfetuarCompras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItemEfetuarCompras.setText("Efetuar Compras");
        jMenuItemEfetuarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEfetuarComprasActionPerformed(evt);
            }
        });
        jMenuCompras.add(jMenuItemEfetuarCompras);

        jMenuBar1.add(jMenuCompras);

        jMenuContas.setText("Contas");

        jMenuItemContasAReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItemContasAReceber.setText("Contas a Receber");
        jMenuItemContasAReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasAReceberActionPerformed(evt);
            }
        });
        jMenuContas.add(jMenuItemContasAReceber);

        jMenuItemContasAPagar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItemContasAPagar.setText("Contas a Pagar");
        jMenuItemContasAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasAPagarActionPerformed(evt);
            }
        });
        jMenuContas.add(jMenuItemContasAPagar);

        jMenuBar1.add(jMenuContas);

        jMenu6.setText("Sistema");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemSobre);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemLogout);

        jMenuItemSair.setText("Sair do Sistema");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemSair);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
            // TODO add your handling code here:
            controller.botaoSair();
                   

    }//GEN-LAST:event_btSairActionPerformed

    private void btFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFornecedorActionPerformed
        controller.janelaFornecedor();
    }//GEN-LAST:event_btFornecedorActionPerformed

    private void jMenuItemFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedoresActionPerformed
        controller.janelaFornecedor();
    }//GEN-LAST:event_jMenuItemFornecedoresActionPerformed

    private void jMenuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutosActionPerformed
        controller.janelaProdutos();
    }//GEN-LAST:event_jMenuItemProdutosActionPerformed

    private void jMenuItemEntradaDeEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEntradaDeEstoqueActionPerformed
        controller.janelaEstoque();
    }//GEN-LAST:event_jMenuItemEntradaDeEstoqueActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        controller.janelaCliente();
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionariosActionPerformed
        controller.janelaFuncionario();
    }//GEN-LAST:event_jMenuItemFuncionariosActionPerformed

    private void jMenuItemEfetiarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEfetiarVendaActionPerformed
        controller.janelaVendas();
    }//GEN-LAST:event_jMenuItemEfetiarVendaActionPerformed

    private void jMenuItemEfetuarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEfetuarComprasActionPerformed
       controller.janelaCompras();
    }//GEN-LAST:event_jMenuItemEfetuarComprasActionPerformed

    private void jMenuItemContasAReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasAReceberActionPerformed
        controller.janelaContasAReceber();
    }//GEN-LAST:event_jMenuItemContasAReceberActionPerformed

    private void jMenuItemContasAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasAPagarActionPerformed
        controller.janelaContasAPagar();
    }//GEN-LAST:event_jMenuItemContasAPagarActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        new SobreView().setVisible(true);
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        try {
            controller.logout();
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        controller.botaoSair();


    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        controller.janelaCliente();
        
    }//GEN-LAST:event_btClientesActionPerformed

    private void btFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFuncionariosActionPerformed
        controller.janelaFuncionario();
    }//GEN-LAST:event_btFuncionariosActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        controller.janelaProdutos();
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendasActionPerformed
        controller.janelaVendas();
    }//GEN-LAST:event_btVendasActionPerformed

    private void btComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprasActionPerformed
        controller.janelaCompras();
    }//GEN-LAST:event_btComprasActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        // TODO add your handling code here:
        new SobreView().setVisible(true);
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        try {
            controller.logout();
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btLogoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controller.horario();
        controller.data();
    }//GEN-LAST:event_formWindowOpened

    public JLabel getLbData() {
        return lbData;
    }

    public void setLbData(JLabel lbData) {
        this.lbData = lbData;
    }

    public JLabel getLbHora() {
        return lbHora;
    }

    public void setLbHora(JLabel lbHora) {
        this.lbHora = lbHora;
    }

    public JButton getBtClientes() {
        return btClientes;
    }

    public void setBtClientes(JButton btClientes) {
        this.btClientes = btClientes;
    }

    public JButton getBtCompras() {
        return btCompras;
    }

    public void setBtCompras(JButton btCompras) {
        this.btCompras = btCompras;
    }

    public JButton getBtFornecedor() {
        return btFornecedor;
    }

    public void setBtFornecedor(JButton btFornecedor) {
        this.btFornecedor = btFornecedor;
    }

    public JButton getBtFuncionarios() {
        return btFuncionarios;
    }

    public void setBtFuncionarios(JButton btFuncionarios) {
        this.btFuncionarios = btFuncionarios;
    }

    public JButton getBtLogout() {
        return btLogout;
    }

    public void setBtLogout(JButton btLogout) {
        this.btLogout = btLogout;
    }

    public JButton getBtProdutos() {
        return btProdutos;
    }

    public void setBtProdutos(JButton btProdutos) {
        this.btProdutos = btProdutos;
    }

    public JButton getBtSair() {
        return btSair;
    }

    public void setBtSair(JButton btSair) {
        this.btSair = btSair;
    }

    public JButton getBtVendas() {
        return btVendas;
    }

    public void setBtVendas(JButton btVendas) {
        this.btVendas = btVendas;
    }

    public JMenu getjMenuCadastro() {
        return jMenuCadastro;
    }

    public void setjMenuCadastro(JMenu jMenuCadastro) {
        this.jMenuCadastro = jMenuCadastro;
    }

    public JMenu getjMenuCompras() {
        return jMenuCompras;
    }

    public void setjMenuCompras(JMenu jMenuCompras) {
        this.jMenuCompras = jMenuCompras;
    }

    public JMenu getjMenuContas() {
        return jMenuContas;
    }

    public void setjMenuContas(JMenu jMenuContas) {
        this.jMenuContas = jMenuContas;
    }

    public JMenu getjMenuControleDeEstoque() {
        return jMenuControleDeEstoque;
    }

    public void setjMenuControleDeEstoque(JMenu jMenuControleDeEstoque) {
        this.jMenuControleDeEstoque = jMenuControleDeEstoque;
    }

    public JMenu getjMenuEstoque() {
        return jMenuEstoque;
    }

    public void setjMenuEstoque(JMenu jMenuEstoque) {
        this.jMenuEstoque = jMenuEstoque;
    }

    public JMenu getjMenuSistema() {
        return jMenu6;
    }

    public void setjMenuSistema(JMenu jMenuSistema) {
        this.jMenu6 = jMenuSistema;
    }

    public JMenu getjMenuVendas() {
        return jMenuVendas;
    }

    public void setjMenuVendas(JMenu jMenuVendas) {
        this.jMenuVendas = jMenuVendas;
    }

    public JDesktopPane getPainelBackground() {
        return PainelBackground;
    }

    public void setPainelBackground(JDesktopPane PainelBackground) {
        this.PainelBackground = PainelBackground;
    }

    public JLabel getLbNomeDoUsuario() {
        return lbNomeDoUsuario;
    }

    public void setLbNomeDoUsuario(JLabel lbNomeDoUsuario) {
        this.lbNomeDoUsuario = lbNomeDoUsuario;
    }
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane PainelBackground;
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btCompras;
    private javax.swing.JButton btFornecedor;
    private javax.swing.JButton btFuncionarios;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btProdutos;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btVendas;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuCompras;
    private javax.swing.JMenu jMenuContas;
    private javax.swing.JMenu jMenuControleDeEstoque;
    private javax.swing.JMenu jMenuEstoque;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemContasAPagar;
    private javax.swing.JMenuItem jMenuItemContasAReceber;
    private javax.swing.JMenuItem jMenuItemEfetiarVenda;
    private javax.swing.JMenuItem jMenuItemEfetuarCompras;
    private javax.swing.JMenuItem jMenuItemEntradaDeEstoque;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemProdutosEmFalta;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuVendas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbNomeDoUsuario;
    private javax.swing.JLabel lbUsuario1;
    // End of variables declaration//GEN-END:variables

    private static class icon {

        private static Image getImage() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public icon() {
        }
    }
}
