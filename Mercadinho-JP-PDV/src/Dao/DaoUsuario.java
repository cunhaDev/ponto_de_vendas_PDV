/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Conexao.Conectar;
import Model.ModelUsuario;
import Conexao.ConexaoMySql;
import View.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Monet
 */


  

 public class DaoUsuario extends ConexaoMySql{
     static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
     public static int registrar(Produtos uc) {
        int rsu = 0;
        String sql = Produtos.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
        
            ps.setString(1, uc.getNome());
            ps.setString(2, uc.getTipo());
            ps.setString(3, uc.getValor());
           
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
     
     
     
    //SALVAR
    public int SalvarUsuarioDao(ModelUsuario modelUsuario){
    try {
    this.conectar();
    return this.insertSQL("INSERT INTO tbl_usuario ("           
    + "nome,"
    + "tipo,"
    + "senha,"          
    + "tipo_conta,"
    + "cadastro_cidade,"          
    + "cadastro_usuario,"           
    + "cadastro_estiva,"
    + "cadastro_cliente,"          
    + "cadastro_estoque,"         
    + "cadastro_fornecedor,"          
    + "cadastro_departamento,"
    + "cadastro_bairro,"           
    + "cadastro_rua,"
    + "pagar_conta,"
    + "retira_estoque,"          
    + "relatorio_entrada_estoque,"
    + "relatorio_saida_estoque,"
    + "despesa,"         
    + "relatorio_parcelamento,"
    + "relatorio_estoque,"
    + "relatorio_venda,"         
    + "relatorio_turno,"
    + "relatorio_produto_maisVendidos,"
    + "relatorio_conta_pagaga,"       
    + "cancelar_venda,"
    + "parcela_venda,"
    + "dar_desconto,"
            
    + "fazer_sangria,"
    + "abandonar_venda"
            
    + ") VALUES ("
    + "'" +modelUsuario.getNome() +"',"
    + "'" +modelUsuario.getTipo() +"',"
    + "'" +modelUsuario.getSenha() +"',"
       
    + "'" +modelUsuario.getTipo_conta() +"',"
    + "'" +modelUsuario.getCadastro_cidade() +"',"
    + "'" +modelUsuario.getCadastro_usuario() +"',"
    
    + "'" +modelUsuario.getCadastro_estivas() +"',"
    + "'" +modelUsuario.getCadastro_cliente() +"',"
    + "'" +modelUsuario.getCadastro_estoque() +"',"       
        
    + "'" +modelUsuario.getCadastro_fornecedor() +"',"
    + "'" +modelUsuario.getCadastro_departamento() +"',"
    + "'" +modelUsuario.getCadastro_bairro() +"',"  
     
    + "'" +modelUsuario.getCadastro_rua() +"',"
    + "'" +modelUsuario.getPagar_conta() +"',"
    + "'" +modelUsuario.getRetira_estoque() +"',"          
      
    + "'" +modelUsuario.getRelatorio_entrada_estoque() +"',"
    + "'" +modelUsuario.getRelatorio_saida_estoque() +"',"
    + "'" +modelUsuario.getDespesa() +"'," 
            
    + "'" +modelUsuario.getRelatorio_parcelamento() +"',"
    + "'" +modelUsuario.getRelatorio_estoque() +"',"
    + "'" +modelUsuario.getRelatorio_venda() +"'," 
            
    + "'" +modelUsuario.getRelatorio_turno() +"',"
    + "'" +modelUsuario.getRelatorio_produto_maisVendido() +"',"
    + "'" +modelUsuario.getRelatorio_conta_pagaga() +"'," 
            
    + "'" +modelUsuario.getCancelar_venda() +"',"
    + "'" +modelUsuario.getParcela_venda() +"',"
    + "'" +modelUsuario.getDar_desconto() +"'," 
     
    + "'" +modelUsuario.getFazer_sangria() +"',"
    + "'" +modelUsuario.getAbandonar_venda() +"'" 
    + ");"
    );
    } catch (Exception e) {
    e.printStackTrace();
    return 0;
    }finally{
    this.fecharConexao();
    }
    }
    
    //EXCLUIR
    
    public boolean excluirUsuarioDao(int idUsuario){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_usuario WHERE pk_id_usuario = '"+idUsuario+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    //ALTERAR
    
   public boolean alterarUsuarioDao (ModelUsuario modelUsuario){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_usuario SET "
   + "nome = '"+modelUsuario.getNome()+"',"
   + "senha = '"+modelUsuario.getSenha()+"',"
   + "tipo = '"+modelUsuario.getTipo()+"'"
   + "WHERE pk_id_usuario = '"+modelUsuario.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
   
   public ModelUsuario retornarUsuarioDao (int idUsuario){
   ModelUsuario modelUsuario = new ModelUsuario();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_usuario, "
   + "nome, "
   + "tipo, "
   + "senha "
   + "FROM tbl_usuario WHERE pk_id_usuario = '"+idUsuario+"'");
   while(this.getResultSet().next()){
   modelUsuario.setId(getResultSet().getInt(1));
   modelUsuario.setNome(getResultSet().getString(2));
   modelUsuario.setTipo(getResultSet().getString(3));
   modelUsuario.setSenha(getResultSet().getString(4));

   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return modelUsuario; 
   }
   
   //RETORNAR LISTA
   
   public ArrayList<ModelUsuario>retornarListaDeUsuario(){
   ArrayList<ModelUsuario> listaUsuario = new ArrayList<>();
   ModelUsuario modelUsuario = new ModelUsuario();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_usuario, "
   + "nome, "
   + "tipo, "
   + "senha "
   + "FROM tbl_usuario ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   modelUsuario = new ModelUsuario();
   modelUsuario.setId(this.getResultSet().getInt(1));
   modelUsuario.setNome(this.getResultSet().getString(2));
   modelUsuario.setTipo(this.getResultSet().getString(3));
   modelUsuario.setSenha(this.getResultSet().getString(4));
   listaUsuario.add(modelUsuario);
   
   }

   
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return listaUsuario;
   }
   
   public static String LISTAR = "SELECT * FROM tbl_usuario ORDER BY nome";
   
   
   
   
     //RETORNAR POR NOME
 
   
   public ModelUsuario retornarDao (String nome){
   ModelUsuario mod = new ModelUsuario();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_usuario, "
   + "nome, "
   + "tipo "
   
  
   + "FROM tbl_usuario WHERE nome = '"+nome+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setTipo(getResultSet().getString(3));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }

    public boolean retornarListaDeUsuario(ModelUsuario mod) {
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_usuario, "
   + "nome, "
   + "tipo "
   
  
   + "FROM tbl_usuario WHERE nome = '"+mod.getNome()+"' AND senha = '"+mod.getSenha()+"'");
  
   if(getResultSet().next()){
   return true;
   }else{
     return false;   
   }
   
    } catch (Exception e) {
   e.printStackTrace();
    return false;
   }finally{
   this.fecharConexao();
   }  
       
    }
    
   }
