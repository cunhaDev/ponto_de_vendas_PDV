/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View; 
        
 
import Conexao.Conectar;
import Conexao.ConexaoMySql;
import Controller.ControllerAbrirTuur;
import Controller.ControllerId;
import Controller.ControllerVendaProduto;
import Controller.ControllerVendaProdutoCartao;
import Controller.ControllerVendaProdutoTickets;
import Controller.Controllervenda;
import Controller.ControllervendaCartao;
import Controller.ControllervendaTickets;
import Dao.DaoAbrirTurno;
import Dao.DaoVenda2;
import Model.ModelAbrirTurno;
import Model.ModelId;
import Model.ModelVenda;
import Model.ModelVendaCartao;
import Model.ModelVendaProduto;
import Model.ModelVendaProdutoCartao;
import Model.ModelVendaProdutoTickets;
import Model.ModelVendaTickets;
import View.ViewPrincipal.horas;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**    
 * 
 * @author Monet 
 */     
public class ViewPrincipal extends javax.swing.JFrame { 
     ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
     ControllerAbrirTuur controllerAbrirturno = new ControllerAbrirTuur();
     ArrayList<ModelAbrirTurno> listaModelAbrirTuurno = new ArrayList<>();  
     ViewAbrirTurnoo viewAbrirTurno = new ViewAbrirTurnoo();
     
     ModelVenda modelVenda = new ModelVenda();
     Controllervenda controllerVenda = new Controllervenda();
     ArrayList<ModelVenda> listaModelVenda = new ArrayList<>();
     
     ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
     ControllerVendaProduto controllerVendaProduto = new ControllerVendaProduto();
     ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
     
     ModelVendaCartao modelVendaCartao = new ModelVendaCartao();
     ControllervendaCartao controllerVendaCartao = new ControllervendaCartao();
     ArrayList<ModelVendaCartao> listaModelVendaCartao = new ArrayList<>();
     
     ModelVendaProdutoCartao modelVendaProdutoCartao = new ModelVendaProdutoCartao();
     ControllerVendaProdutoCartao controllerVendaProdutoCartao = new ControllerVendaProdutoCartao();
     ArrayList<ModelVendaProdutoCartao> listaModelVendaProdutoCartao = new ArrayList<>();
     
     ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
     ControllervendaTickets controllerVendaTickets = new ControllervendaTickets();
     ArrayList<ModelVendaTickets> listaModeVendaTickets = new ArrayList<>();
     
     ModelVendaProdutoTickets modelVendaProdutoTickets = new ModelVendaProdutoTickets();
     ControllerVendaProdutoTickets controllerVendaProdutoTickets = new ControllerVendaProdutoTickets();
     ArrayList<ModelVendaProdutoTickets> listaModelVendaProdutoTickets = new ArrayList<>();
    /**
     * Creates new form View      
     */ 
     
     DaoVenda2 daoVendas2 = new DaoVenda2();
    
    public ViewPrincipal() throws SQLException{ 
    initComponents();
    DaoVenda2.numerosTurnos2();
    setIcon();
    setLocationRelativeTo(null);      
    // retornaLista();
    
    //mostrarTurno();
    } 
     
