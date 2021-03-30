/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import Controller.ControllerProduto;
import Controller.ControllerProdutoVendaProduto;
import Controller.ControllerVendaCliente;
import Controller.ControllerVendaProduto;
import Controller.ControllerVendaProduto2;
import Controller.ControllerVendaProdutoCartao;
import Controller.ControllerVendaProdutoTickets;
import Controller.Controllervenda;
import Controller.Controllervenda2;
import Controller.ControllervendaCancelada;
import Controller.ControllervendaCancelamentoCartao;
import Controller.ControllervendaCancelamentoTickets;
import Controller.ControllervendaCartao;
import Controller.ControllervendaTickets;
import Model.ModelCliente;
import Model.ModelProduto;
import Model.ModelProdutoVendaProduto;
import Model.ModelVenda;
import Model.ModelVenda2;
import Model.ModelVendaCancelamento;
import Model.ModelVendaCancelamentoCartao;
import Model.ModelVendaCancelamentoTickets;
import Model.ModelVendaCartao;
import Model.ModelVendaCliente;
import Model.ModelVendaProduto;
import Model.ModelVendaProduto2;
import Model.ModelVendaProdutoCartao;
import Model.ModelVendaProdutoTickets;
import Model.ModelVendaTickets;
import Util.Formatador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Monet
 */
public class ViewVenda2 extends javax.swing.JFrame {
    Formatador formatador = new Formatador();
    DecimalFormat df = new DecimalFormat("##.##");
    ModelProduto modelProduto = new ModelProduto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
    
    ModelVendaCliente modelVendaCliente = new ModelVendaCliente();
    ControllerVendaCliente controllerVendaCliente = new ControllerVendaCliente();
    ArrayList<ModelVendaCliente> listaModelVendaCliente = new ArrayList<>();
    
    ModelVenda modelVenda = new ModelVenda();
    Controllervenda controllervenda = new Controllervenda();
    ArrayList<ModelVenda> listaModelVenda = new ArrayList<>();
     
    ModelVendaCartao modelVendaCartao = new ModelVendaCartao();
    ControllervendaCartao controllervendaCartao = new ControllervendaCartao();
    ArrayList<ModelVendaCartao> listaModelVendaCartao = new ArrayList<>();
    
    ModelVendaProdutoCartao modelVendaProdutoCartao = new ModelVendaProdutoCartao();
    ControllerVendaProdutoCartao controllerVendaProdutoCartao = new ControllerVendaProdutoCartao();
    ArrayList<ModelVendaProdutoCartao> listaModelVendaProdutoCartao=new ArrayList<>();
    
    ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
    ControllerVendaProduto controllerVendaProduto = new ControllerVendaProduto();
    ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
    
    ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
    ControllervendaTickets controllerVendaTickets = new ControllervendaTickets();
    ArrayList<ModelVendaTickets> listaModelVendaTickets=new ArrayList<>();
    
    ModelVendaProdutoTickets modelVendaProdutoTickets = new ModelVendaProdutoTickets();
    ControllerVendaProdutoTickets controllerVendaProdutoTickets = new ControllerVendaProdutoTickets();
    ArrayList<ModelVendaProdutoTickets> listaModelProdutosTickets = new ArrayList<>();
    
    ControllerProdutoVendaProduto controllerProdutoVendaProduto = new ControllerProdutoVendaProduto();
    ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProduto = new ArrayList<>();
    int quantidade =1;
    String alteraOuSalva; 
    /**
     * Creates new form ViewVenda2
     */
    public ViewVenda2() {
        initComponents();
        listandoVendas();   
        listandoVendasTickets();
        listandoVendasCartao();
        limparFormulario(); 
        tfDesconto.setDocument(new Documento()); 
     //   tfQuantidade.setDocument(new Documento());
    }
    
    
    private void somaValortotal(){
    try {    
    float soma =0, valor, valorLiquido, desconto;  
    int conta = tabelaFazendoVenda.getRowCount();
    for (int i = 0; i < conta; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaFazendoVenda.getValueAt(i, 5)));
    soma = soma+valor;
    } 
    desconto = Float.parseFloat(tfDesconto.getText()); 
    tfValorBruto.setText(formatador.arredondamentoValoresFloat(soma)); 
    valorLiquido = soma - desconto; 
    tfValorTotal.setText(formatador.arredondamentoValoresFloat(valorLiquido));
    
