/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */           
package View;                 
                           
import Conexao.Conectar;              
import Conexao.Conectar2;    
import Controller.ControllerAbrirTuur;
import Controller.ControllerId;
import Controller.ControllerUsuario;            
import Model.ModelAbrirTurno;
import Model.ModelId;
import Model.ModelUsuario;       
import java.awt.Toolkit;   
import java.sql.Connection;       
import java.sql.PreparedStatement;    
import java.sql.ResultSet;
import java.sql.Statement;   
import java.util.ArrayList;   
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;     
import javax.swing.text.BadLocationException;  
import javax.swing.text.Document;      
import javax.swing.text.PlainDocument;
        
/**   
 *
 * @author Monet
 */  
public class ViewLogin extends javax.swing.JFrame {
    ModelUsuario mod = new ModelUsuario();
    ControllerUsuario cont = new ControllerUsuario();
    ArrayList<ModelUsuario> list = new ArrayList<>();
     
    
     ViewSplash inicio; 
    /**    
     * Creates new form ViewLogin   
     */     
    public ViewLogin() {       
       initComponents();  
       setIcon();
       setLocationRelativeTo(null); 
       tfSenha.setDocument(new Documento());        
    }       
 public ViewLogin(ViewSplash inicio){ 
        this.inicio = inicio;
        setProgress(0, "Inicializando...");
        initComponents();
        setProgress(20, "Conectando...");    
        setProgress(22, "Conectando ao Banco da internet..");
        setProgress(23, "Fazendo conexão com o host");    
        setProgress(24, "Carregando estoque...");
        setProgress(25, "Carregango relatórios...");     
        setProgress(26, "Analisando relatorios..."); 
        setProgress(30, "Analisando dados do servidor...");
        setProgress(98, "Servidor quase completo...");
        setProgress(99, "Só mais um pouco...");
        setProgress(100, "Pronto!...");
        
        //this.setSize(410,500); 
        
    }
 

 
    void setProgress(int percent, String informacao){
        inicio.getJLabel().setText(informacao);
        inicio.getJProgressBar().setValue(percent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar a inicialização");
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

        jPanel1 = new javax.swing.JPanel();
        tfIdUsuario = new javax.swing.JTextField();
        tfTipo = new javax.swing.JLabel();
        tfSexo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        tfSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tfIdUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfIdUsuarioFocusLost(evt);
            }
        });

        tfTipo.setForeground(new java.awt.Color(255, 255, 255));
        tfTipo.setText("jLabel4");

        tfSexo.setForeground(new java.awt.Color(255, 255, 255));
        tfSexo.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(tfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(tfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTipo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSexo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ENTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Digite seu login:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Digite sua senha:");

        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cancelar");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Se você ainda não está cadastrado solicite");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ao administrador do sistema que crie seu usuário");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/senha.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7)))
                .addGap(93, 93, 93))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIdUsuarioFocusLost
  
    }//GEN-LAST:event_tfIdUsuarioFocusLost
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String us = tfLogin.getText();
        String pass = tfSenha.getText();
        if(us.equals("") || pass.equals("")){  
        JOptionPane.showMessageDialog(null, "Preencha os campos!");                      
        }else{   
        logar();     
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
    tfSenha.requestFocus();
    }//GEN-LAST:event_tfLoginActionPerformed

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
    String us = tfLogin.getText();
        String pass = tfSenha.getText();
        if(us.equals("") || pass.equals("")){
        JOptionPane.showMessageDialog(null, "Preencha os campos!");                    
        }else{ 
        logar();
        }
    }//GEN-LAST:event_tfSenhaActionPerformed


//INICIANDO A CONEXAO
    
           
          
    Conectar2 con = new Conectar2();      
    Connection cn = con.conexao();    
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void logar(){   
    String sql = "SELECT *from tbl_usuario where nome = ? and senha = ?";
        try { 
            pst = cn.prepareStatement(sql);
            pst.setString(1, tfLogin.getText());
            pst.setString(2, tfSenha.getText()); 
            rs = pst.executeQuery();  
            if(rs.next())  
            {
             String nome = rs.getString(2);
             int id = rs.getInt(1); 
             int tipo = rs.getInt(5);      
             int cadastro_cidade = rs.getInt(6);  
             int cadastro_usuario = rs.getInt(7);    
             int cadastro_estiva = rs.getInt(8);  
             int cadastro_cliente = rs.getInt(9);    
             int cadastro_estoque = rs.getInt(10);   
             int cadastro_fornecedor = rs.getInt(11);  
             int cadastro_departamento = rs.getInt(12);  
             int cadastro_bairro = rs.getInt(13);  
             int cadastro_rua = rs.getInt(14);  
             int pagar_conta = rs.getInt(15);  
             int retira_estoque = rs.getInt(16);  
             int relatorio_entrada_estoque = rs.getInt(17);  
             int relatorio_saida_estoque = rs.getInt(18);  
             int despesa = rs.getInt(19);           
             int relatorio_parcelamento = rs.getInt(20);             
             int relatorio_estoque = rs.getInt(21);                
             int relatorio_venda = rs.getInt(22); 
             
             int relatorio_turno = rs.getInt(23);   
             int relatorio_produto_maisVendidos = rs.getInt(24);    
             int relatorio_conta_paga = rs.getInt(25);    
                
             int cancelar_venda = rs.getInt(26);          
             int parcela_venda = rs.getInt(27);    
             int dar_desconto = rs.getInt(28);      
             int fazer_sangria = rs.getInt(29);      
             int abandonar_venda = rs.getInt(30);  
                
         
                      
             // System.out.println(tipo);
             ViewPrincipal p = new ViewPrincipal();
             p.tfIdOperador.setText(String.valueOf(id));
             p.tfNomeOperador.setText(nome);
             p.setVisible(true);
              //a linha abaixo é para colocar as funções do SysLoja
             if(tipo != 1)
             {
             p.opcao_cancelar_venda.setEnabled(false);  
             }           
             dispose();
             
             //a linha abaixo é para colocar as funções do PDV
            
            }else
            {
             JOptionPane.showMessageDialog(null, "Senha incorreta!");   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário inválido!");
        }
    
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfIdUsuario;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JLabel tfSexo;
    private javax.swing.JLabel tfTipo;
    // End of variables declaration//GEN-END:variables
  
    private void setIcon() {  
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/comp.png"))); 
    }  

 class Documento extends PlainDocument{  
     
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            
        
        int tam = (this.getLength() + str.length());
     if(tam <=4){ 
     super.insertString(offs, str.replaceAll("[aA-zZ]", ""), a);     
     }else{
     super.insertString(offs, str.replaceAll("{aAo-zZ9}", ""), a);
     }
       } catch (Exception e) {
           
        } 
    }




}

}