     class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            tfHora.setText(String.format(formato.format(sistemaHora), now));
        }
    } 

   
    
    private void mostrarTurno(){
    ModelId modelId = new ModelId();
    ControllerId controllerId = new ControllerId();
    modelId = controllerId.buscaIdController(2);    
    tfTurno.setText(modelId.getNumero()+""); 
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        tfHora = new javax.swing.JLabel();
        tfData = new javax.swing.JLabel();
        tfTipoOperador = new javax.swing.JLabel();
        tfNomeOperador = new javax.swing.JLabel();
        tfIdOperador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTurno = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        opcao_cancelar_venda = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE VENDAS E CONTROLE DE ESTOQUE. LIBERADO PARA MERCADINHO JOAO PAULO I / CNPJ:26.635.415/0001-25 ");
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/telapdv2.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "ESTOQUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setEnabled(false);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
        }

        tfHora.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfHora.setText("09:12:08");

        tfData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfData.setText("30/11/2020");

        tfTipoOperador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTipoOperador.setForeground(new java.awt.Color(255, 255, 255));
        tfTipoOperador.setText("a");

        tfNomeOperador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNomeOperador.setText("a");

        tfIdOperador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfIdOperador.setForeground(new java.awt.Color(255, 255, 255));
        tfIdOperador.setText("0");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/UU.png"))); // NOI18N

        tfTurno.setText("Turno:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTipoOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(346, 346, 346))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfNomeOperador))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(tfIdOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(tfTipoOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(294, 294, 294)
                .addComponent(tfTurno)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/carrinho.png"))); // NOI18N
        jMenu4.setText("BALCÃO DE VENDA");

        jMenuItem16.setText("ABRIR TURNO");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem15.setText("BALCÃO DE VENDAS");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem6.setText("VENDAS REALIZADAS NESSE TURNO");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        opcao_cancelar_venda.setText("CANCELAR/ALTREAR VENDA");
        opcao_cancelar_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcao_cancelar_vendaActionPerformed(evt);
            }
        });
        jMenu4.add(opcao_cancelar_venda);

        jMenuItem21.setText("FECHAR TURNO");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem21);

        jMenuItem3.setText("IMPRIMIR CUPOM  (VENDA DINHEIRO)");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("IMPRIMIR CUPOM (VENDA NO CARTÃO)");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("IMPRIMIR CUPOM (VENDA NO TICKET)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("CONFIGURAÇÕES");
        jMenu1.setEnabled(false);

        jMenuItem1.setText("Impressora");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu13.setText("ACESSO");

        jMenuItem42.setText("TROCAR USUÁRIO");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem42);

        jMenuBar1.add(jMenu13);

        jMenu2.setText("SOBRE");

        jMenuItem2.setText("Sobre o sistema");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1082, 834);
    }// </editor-fold>//GEN-END:initComponents

    private void opcao_cancelar_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcao_cancelar_vendaActionPerformed
    ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
    ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
    ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();            
    listaturno = controllerAbrirTuur.listaModelUsuarioController();       
    for (int i = 0; i < listaturno.size(); i++) {           
    listaturno.get(i).getEstado();
    if(listaturno.get(i).getEstado().equals("Liberado")){
    JOptionPane.showMessageDialog(null, "Você precisa abrir um turno!");
    }else{
    ViewVenda2 venda = new ViewVenda2();
    //tfIdOperador.setText(venda.tfCodigoUsuario.getText());
    venda.setVisible(true);
    venda.setLocationRelativeTo(null);
    }           
    }
    }//GEN-LAST:event_opcao_cancelar_vendaActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
   
    ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
    ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
    ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
      
      
     listaturno = controllerAbrirTuur.listaModelUsuarioController();       
        for (int i = 0; i < listaturno.size(); i++) {           
        listaturno.get(i).getEstado();
        if(listaturno.get(i).getEstado().equals("Liberado")){
        JOptionPane.showMessageDialog(null, "Você precisa abrir um turno!");
        }else{
        ViewPdv555 pdv = new ViewPdv555();
        pdv = new ViewPdv555();
        pdv.tfUsuarioID.setText(tfIdOperador.getText());
        pdv.tfusuarionome.setText(tfNomeOperador.getText()); 
        pdv.tfTurno.setText(tfTurno.getText()); 
        pdv.setVisible(true); 
        pdv.setLocationRelativeTo(null);
        }   
           
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed
 
    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
    
    ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
    ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
    ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
    ViewFecharTurno fechar = new ViewFecharTurno();

    listaturno = controllerAbrirTuur.listaModelUsuarioController();       
    for (int i = 0; i < listaturno.size(); i++) {           
    listaturno.get(i).getEstado();
    int idUser = listaturno.get(i).getId();
    
    if(listaturno.get(i).getEstado().equals("Liberado")){
    JOptionPane.showMessageDialog(null, "Você precisa abrir um turno!");
    }else{
         
    if(idUser != Integer.parseInt(tfIdOperador.getText())){
    JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");   
   
    }else{
    fechar.setVisible(true);
    fechar.setLocationRelativeTo(null);
    dispose();
                }
        
    }
    }
        
    modelAbrirTurno = new ModelAbrirTurno();
    modelAbrirTurno = controllerAbrirTuur.retornarTurnoController(Integer.parseInt(tfIdOperador.getText())); 
    fechar.tfNumeroTurno.setText(String.valueOf(modelAbrirTurno.getPk_id_abrir_turno()));
    fechar.tfIdOperador.setText(String.valueOf(modelAbrirTurno.getId()));
    fechar.tfNomeoperador.setText(String.valueOf(modelAbrirTurno.getNome()));
    fechar.tfDataAbertura.setText(String.valueOf(modelAbrirTurno.getData())); 
    fechar.tfHoraAbertura.setText(String.valueOf(modelAbrirTurno.getHora())); 
       
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
     ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
    ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
    ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
     
        
     listaturno = controllerAbrirTuur.listaModelUsuarioController();       
        for (int i = 0; i < listaturno.size(); i++) {           
        listaturno.get(i).getEstado();
        if(listaturno.get(i).getEstado().equals("Aberto")){
        JOptionPane.showMessageDialog(null, "Já existe um turno aberto!");
        JOptionPane.showMessageDialog(null, "Você precisa fechar este turno para abrir um novo!");
        }else{
        viewAbrirTurno = new ViewAbrirTurnoo();
         viewAbrirTurno.tfNomeOperador.setText(tfNomeOperador.getText());
         viewAbrirTurno.tfCodigoOperador.setText(tfIdOperador.getText());
         viewAbrirTurno.setLocationRelativeTo(null);
         viewAbrirTurno.setVisible(true);
   
        }   
          
        }
        
        
        
        
     
    }//GEN-LAST:event_jMenuItem16ActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
        tfData.setText(formato.format(sistemaData));
        
        //HORA DO SISTEMA
        Timer hr = new Timer(100, new ViewPrincipal.horas());
        hr.start();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
    dispose(); 
    ViewLogin viewLogin = new ViewLogin();
    viewLogin.setVisible(true);
    viewLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
        imprimirCupom(listaModelVendaProduto, modelVenda);    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
        imprimirCupomVendaCartao(listaModelVendaProdutoCartao, modelVendaCartao);    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
        imprimirCupomVendaTicket(listaModelVendaProdutoTickets, modelVendaTickets);    
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    ViewVenda3 v = new ViewVenda3();
    v.setVisible(true);
    v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    
    
    private void imprimirCupom(ArrayList<ModelVendaProduto> listaModelVendaProduto, ModelVenda modelVenda){
        String conteudoImprimir = "";
        String numero = JOptionPane.showInputDialog("Informe o número da venda");
        modelVenda = controllerVenda.getvendaController(Integer.parseInt(numero)); 
        if(!numero.equals(String.valueOf(modelVenda.getIdVenda()))){
        JOptionPane.showMessageDialog(null, "Venda não encontrada!");    
        }else{
        listaModelVendaProduto = new ArrayList<>();
        listaModelVendaProduto = controllerVendaProduto.getListaVendaProdutoControllerpeloCodigo(Integer.parseInt(numero));
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
        conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
        listaModelVendaProduto.get(x).getQuantidade() +"   "+
        listaModelVendaProduto.get(x).getValorVenda() +"    "+
        listaModelVendaProduto.get(x).getNome_produto() +"\n\r";  
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          MERCADINHO JOAO PAULO I          \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "                  2º VIA                  \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+modelVenda.getPagamento()+"\n\r"      
        + "Vendedor: "+tfNomeOperador.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        +"\n\r \n\r \f"
        + "");
        JOptionPane.showMessageDialog(null, "A venda de número: "+numero+" foi encotrada. \n"
                                            + "Ela possui o valor liquido de: R$"+modelVenda.getValorLiquido()+" \n"
                                            + "Verifique se foi imprimido a sua venda \n"
                                            + "Caso contrario reinicie a impressora!");
        System.out.println(modelVenda.getValorLiquido());
        System.out.println(conteudoImprimir);
        }
      }
    
    
    private void imprimirCupomVendaCartao(ArrayList<ModelVendaProdutoCartao> listaModelVendaProduto, ModelVendaCartao modelVenda){
        String conteudoImprimir = "";
        String numero = JOptionPane.showInputDialog("Informe o número da venda");
        modelVenda = controllerVendaCartao.getvendaController(Integer.parseInt(numero)); 
        if(!numero.equals(String.valueOf(modelVenda.getIdVenda()))){
        JOptionPane.showMessageDialog(null, "Venda não encontrada!");    
        }else{
        listaModelVendaProduto = new ArrayList<>();
        listaModelVendaProduto = controllerVendaProdutoCartao.getListaVendaProdutoControllerpeloCodigo(Integer.parseInt(numero));
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
        conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
        listaModelVendaProduto.get(x).getQuantidade() +"   "+
        listaModelVendaProduto.get(x).getValorVenda() +"    "+
        listaModelVendaProduto.get(x).getNome_produto() +"\n\r";  
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          MERCADINHO JOAO PAULO I          \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "                  2º VIA                  \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: Cartão de credito \n\r"      
        + "Vendedor: "+tfNomeOperador.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        +"\n\r \n\r \f"
        + "");
        JOptionPane.showMessageDialog(null, "A venda de número: "+numero+" foi encotrada. \n"
                                            + "Ela possui o valor liquido de: R$"+modelVenda.getValorLiquido()+" \n"
                                            + "Verifique se foi imprimido a sua venda \n"
                                            + "Caso contrario reinicie a impressora!");
        System.out.println(modelVenda.getValorBruto());
        System.out.println(conteudoImprimir);
        }
      }
    
    
     private void imprimirCupomVendaTicket(ArrayList<ModelVendaProdutoTickets> listaModelVendaProduto, ModelVendaTickets modelVenda){
        String conteudoImprimir = ""; 
        String numero = JOptionPane.showInputDialog("Informe o número da venda");
        modelVenda = controllerVendaTickets.getvendaController(Integer.parseInt(numero)); 
        listaModelVendaProduto = new ArrayList<>();
        listaModelVendaProduto = controllerVendaProdutoTickets.getListaVendaProdutoControllerpeloCodigo(Integer.parseInt(numero));
        if(!numero.equals(String.valueOf(modelVenda.getIdVenda()))){
        JOptionPane.showMessageDialog(null, "Venda não encontrada!");    
        }else{
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
        conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
        listaModelVendaProduto.get(x).getQuantidade() +"   "+
        listaModelVendaProduto.get(x).getValorVenda() +"    "+
        listaModelVendaProduto.get(x).getNome_produto() +"\n\r";  
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          MERCADINHO JOAO PAULO I          \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "                  2º VIA                  \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: Cartão de credito \n\r"      
        + "Vendedor: "+tfNomeOperador.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        +"\n\r \n\r \f" 
        + "");
        JOptionPane.showMessageDialog(null, "A venda de número: "+numero+" foi encotrada. \n"
                                            + "Ela possui o valor liquido de: R$"+modelVenda.getValorLiquido()+" \n"
                                            + "Verifique se foi imprimido a sua venda \n"
                                            + "Caso contrario reinicie a impressora!");
        System.out.println(modelVenda.getValorBruto());
        System.out.println(conteudoImprimir);
        }
      }
    
    
    
    
    public void imprimir(String pTexto){
        try {
            InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor doqFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, doqFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            //pega a impressora padrao
            PrintRequestAttributeSet printAtribut = new HashPrintRequestAttributeSet();
            printAtribut.add(new JobName("Impressao", null));
            printAtribut.add(OrientationRequested.PORTRAIT);
            printAtribut.add(MediaSizeName.ISO_A4);
            
            //informe o tipo da folha
            DocPrintJob printJob = impressora.createPrintJob();
            try {
            printJob.print(documentoTexto, (PrintRequestAttributeSet) printAtribut);
            //tenta imprimir
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Nao foi possivel realizar essa impressao!!!");
            }
            prin.close();
        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                try {
                    new ViewPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JMenuItem opcao_cancelar_venda;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel tfData;
    private javax.swing.JLabel tfHora;
    public static javax.swing.JLabel tfIdOperador;
    public static javax.swing.JLabel tfNomeOperador;
    public static javax.swing.JLabel tfTipoOperador;
    public static javax.swing.JLabel tfTurno;
    // End of variables declaration//GEN-END:variables

private void setIcon() {
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/comp.png"))); 
    }

}