    aplicaDesconto();
    } catch (Exception e) {
        }
    } 
   
    
    private void aplicaDesconto(){
    try {
    tfValorTotal.setText(String.valueOf(
    Double.parseDouble(tfValorTotal.getText()) - Double.parseDouble(tfDesconto.getText())));
        } catch (Exception e) {
        } 
   
    }
    
   
    
    //listar vendas no dinheiro
    private void listandoVendas(){
    DefaultTableModel modelo = (DefaultTableModel) tabelaDinheiro.getModel();
    listaModelVenda = controllervenda.getListavendaController();
    int cont = listaModelVenda.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
    modelo.addRow(new Object[]{     
    listaModelVenda.get(i).getIdVenda(),
    listaModelVenda.get(i).getValorLiquido(),
    listaModelVenda.get(i).getHora()
    });
    }  
    }
    
    //listar vendas no tickets
    private void listandoVendasTickets(){
    DefaultTableModel modelo = (DefaultTableModel) tabelaTickets.getModel();
    listaModelVendaTickets = controllerVendaTickets.getListavendaController();
    int cont = listaModelVendaTickets.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
    modelo.addRow(new Object[]{
        
       listaModelVendaTickets.get(i).getIdVenda(),
       listaModelVendaTickets.get(i).getValorLiquido(),
       listaModelVendaTickets.get(i).getHora()     
        });
    }   
    }
    
    //listar vendas no cartao
    private void listandoVendasCartao(){
    DefaultTableModel modelo = (DefaultTableModel) tabelaCartao.getModel();
    listaModelVendaCartao = controllervendaCartao.getListavendaController();
    int cont = listaModelVendaCartao.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
    modelo.addRow(new Object[]{  
       listaModelVendaCartao.get(i).getIdVenda(),
       listaModelVendaCartao.get(i).getValorLiquido(),
       listaModelVendaCartao.get(i).getHora()
        });  
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDinheiro = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCartao = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaTickets = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfUsuarioSalvar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfPagamentoSalvar = new javax.swing.JTextField();
        tfValorLiqSalvar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfValorDescSalvar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfValorBrutoSalvar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfDataSalvar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfHoraSalvar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btDinheiro = new javax.swing.JButton();
        btCancelarDinheiro = new javax.swing.JButton();
        btCartao = new javax.swing.JButton();
        btCancelarCartao = new javax.swing.JButton();
        btTickets = new javax.swing.JButton();
        btCancelarTickets = new javax.swing.JButton();
        Tfpag = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCodCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDataDessaVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfHoraDessaVenda = new javax.swing.JTextField();
        tfDataAnual = new javax.swing.JLabel();
        tfDataMensal = new javax.swing.JLabel();
        tfData = new javax.swing.JLabel();
        tfHora = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfValorBruto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfValorTotal = new javax.swing.JTextField();
        tfIdUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFazendoVenda = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnSalvarVenda = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfNomeProduto = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfNumeroVenda = new javax.swing.JTextField();
        tfPagamento = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRefazerTickets = new javax.swing.JButton();
        btRefazerCartao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        tabelaDinheiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Valor", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDinheiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDinheiroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaDinheiro);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        tabelaCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Valor", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCartaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCartao);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        tabelaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Valor", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTicketsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaTickets);

        jScrollPane4.setViewportView(jScrollPane5);

        jLabel9.setText("Vendas À vista:");

        jLabel10.setText("Vendas no cartão de crédito:");

        jLabel11.setText("Vendas no ticket:");

        tfUsuarioSalvar.setEditable(false);
        tfUsuarioSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfUsuarioSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfUsuarioSalvar.setBorder(null);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("USUARIO:");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("PAGAMENTO:");

        tfPagamentoSalvar.setEditable(false);
        tfPagamentoSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfPagamentoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfPagamentoSalvar.setBorder(null);

        tfValorLiqSalvar.setEditable(false);
        tfValorLiqSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfValorLiqSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfValorLiqSalvar.setBorder(null);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("V.LIQUIDO:");

        tfValorDescSalvar.setEditable(false);
        tfValorDescSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfValorDescSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfValorDescSalvar.setBorder(null);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("V.DESCONTO:");

        tfValorBrutoSalvar.setEditable(false);
        tfValorBrutoSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfValorBrutoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfValorBrutoSalvar.setBorder(null);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("V.BRUTO:");

        tfDataSalvar.setEditable(false);
        tfDataSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfDataSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfDataSalvar.setBorder(null);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DATA:");

        tfHoraSalvar.setEditable(false);
        tfHoraSalvar.setBackground(new java.awt.Color(255, 255, 255));
        tfHoraSalvar.setForeground(new java.awt.Color(255, 255, 255));
        tfHoraSalvar.setBorder(null);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("HORA:");

        tfCliente.setEditable(false);
        tfCliente.setBackground(new java.awt.Color(255, 255, 255));
        tfCliente.setForeground(new java.awt.Color(255, 255, 255));
        tfCliente.setBorder(null);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CLIENTE:");

        tfId.setEditable(false);
        tfId.setBackground(new java.awt.Color(255, 255, 255));
        tfId.setForeground(new java.awt.Color(255, 255, 255));
        tfId.setBorder(null);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID:");

        btDinheiro.setText("DINHEIRO");
        btDinheiro.setEnabled(false);
        btDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDinheiroActionPerformed(evt);
            }
        });

        btCancelarDinheiro.setText("CANCELAR");
        btCancelarDinheiro.setEnabled(false);
        btCancelarDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarDinheiroActionPerformed(evt);
            }
        });

        btCartao.setText("CARTÃO");
        btCartao.setEnabled(false);
        btCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCartaoActionPerformed(evt);
            }
        });

        btCancelarCartao.setText("CANCELAR");
        btCancelarCartao.setEnabled(false);
        btCancelarCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarCartaoActionPerformed(evt);
            }
        });

        btTickets.setText("TICKETS");
        btTickets.setEnabled(false);
        btTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTicketsActionPerformed(evt);
            }
        });

        btCancelarTickets.setText("CANCELAR");
        btCancelarTickets.setEnabled(false);
        btCancelarTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarTicketsActionPerformed(evt);
            }
        });

        Tfpag.setText("Tipo Pagamento");

        tfCodigo.setText("Codigo da venda");

        jLabel23.setText("Desconto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btCancelarDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btCancelarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btCancelarTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel19)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel18)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel15)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel13)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel16)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfHoraSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfDataSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfValorBrutoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfValorDescSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfValorLiqSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfPagamentoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tfUsuarioSalvar)))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(83, 83, 83)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfCodigo)
                                    .addGap(194, 194, 194)
                                    .addComponent(Tfpag, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Tfpag)
                    .addComponent(tfCodigo)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDinheiro)
                            .addComponent(btCartao)
                            .addComponent(btTickets))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelarDinheiro)
                            .addComponent(btCancelarCartao)
                            .addComponent(btCancelarTickets))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHoraSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorBrutoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorDescSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorLiqSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPagamentoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsuarioSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vendas", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Código Cliente:");

        tfCodCliente.setEditable(false);
        tfCodCliente.setText("1");

        jLabel2.setText("Nome Cliente:");

        tfNomeCliente.setEditable(false);
        tfNomeCliente.setText("MERCADINHO");

        jLabel3.setText("Data dessa venda:");

        tfDataDessaVenda.setEditable(false);

        jLabel4.setText("Horário dessa venda:");

        tfHoraDessaVenda.setEditable(false);

        tfDataAnual.setForeground(new java.awt.Color(255, 255, 255));
        tfDataAnual.setText("Data Anual");

        tfDataMensal.setForeground(new java.awt.Color(255, 255, 255));
        tfDataMensal.setText("Data mensal");

        tfData.setForeground(new java.awt.Color(255, 255, 255));
        tfData.setText("Data");

        tfHora.setForeground(new java.awt.Color(255, 255, 255));
        tfHora.setText("Horas");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 255), 2, true));

        jLabel5.setText("Valor Bruto:");

        tfValorBruto.setEditable(false);

        jLabel6.setText("Desconto:");

        tfDesconto.setText(".00");
        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });

        jLabel7.setText("Valor Total:");

        tfValorTotal.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(tfValorBruto)
                    .addComponent(jLabel6)
                    .addComponent(tfDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(tfValorTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfIdUsuario.setForeground(new java.awt.Color(255, 255, 255));
        tfIdUsuario.setText("Código Usuario");

        tabelaFazendoVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "Id", "Produto", "Qtd.", "V. Unit.", "V. Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaFazendoVenda);
        if (tabelaFazendoVenda.getColumnModel().getColumnCount() > 0) {
            tabelaFazendoVenda.getColumnModel().getColumn(0).setPreferredWidth(25);
            tabelaFazendoVenda.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jButton2.setText("Remover produto");

        btnSalvarVenda.setText("Finalizar Dinheiro");
        btnSalvarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVendaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        tfNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfNomeProduto.setText("Refazer venda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setText("Código/Venda:");

        tfNumeroVenda.setEditable(false);

        tfPagamento.setForeground(new java.awt.Color(255, 255, 255));
        tfPagamento.setText("Pagamento");

        jButton1.setText("Remover produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRefazerTickets.setText("Finalizar Tickets");
        btnRefazerTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefazerTicketsActionPerformed(evt);
            }
        });

        btRefazerCartao.setText("Finalizar Cartão");
        btRefazerCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefazerCartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCodCliente))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(tfNumeroVenda)))
                    .addComponent(tfNomeCliente)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefazerTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRefazerCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfDataDessaVenda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfHoraDessaVenda)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfData)
                                .addGap(91, 91, 91)
                                .addComponent(tfHora))
                            .addComponent(tfIdUsuario)
                            .addComponent(tfDataAnual)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPagamento)
                            .addComponent(tfDataMensal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel21))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDataDessaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHoraDessaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfData)
                            .addComponent(tfHora))
                        .addGap(18, 18, 18)
                        .addComponent(tfIdUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataAnual)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jButton2)
                                .addGap(78, 78, 78)
                                .addComponent(btnRefazerTickets)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRefazerCartao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvarVenda)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(tfPagamento)
                                .addGap(15, 15, 15)
                                .addComponent(tfDataMensal)
                                .addGap(52, 52, 52))
                            .addComponent(jScrollPane1))
                        .addGap(31, 31, 31))))
        );

        jTabbedPane1.addTab("Alterar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDinheiroActionPerformed
        btnSalvarVenda.setEnabled(true);  
        btnRefazerTickets.setEnabled(false);
        btRefazerCartao.setEnabled(false);
        listaModelVenda = new ArrayList<>(); 
        listaProdutoVendaProduto = new ArrayList<>();

        alteraOuSalva = "alterar";
       
        int linha = tabelaDinheiro.getSelectedRow();
       // tfPagamento.setText((String) tabela.getValueAt(linha, 7));
        int cod = (int) tabelaDinheiro.getValueAt(linha, 0);  
        listaProdutoVendaProduto = controllerProdutoVendaProduto.listaProdutoVendaProduto(cod);
        DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaProdutoVendaProduto.size(); i++) { 
            
        tfNumeroVenda.setText(listaProdutoVendaProduto.get(i).getModelVendaProduto().getVenda()+"");
        tfPagamento.setText(Tfpag.getText());
        tfValorBruto.setText(tfValorBrutoSalvar.getText());
        tfValorTotal.setText(tfValorLiqSalvar.getText());
        tfDataDessaVenda.setText(tfDataSalvar.getText());
        tfHoraDessaVenda.setText(tfHoraSalvar.getText());
        tfCodCliente.setText(tfCliente.getText());
        tfIdUsuario.setText(tfUsuarioSalvar.getText());
        tfDesconto.setText(tfValorDescSalvar.getText());
        modelo.addRow(new Object[]{
        modelo.getRowCount()+1, 
        listaProdutoVendaProduto.get(i).getModelProduto().getId(),
        listaProdutoVendaProduto.get(i).getModelProduto().getNome(),
        listaProdutoVendaProduto.get(i).getModelVendaProduto().getQuantidade(),
        listaProdutoVendaProduto.get(i).getModelVendaProduto().getValorVenda(),
        listaProdutoVendaProduto.get(i).getModelVendaProduto().getQuantidade()
        *
        listaProdutoVendaProduto.get(i).getModelVendaProduto().getValorVenda()
        });
        for (int j = 0; j < listaModelVenda.size(); j++) {
        tfPagamento.setText(listaModelVenda.get(j).getPagamento());
        tfDesconto.setText(listaModelVenda.get(j).getValorDesconto()+"");
        }
        }
        
        somaValortotal();
        
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(0, false);
        buscaCliente();
    }//GEN-LAST:event_btDinheiroActionPerformed

    private void btCancelarDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarDinheiroActionPerformed
    ModelVendaCancelamento modelVendaCancelamento = new ModelVendaCancelamento();
    ControllervendaCancelada controllervendaCancelada = new ControllervendaCancelada();
    ArrayList<ModelVendaCancelamento> listaVendaCancela = new ArrayList<>();
    modelVendaCancelamento = new ModelVendaCancelamento();
    modelVendaCancelamento.setCliente(Integer.parseInt(tfCliente.getText()));
    modelVendaCancelamento.setData(String.valueOf(tfDataSalvar.getText()));
    modelVendaCancelamento.setHora(String.valueOf(tfHoraSalvar.getText()));
    modelVendaCancelamento.setPagamento(String.valueOf(tfPagamentoSalvar.getText()));
    modelVendaCancelamento.setUsuario(Integer.parseInt(tfUsuarioSalvar.getText()));
    modelVendaCancelamento.setValorBruto(Double.parseDouble(tfValorBrutoSalvar.getText()));
    modelVendaCancelamento.setValorDesconto(Double.parseDouble(tfValorDescSalvar.getText()));
    modelVendaCancelamento.setValorLiquido(Double.parseDouble(tfValorLiqSalvar.getText()));
    modelVendaCancelamento.setFkVenda(Integer.parseInt(tfId.getText()));
    controllervendaCancelada.salvarvendaController(modelVendaCancelamento);
  
    int linha = tabelaDinheiro.getSelectedRow();
    int cod = (int) tabelaDinheiro.getValueAt(linha, 0);  
    try {
        //cancelanado no terminal
        listaModelProduto = new ArrayList<>();
        listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProduto(cod);
        for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
        modelProduto = new ModelProduto();
        modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
        modelProduto.setEstoque(
        listaProdutoVendaProduto.get(i).getModelProduto().getEstoque()
        +
        listaProdutoVendaProduto.get(i).getModelVendaProduto().getQuantidade()
        );
        listaModelProduto.add(modelProduto);
        }
        if(controllerProduto.alterarEstoqueController(listaModelProduto)){
        controllerVendaProduto.excluirVendaProdutoControllerCodVenda(Integer.parseInt(tfCodigo.getText()));
        if(controllervenda.excluirvendaController(Integer.parseInt(tfCodigo.getText()))){
        JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso!");
        listandoVendas();
        dispose();
        }else{
        JOptionPane.showMessageDialog(null, "erro");
        } 
        }else{
        JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
        }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Selecione uma venda para excluir");
        }
    }//GEN-LAST:event_btCancelarDinheiroActionPerformed

    private void btCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCartaoActionPerformed
    btnSalvarVenda.setEnabled(false);  
    btnRefazerTickets.setEnabled(false); 
    btRefazerCartao.setEnabled(true);
    btRefazerCartao.setEnabled(true);
    controllerProdutoVendaProduto = new ControllerProdutoVendaProduto();
    listaProdutoVendaProduto = new ArrayList<>();
    alteraOuSalva = "alterar";  
    int linha = tabelaCartao.getSelectedRow();
    int cod = (int) tabelaCartao.getValueAt(linha, 0); 
    listaProdutoVendaProduto = controllerProdutoVendaProduto.listaProdutoVendaProdutoCartao(cod);
    DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();
    modelo.setNumRows(0); 
    for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
    tfNumeroVenda.setText(listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getVenda()+"");
    
    tfPagamento.setText(Tfpag.getText());
    tfValorBruto.setText(tfValorBrutoSalvar.getText());
    tfValorTotal.setText(tfValorLiqSalvar.getText());
    tfDataDessaVenda.setText(tfDataSalvar.getText());
    tfHoraDessaVenda.setText(tfHoraSalvar.getText());
    tfCodCliente.setText(tfCliente.getText());
    tfIdUsuario.setText(tfUsuarioSalvar.getText());
    tfDesconto.setText(tfValorDescSalvar.getText());
        modelo.addRow(new Object[]{
        modelo.getRowCount()+1, 
        listaProdutoVendaProduto.get(i).getModelProduto().getId(),
        listaProdutoVendaProduto.get(i).getModelProduto().getNome(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getQuantidade(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getValorVenda(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getQuantidade()
                *
        listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getValorVenda()
        });  
        }
        somaValortotal();
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(0, false);          // TODO add your handling code here:
    }//GEN-LAST:event_btCartaoActionPerformed

    private void btCancelarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarCartaoActionPerformed

        int linha = tabelaCartao.getSelectedRow();
        int cod = (int) tabelaCartao.getValueAt(linha, 0);
        ModelVendaCancelamentoCartao modelVendaCancelamento = new ModelVendaCancelamentoCartao();
        ControllervendaCancelamentoCartao controllervendaCancelada = new ControllervendaCancelamentoCartao();
        ArrayList<ModelVendaCancelamentoCartao>listaVendaCancela = new ArrayList<>();

        modelVendaCancelamento = new ModelVendaCancelamentoCartao();
        modelVendaCancelamento.setCliente(Integer.parseInt(tfCliente.getText()));
        modelVendaCancelamento.setData(String.valueOf(tfDataSalvar.getText()));
        modelVendaCancelamento.setHora(String.valueOf(tfHoraSalvar.getText()));
        modelVendaCancelamento.setUsuario(Integer.parseInt(tfUsuarioSalvar.getText()));
        modelVendaCancelamento.setValorBruto(Double.parseDouble(tfValorBrutoSalvar.getText()));
        modelVendaCancelamento.setValorDesconto(Double.parseDouble(tfValorDescSalvar.getText()));
        modelVendaCancelamento.setValorLiquido(Double.parseDouble(tfValorLiqSalvar.getText()));
        modelVendaCancelamento.setFkVenda(Integer.parseInt(tfId.getText()));
        controllervendaCancelada.salvarvendaController(modelVendaCancelamento);

        try {

            listaModelProduto = new ArrayList<>();
            listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProdutoCartao(cod);
            for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
                modelProduto = new ModelProduto();
                modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
                modelProduto.setEstoque(
                    listaProdutoVendaProduto.get(i).getModelProduto().getEstoque()
                    +
                    listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getQuantidade()
                );
                listaModelProduto.add(modelProduto);
            }
            if(controllerProduto.alterarEstoqueController(listaModelProduto)){
                controllerVendaProdutoCartao.excluirVendaProdutoControllerCodVenda(cod);
                if(controllervendaCartao.excluirvendaController(cod)){
                    JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso!");
                    listandoVendasCartao();
                    dispose();
                }else{ 
                    JOptionPane.showMessageDialog(null, "erro");
                }
            }else{
                JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma venda para excluir");
            dispose();
        }
    }//GEN-LAST:event_btCancelarCartaoActionPerformed

    private void btTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTicketsActionPerformed
        btnSalvarVenda.setEnabled(false);  
        btnRefazerTickets.setEnabled(true);
        btRefazerCartao.setEnabled(false);
        controllerProdutoVendaProduto = new ControllerProdutoVendaProduto();
        listaProdutoVendaProduto = new ArrayList<>();
        alteraOuSalva = "alterar";
        int linha = tabelaTickets.getSelectedRow();
        int cod = (int) tabelaTickets.getValueAt(linha, 0);

        listaProdutoVendaProduto = controllerProdutoVendaProduto.listaProdutoVendaProdutoTickts(cod);
        DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
        tfNumeroVenda.setText(listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getVenda()+"");
        tfPagamento.setText(Tfpag.getText());
        tfValorBruto.setText(tfValorBrutoSalvar.getText());
        tfValorTotal.setText(tfValorLiqSalvar.getText());
        tfDataDessaVenda.setText(tfDataSalvar.getText());
        tfHoraDessaVenda.setText(tfHoraSalvar.getText());
        tfCodCliente.setText(tfCliente.getText());
        tfIdUsuario.setText(tfUsuarioSalvar.getText());
        tfDesconto.setText(tfValorDescSalvar.getText());
        modelo.addRow(new Object[]{
        modelo.getRowCount()+1,   
        listaProdutoVendaProduto.get(i).getModelProduto().getId(),
        listaProdutoVendaProduto.get(i).getModelProduto().getNome(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getQuantidade(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getValorVenda(),
        listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getQuantidade()
        *
        listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getValorVenda()
        });
        }
        somaValortotal();
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(0, false);// TODO add your handling code here:
    }//GEN-LAST:event_btTicketsActionPerformed

    private void btCancelarTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarTicketsActionPerformed
        int linha = tabelaTickets.getSelectedRow();
        int cod = (int) tabelaTickets.getValueAt(linha, 0);
        ModelVendaCancelamentoTickets modelVendaCancelamento = new ModelVendaCancelamentoTickets();
        ControllervendaCancelamentoTickets controllervendaCancelada = new ControllervendaCancelamentoTickets();
        ArrayList<ModelVendaCancelamentoTickets>listaVendaCancela = new ArrayList<>();

        ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
        ControllervendaTickets controllerVendaTickets = new ControllervendaTickets();
        ArrayList<ModelVendaTickets> listaModelVendaTickets = new ArrayList<>();

        ModelVendaProdutoTickets modelVendaProdutoTickets = new ModelVendaProdutoTickets();
        ControllerVendaProdutoTickets controllerVendaProdutoTickets = new ControllerVendaProdutoTickets();
        ArrayList<ModelVendaProdutoTickets> listaModelVendaProdutoTickets = new ArrayList<>();

        modelVendaCancelamento = new ModelVendaCancelamentoTickets();
        modelVendaCancelamento.setCliente(Integer.parseInt(tfCliente.getText()));
        modelVendaCancelamento.setData(String.valueOf(tfDataSalvar.getText()));
        modelVendaCancelamento.setHora(String.valueOf(tfHoraSalvar.getText()));
        modelVendaCancelamento.setUsuario(Integer.parseInt(tfUsuarioSalvar.getText()));
        modelVendaCancelamento.setValorBruto(Double.parseDouble(tfValorBrutoSalvar.getText()));
        modelVendaCancelamento.setValorDesconto(Double.parseDouble(tfValorDescSalvar.getText()));
        modelVendaCancelamento.setValorLiquido(Double.parseDouble(tfValorLiqSalvar.getText()));
        modelVendaCancelamento.setFkVenda(Integer.parseInt(tfId.getText()));
        controllervendaCancelada.salvarvendaController(modelVendaCancelamento);
        try {

            listaModelProduto = new ArrayList<>();
            listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProdutoCartao(cod);
            for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
                modelProduto = new ModelProduto();
                modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
                modelProduto.setEstoque(
                    listaProdutoVendaProduto.get(i).getModelProduto().getEstoque()
                    +
                    listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getQuantidade()
                );
                listaModelProduto.add(modelProduto);
            }
            if(controllerProduto.alterarEstoqueController(listaModelProduto)){
                controllerVendaProdutoTickets.excluirVendaProdutoControllerCodVenda(cod);
                if(this.controllerVendaTickets.excluirvendaController(cod)){
                    JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso!");
                    dispose();

                    listandoVendasTickets();

                }else{
                    JOptionPane.showMessageDialog(null, "erro");
                }
            }else{
                JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma venda para excluir");

        }
    }//GEN-LAST:event_btCancelarTicketsActionPerformed

    private void tabelaDinheiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDinheiroMouseClicked
    setarCampos();
    int linha = tabelaDinheiro.getSelectedRow();
    int cod = (int) tabelaDinheiro.getValueAt(linha, 0);
    tfCodigo.setText(String.valueOf(cod));
    btCancelarTickets.setEnabled(false);
    btTickets.setEnabled(false);
    btCancelarCartao.setEnabled(false);
    btCartao.setEnabled(false);
    btDinheiro.setEnabled(true);
    btCancelarDinheiro.setEnabled(true); 
        
    }//GEN-LAST:event_tabelaDinheiroMouseClicked
    class hora implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    Date sistemaHora = new Date();
    String pmAm = "HH:mm:ss";
    SimpleDateFormat formato = new SimpleDateFormat(pmAm);
    Calendar now = Calendar.getInstance();
    tfHora.setText(String.format(formato.format(sistemaHora), now));
    }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    Date sistemaData = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    SimpleDateFormat formato1 = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat formato2 = new SimpleDateFormat("yyyy"); 
    tfData.setText(formato.format(sistemaData));
    tfDataMensal.setText(formato1.format(sistemaData));
    tfDataAnual.setText(formato2.format(sistemaData)); 
    //HORA DO SISTEMA
    Timer hr = new Timer(100, new hora()); 
    hr.start(); 
    }//GEN-LAST:event_formWindowOpened

    private void tabelaCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCartaoMouseClicked
    setarCamposCartao();
    btCartao.setEnabled(true);
    btCancelarCartao.setEnabled(true);
    btCancelarTickets.setEnabled(false);
    btTickets.setEnabled(false);
    btDinheiro.setEnabled(false);
    btCancelarDinheiro.setEnabled(false); 
    }//GEN-LAST:event_tabelaCartaoMouseClicked

    private void tabelaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTicketsMouseClicked
    setarCamposTickets();
    btCartao.setEnabled(false);
    btCancelarCartao.setEnabled(false);
    btCancelarTickets.setEnabled(true);
    btTickets.setEnabled(true);
    btDinheiro.setEnabled(false);
    btCancelarDinheiro.setEnabled(false); 
    }//GEN-LAST:event_tabelaTicketsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
    int cont = tabelaFazendoVenda.getRowCount();
    if(cont<1){
    JOptionPane.showMessageDialog(null, "Não tem produto para excluir!");
    }else{
    DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();
    int linha = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para remover?"));
    modelo.removeRow(linha-1);
    somaValortotal();
    
    for (int i = 0; i < cont; i++) {
    modelo.setValueAt(i+1, i, 0);
    }
    } 
    } catch (Exception e) { 
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
    somaValortotal();
    tfDesconto.setText(String.valueOf(formatador.converterPontos(tfDesconto.getText())));  
    }//GEN-LAST:event_tfDescontoFocusLost

    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendaActionPerformed
    listaModelVendaProduto = new ArrayList<>(); 
    modelVenda.setIdVenda(Integer.parseInt(tfNumeroVenda.getText()));
    modelVenda.setCliente(Integer.parseInt(tfCodCliente.getText()));
    modelVenda.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
    modelVenda.setData(tfData.getText());
    modelVenda.setHora(tfHora.getText());
    modelVenda.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
    modelVenda.setValorDesconto(Double.parseDouble(tfDesconto.getText()));
    modelVenda.setValorLiquido(Double.parseDouble(tfValorTotal.getText()));
    modelVenda.setPagamento(tfPagamento.getText());
    controllervenda.atualizarvendaController(modelVenda);
    
    int cod = Integer.parseInt(tfNumeroVenda.getText());
    listaModelProduto = new ArrayList<>();
    listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProduto(cod);
    for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
    modelProduto = new ModelProduto(); 
    modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
    modelProduto.setEstoque(
    listaProdutoVendaProduto.get(i).getModelProduto().getEstoque() 
                +
    listaProdutoVendaProduto.get(i).getModelVendaProduto().getQuantidade()      
    );
    listaModelProduto.add(modelProduto);       
    } 
    if(controllerProduto.alterarEstoqueController(listaModelProduto)){
    if(controllerVendaProduto.excluirVendaProdutoControllerCodVenda(cod)){   
    JOptionPane.showMessageDialog(null, "Venda alterada com sucesso!");
    imprimirCupomDinheiro(listaModelVendaProduto, modelVenda);
    listandoVendas();
    dispose();
    }else{ 
    JOptionPane.showMessageDialog(null, "erro");
    } 
    }else{ 
    JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
    }
   
    
    
    int cont = tabelaFazendoVenda.getRowCount();
        for (int i = 0; i < cont; i++) {
    int codigoProduto = (int) tabelaFazendoVenda.getValueAt(i, 1);
    modelVendaProduto = new ModelVendaProduto();
    modelProduto = new ModelProduto();
    
    modelVendaProduto.setMesAno(tfData.getText());
    modelVendaProduto.setAno(tfDataAnual.getText()); 
    modelVendaProduto.setProduto(codigoProduto); 
    modelVendaProduto.setVenda(cod);
    modelVendaProduto.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
    modelVendaProduto.setValorVenda(Double.parseDouble(String.valueOf(tabelaFazendoVenda.getValueAt(i, 5))));
    modelVendaProduto.setQuantidade(Integer.parseInt(String.valueOf( tabelaFazendoVenda.getValueAt(i, 3))));
    modelVendaProduto.setNome_produto(String.valueOf( tabelaFazendoVenda.getValueAt(i, 2)));   
    //baixa no estoque 
    modelProduto.setId(codigoProduto);
    modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
    -Integer.parseInt(String.valueOf(tabelaFazendoVenda.getValueAt(i, 3))));          
    listaModelVendaProduto.add(modelVendaProduto);
    listaModelProduto.add(modelProduto);  
      
    }  
    if(controllerVendaProduto.salvarVendaProdutoController(listaModelVendaProduto)){
       
    limparFormulario();
    }else{ 
        JOptionPane.showMessageDialog(null, "Erro ao salvar Venda");
    }
    }                                    

    private void salvarVendaActionPerformed(java.awt.event.ActionEvent evt) {                                            
    
    
    }//GEN-LAST:event_btnSalvarVendaActionPerformed

    private void btRefazerCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefazerCartaoActionPerformed
        listaModelVendaProduto = new ArrayList<>();

        modelVendaCartao.setIdVenda(Integer.parseInt(tfNumeroVenda.getText()));
        modelVendaCartao.setCliente(Integer.parseInt(tfCodCliente.getText()));
        modelVendaCartao.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
        modelVendaCartao.setData(tfData.getText());
        modelVendaCartao.setHora(tfHora.getText());
        modelVendaCartao.setValorLiquido(Double.parseDouble(tfValorTotal.getText()));
        modelVendaCartao.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
        modelVendaCartao.setValorDesconto(Double.parseDouble(tfDesconto.getText()));
        modelVendaCartao.setData_relatorio(tfDataMensal.getText());
        modelVendaCartao.setDataAnual(tfDataAnual.getText());

        controllervendaCartao.atualizarvendaController(modelVendaCartao);
        if(alteraOuSalva.equals("salvar")){
            int codigovenda = controllervendaCartao.salvarvendaController(modelVendaCartao);
            if(codigovenda>0){

            }else{
                JOptionPane.showMessageDialog(null, "Erro ao salvar Venda");
            }
            int cont = tabelaFazendoVenda.getRowCount();
            for (int i = 0; i < cont; i++) {
                int codigoProduto = (int) tabelaFazendoVenda.getValueAt(i, 0);
                modelVendaProdutoCartao = new ModelVendaProdutoCartao();
                modelProduto = new ModelProduto();
                modelVendaProdutoCartao.setProduto(codigoProduto);
                modelVendaProdutoCartao.setVenda(codigovenda);
                modelVendaProdutoCartao.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
                modelVendaProdutoCartao.setValorVenda(Double.parseDouble(String.valueOf(tabelaFazendoVenda.getValueAt(i, 4))));
                modelVendaProdutoCartao.setQuantidade(Integer.parseInt(String.valueOf( tabelaFazendoVenda.getValueAt(i, 3))));

                modelVendaProdutoCartao.setNome_produto(String.valueOf( tabelaFazendoVenda.getValueAt(i, 2)));
                modelVendaProdutoCartao.setMes(tfDataMensal.getText());
                modelVendaProdutoCartao.setAno(tfDataAnual.getText());
                //baixa no estoque
                modelProduto.setId(codigoProduto);
                modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
                    -Integer.parseInt(String.valueOf(tabelaFazendoVenda.getValueAt(i, 3))));
                listaModelVendaProdutoCartao.add(modelVendaProdutoCartao);
                listaModelProduto.add(modelProduto);
            }
            if(controllerVendaProdutoCartao.salvarVendaProdutoController(listaModelVendaProdutoCartao)){
                controllerProduto.alterarEstoqueController(listaModelProduto);
                imprimirCupomCartao(listaModelVendaProdutoCartao, modelVendaCartao);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao salvar os Produtos da venda");
            }
        }else{
            /*
            ALERANDO VENDA
            */
            int cod = Integer.parseInt(tfNumeroVenda.getText());
            modelVendaCartao = new ModelVendaCartao();
            controllervendaCartao = new ControllervendaCartao();
            listaModelProduto = new ArrayList<>();
            listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProdutoCartao(cod);
            for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
            modelProduto = new ModelProduto();
            modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
            modelProduto.setEstoque(
            listaProdutoVendaProduto.get(i).getModelProduto().getEstoque()
            +
            listaProdutoVendaProduto.get(i).getModelVendaProdutoCartao().getQuantidade()
            );
            listaModelProduto.add(modelProduto);
            }
            if(controllerProduto.alterarEstoqueController(listaModelProduto)){
            if(controllerVendaProdutoCartao.excluirVendaProdutoControllerCodVenda(cod)){
            listandoVendas();
            }else{
            JOptionPane.showMessageDialog(null, "erro");
            }
            }else{
            JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
            }
            if(controllervendaCartao.atualizarvendaController(modelVendaCartao)){
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
            dispose();
            }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Venda");
            }
            int cont = tabelaFazendoVenda.getRowCount();
            for (int i = 0; i < cont; i++) {
            int codigoProduto = (int) tabelaFazendoVenda.getValueAt(i, 1);
            modelVendaProdutoCartao = new ModelVendaProdutoCartao();
            modelProduto = new ModelProduto();
            modelVendaProdutoCartao.setProduto(codigoProduto);
            modelVendaProdutoCartao.setVenda(cod);
            modelVendaProdutoCartao.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
            modelVendaProdutoCartao.setValorVenda(Double.parseDouble(String.valueOf(tabelaFazendoVenda.getValueAt(i, 4))));
            modelVendaProdutoCartao.setQuantidade(Integer.parseInt(String.valueOf( tabelaFazendoVenda.getValueAt(i, 3))));
            modelVendaProdutoCartao.setNome_produto(String.valueOf( tabelaFazendoVenda.getValueAt(i, 2)));
            modelVendaProdutoCartao.setMes(tfDataMensal.getText());
            modelVendaProdutoCartao.setAno(tfDataAnual.getText());

            //baixa no estoque
            modelProduto.setId(codigoProduto);
            modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
            -Integer.parseInt(String.valueOf(tabelaFazendoVenda.getValueAt(i, 3))));
            listaModelVendaProdutoCartao.add(modelVendaProdutoCartao);
            listaModelProduto.add(modelProduto);
            }
            if(controllerVendaProdutoCartao.salvarVendaProdutoController(listaModelVendaProdutoCartao)){
            limparFormulario();
            }else{
            JOptionPane.showMessageDialog(null, "Erro ao salvar Venda");
            }
        }
    }//GEN-LAST:event_btRefazerCartaoActionPerformed

    private void btnRefazerTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefazerTicketsActionPerformed
        listaModelVendaProduto = new ArrayList<>();
        modelVendaTickets.setIdVenda(Integer.parseInt(tfNumeroVenda.getText()));
        modelVendaTickets.setCliente(Integer.parseInt(tfCodCliente.getText()));
        modelVendaTickets.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
        modelVendaTickets.setData(tfData.getText());
        modelVendaTickets.setHora(tfHora.getText());
        modelVendaTickets.setValorLiquido(Double.parseDouble(tfValorTotal.getText()));
        modelVendaTickets.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
        modelVendaTickets.setValorDesconto(Double.parseDouble(tfDesconto.getText()));
        modelVendaTickets.setData_relatorio(tfDataMensal.getText());
        modelVendaTickets.setDataAnual(tfDataAnual.getText());
        controllerVendaTickets.atualizarvendaController(modelVendaTickets);

        if(alteraOuSalva.equals("salvar")){
            int codigovenda = controllerVendaTickets.salvarvendaController(modelVendaTickets);
            if(codigovenda>0){
                JOptionPane.showMessageDialog(null, "Venda alterada com sucesso!");

            }else{
                JOptionPane.showMessageDialog(null, "Erro ao salvar Venda");
            }
            int cont = tabelaFazendoVenda.getRowCount();
            for (int i = 0; i < cont; i++) {
                int codigoProduto = (int) tabelaFazendoVenda.getValueAt(i, 1);
                modelVendaProdutoTickets = new ModelVendaProdutoTickets();
                modelProduto = new ModelProduto();
                modelVendaProdutoTickets.setProduto(codigoProduto);
                modelVendaProdutoTickets.setVenda(codigovenda);
                modelVendaProdutoTickets.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
                modelVendaProdutoTickets.setValorVenda(Double.parseDouble(String.valueOf(tabelaFazendoVenda.getValueAt(i, 4))));
                modelVendaProdutoTickets.setQuantidade(Integer.parseInt(String.valueOf( tabelaFazendoVenda.getValueAt(i, 3))));
                modelVendaProdutoTickets.setNome_produto(String.valueOf(tabelaFazendoVenda.getValueAt(i, 2)));
                modelVendaProdutoTickets.setMesAno(tfDataMensal.getText());
                modelVendaProdutoTickets.setAno(tfDataAnual.getText());
                //baixa no estoque
                modelProduto.setId(codigoProduto);    
                modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
                    -Integer.parseInt(String.valueOf(tabelaFazendoVenda.getValueAt(i, 3))));
                listaModelProdutosTickets.add(modelVendaProdutoTickets);
                listaModelProduto.add(modelProduto);
            }
            if(controllerVendaProdutoTickets.salvarVendaProdutoController(listaModelProdutosTickets)){
                controllerProduto.alterarEstoqueController(listaModelProduto);
                imprimirCupomTickets(listaModelProdutosTickets, modelVendaTickets);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao salvar os Produtos da venda");
            }
        }else{
            /*
            ALERANDO VENDA
            */
            int cod = Integer.parseInt(tfNumeroVenda.getText());
            listaModelProduto = new ArrayList<>();
            listaProdutoVendaProduto =  controllerProdutoVendaProduto.listaProdutoVendaProdutoTickts(cod);
            for (int i = 0; i < listaProdutoVendaProduto.size(); i++) {
            modelProduto = new ModelProduto();
            modelProduto.setId(listaProdutoVendaProduto.get(i).getModelProduto().getId());
            modelProduto.setEstoque(
            listaProdutoVendaProduto.get(i).getModelProduto().getEstoque()
            +
            listaProdutoVendaProduto.get(i).getModelVendaProdutoTickets().getQuantidade()
            );
            listaModelProduto.add(modelProduto);
            }
            if(controllerProduto.alterarEstoqueController(listaModelProduto)){
            if(controllerVendaProdutoTickets.excluirVendaProdutoControllerCodVenda(cod)){
            listandoVendas();
            }else{
            JOptionPane.showMessageDialog(null, "erro");
            }
            }else{
            JOptionPane.showMessageDialog(null, "erro ao alterar o estoque");
            }
            if(controllerVendaTickets.atualizarvendaController(modelVendaTickets)){
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
            dispose();
            }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Venda");
            }
            int cont = tabelaFazendoVenda.getRowCount();
            for (int i = 0; i < cont; i++) {
                int codigoProduto = (int) tabelaFazendoVenda.getValueAt(i, 1);
                modelVendaProdutoTickets = new ModelVendaProdutoTickets();
                modelProduto = new ModelProduto();
                modelVendaProdutoTickets.setProduto(codigoProduto);
                modelVendaProdutoTickets.setVenda(cod);
                modelVendaProdutoTickets.setUsuario(Integer.parseInt(tfIdUsuario.getText()));
                modelVendaProdutoTickets.setValorVenda(Double.parseDouble(String.valueOf(tabelaFazendoVenda.getValueAt(i, 4))));
                modelVendaProdutoTickets.setQuantidade(Integer.parseInt(String.valueOf( tabelaFazendoVenda.getValueAt(i, 3))));
                modelVendaProdutoTickets.setNome_produto(String.valueOf(tabelaFazendoVenda.getValueAt(i, 2)));
                modelVendaProdutoTickets.setMesAno(tfDataMensal.getText());
                modelVendaProdutoTickets.setAno(tfDataAnual.getText());
                //baixa no estoque
                modelProduto.setId(codigoProduto);
                modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
                    -Integer.parseInt(String.valueOf(tabelaFazendoVenda.getValueAt(i, 3))));
                listaModelProdutosTickets.add(modelVendaProdutoTickets);
                listaModelProduto.add(modelProduto);

            }
            if(controllerVendaProdutoTickets.salvarVendaProdutoController(listaModelProdutosTickets)){

                limparFormulario();
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao salvar Venda");
            }
        }
    }//GEN-LAST:event_btnRefazerTicketsActionPerformed
    /*
    private void trazerProdutoEstoque(java.awt.event.KeyEvent e){       
        
    try {             
    DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();        
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){      
    modelProduto = new ModelProduto();            
    modelProduto = controllerProduto.retornarCodigoBarrasController(tfBarras.getText());
    modelo.addRow(new Object[]{ 
    modelo.getRowCount()+1, 
    modelProduto.getId(),   
    modelProduto.getNome(), 
    quantidade, 
    formatador.converterPontos(df.format(modelProduto.getPreco_venda() )),
    formatador.converterPontos(df.format(modelProduto.getPreco_venda() * quantidade))
    });               
    tfBarras.setText("");
    tfQuantidade.setText("");
    tfNomeProduto.setText(" "+quantidade+"x  "+modelProduto.getNome()+" = "+formatador.converterPontos(df.format(modelProduto.getPreco_venda() * quantidade))+"");      
    somaValortotal();
    quantidade = 1;
    }        
    } catch (Exception e3) {
    try {
    if(modelProduto.getId() != Integer.parseInt(tfBarras.getText())){
    JOptionPane.showMessageDialog(null, "Produto não cadastrado na base de dados!");    
    }else   
    {      
    }    
    } catch (Exception e5) {
    }     
    }      
    }
    
    */
    private void setarCampos(){    
     
    modelVenda = new ModelVenda();
    
    try {
    int linha = tabelaDinheiro.getSelectedRow();
    int cod = (int) tabelaDinheiro.getValueAt(linha, 0);
    modelVenda = controllervenda.getvendaController(cod);
    tfId.setText(String.valueOf(modelVenda.getIdVenda()));
    tfCliente.setText(modelVenda.getCliente()+"");
    tfHoraSalvar.setText(modelVenda.getHora());
    tfDataSalvar.setText(modelVenda.getData()+"");
    tfValorBrutoSalvar.setText(modelVenda.getValorBruto()+"");
    tfValorDescSalvar.setText(modelVenda.getValorDesconto()+""); 
    tfValorLiqSalvar.setText(modelVenda.getValorLiquido()+"");
    tfPagamentoSalvar.setText(modelVenda.getPagamento());
    tfUsuarioSalvar.setText(modelVenda.getUsuario()+"");
    Tfpag.setText(modelVenda.getPagamento());
    } catch (Exception e) { 
    JOptionPane.showMessageDialog(null, "Selecione um produto da tabela!!!");
    }
    }
    private void limparFormulario(){  
    tfCodCliente.setText("");
    tfDesconto.setText("0");
    tfNumeroVenda.setText("");
   // tfQuantidade.setText("");
    tfValorTotal.setText("");
    tfNomeProduto.setText("- Alterando venda");
    DefaultTableModel modelo = (DefaultTableModel) tabelaFazendoVenda.getModel();
    modelo.setNumRows(0);
    }
    private void setarCamposCartao(){    
    modelVendaCartao = new ModelVendaCartao();
    
    try {
    int linha = tabelaCartao.getSelectedRow();
    int cod = (int) tabelaCartao.getValueAt(linha, 0);
    modelVendaCartao = controllervendaCartao.getvendaController(cod);
    tfId.setText(String.valueOf(modelVendaCartao.getIdVenda()));
    tfCliente.setText(modelVendaCartao.getCliente()+"");
    tfHoraSalvar.setText(modelVendaCartao.getHora());
    tfDataSalvar.setText(modelVendaCartao.getData()+"");
    tfValorBrutoSalvar.setText(modelVendaCartao.getValorBruto()+"");
    tfValorDescSalvar.setText(modelVendaCartao.getValorDesconto()+""); 
    tfValorLiqSalvar.setText(modelVendaCartao.getValorLiquido()+"");
    tfUsuarioSalvar.setText(modelVendaCartao.getUsuario()+"");
    } catch (Exception e) { 
    JOptionPane.showMessageDialog(null, "Selecione um produto da tabela!!!");
    }
    }
    
      private void setarCamposTickets(){    
    ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
    ControllervendaTickets controllerVendaTickets = new ControllervendaTickets();
    modelVendaTickets = new ModelVendaTickets();
    
    try {
    int linha = tabelaTickets.getSelectedRow();
    int cod = (int) tabelaTickets.getValueAt(linha, 0);
    modelVendaTickets = controllerVendaTickets.getvendaController(cod);
    tfId.setText(String.valueOf(modelVendaTickets.getIdVenda()));
    tfCliente.setText(modelVendaTickets.getCliente()+"");
    tfHoraSalvar.setText(modelVendaTickets.getHora());
    tfDataSalvar.setText(modelVendaTickets.getData()+"");
    tfValorBrutoSalvar.setText(modelVendaTickets.getValorBruto()+"");
    tfValorDescSalvar.setText(modelVendaTickets.getValorDesconto()+""); 
    tfValorLiqSalvar.setText(modelVendaTickets.getValorLiquido()+"");
    tfUsuarioSalvar.setText(modelVendaTickets.getUsuario()+"");
    } catch (Exception e) { 
    JOptionPane.showMessageDialog(null, "Selecione um produto da tabela!!!");
    }
    } 
    
    private void buscaCliente(){    
    ModelCliente modelCliten = new ModelCliente();
    ControllerCliente controllerCliente = new ControllerCliente();
    modelCliten = new ModelCliente();   
    try {
    int cod = Integer.parseInt(tfCodCliente.getText());
    modelCliten = controllerCliente.retornarController(cod);
    tfCliente.setText(String.valueOf(modelCliten.getNome()));
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
            java.util.logging.Logger.getLogger(ViewVenda2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVenda2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVenda2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVenda2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVenda2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tfpag;
    private javax.swing.JButton btCancelarCartao;
    private javax.swing.JButton btCancelarDinheiro;
    private javax.swing.JButton btCancelarTickets;
    private javax.swing.JButton btCartao;
    private javax.swing.JButton btDinheiro;
    private javax.swing.JButton btRefazerCartao;
    private javax.swing.JButton btTickets;
    private javax.swing.JButton btnRefazerTickets;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaCartao;
    private javax.swing.JTable tabelaDinheiro;
    private javax.swing.JTable tabelaFazendoVenda;
    private javax.swing.JTable tabelaTickets;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfCodCliente;
    private javax.swing.JLabel tfCodigo;
    private javax.swing.JLabel tfData;
    private javax.swing.JLabel tfDataAnual;
    private javax.swing.JTextField tfDataDessaVenda;
    private javax.swing.JLabel tfDataMensal;
    private javax.swing.JTextField tfDataSalvar;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JLabel tfHora;
    private javax.swing.JTextField tfHoraDessaVenda;
    private javax.swing.JTextField tfHoraSalvar;
    private javax.swing.JTextField tfId;
    private javax.swing.JLabel tfIdUsuario;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JLabel tfNomeProduto;
    private javax.swing.JTextField tfNumeroVenda;
    private javax.swing.JLabel tfPagamento;
    private javax.swing.JTextField tfPagamentoSalvar;
    private javax.swing.JTextField tfUsuarioSalvar;
    private javax.swing.JTextField tfValorBruto;
    private javax.swing.JTextField tfValorBrutoSalvar;
    private javax.swing.JTextField tfValorDescSalvar;
    private javax.swing.JTextField tfValorLiqSalvar;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables
 class Documento extends PlainDocument{ 
     
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
     try { 
     int tam = (this.getLength() + str.length());
     if(tam <=7){ 
     super.insertString(offs, str.replaceAll("[aA-zZ]", ""), a);     
     }else{
     super.insertString(offs, str.replaceAll("{aA-zZ}", ""), a);
    }
    } catch (Exception e) {          
    } 
    } 
    }
 
        private void imprimirCupomTickets(ArrayList<ModelVendaProdutoTickets> listaModelVendaProduto, ModelVendaTickets modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+ 
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "               JOAO PAULO I               \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "             VENDA MODIFICADA             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+tfPagamento+"\n\r"      
        + "Vendedor: "+tfUsuarioSalvar.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        + "");
        
      }
 
 
 
 
    private void imprimirCupomCartao(ArrayList<ModelVendaProdutoCartao> listaModelVendaProduto, ModelVendaCartao modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "               JOAO PAULO I               \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "             VENDA MODIFICADA             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+tfPagamento+"\n\r"      
        + "Vendedor: "+tfUsuarioSalvar.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        + "");
        
      }
 
 
    private void imprimirCupomDinheiro(ArrayList<ModelVendaProduto> listaModelVendaProduto, ModelVenda modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "               JOAO PAULO I               \n\r"    
        + "         CNPJ: 26.635.415/0001-25         \n\r" 
        + "==========================================\n\r"
        + "             VENDA MODIFICADA             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+tfPagamento+"\n\r"      
        + "Vendedor: "+tfUsuarioSalvar.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        + "");
        
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
 
    }
