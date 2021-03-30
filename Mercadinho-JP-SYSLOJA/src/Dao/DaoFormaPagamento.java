/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Conexao.ConexaoMySql;
import Model.ModelFormaPagamento;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoFormaPagamento extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelFormaPagamento mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_forma_pagamento ("           
   + "descricao, "
   + "desconto, "
   + "parcela, "
   + "situacao "
   + ") VALUES ("
   + "'" +mod.getDescricao() +"',"
   + "'" +mod.getDesconto() +"',"
   + "'" +mod.getParcela() +"',"
   + "'" +mod.getSituacao()+"'" 
   
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
    public boolean excluirDao(int id){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_forma_pagamento WHERE pk_id_forma_pag = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelFormaPagamento mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_forma_pagamento SET "
   + "descricao = '"+mod.getDescricao()+"',"
   + "desconto = '"+mod.getDesconto()+"',"
   + "parcela = '"+mod.getParcela()+"',"
   + "situacao = '"+mod.getSituacao()+"'" 
   + "WHERE pk_id_forma_pag = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelFormaPagamento retornarDao (int id){
   ModelFormaPagamento mod = new ModelFormaPagamento();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_forma_pag, "
   + "descricao, "
   + "desconto, "
   + "parcela, "
   + "situacao "
   + "FROM tbl_bairro WHERE pk_id_forma_pag = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setDescricao(getResultSet().getString(2));
   mod.setDesconto(getResultSet().getFloat(3));
   mod.setParcela(getResultSet().getInt(4));
   mod.setSituacao(getResultSet().getInt(5));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
 
   
   //RETORNAR LISTA
   
   public ArrayList<ModelFormaPagamento>retornarLista(){
   ArrayList<ModelFormaPagamento> lista = new ArrayList<>();
   ModelFormaPagamento mod = new ModelFormaPagamento();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_forma_pag, "
   + "descricao, "
   + "desconto, "
   + "parcela, "
   + "situacao "
   + "FROM tbl_forma_pagamento;"
   + "");
   while(getResultSet().next()){
   mod = new ModelFormaPagamento();
 mod.setId(getResultSet().getInt(1));
   mod.setDescricao(getResultSet().getString(2));
   mod.setDesconto(getResultSet().getFloat(3));
   mod.setParcela(getResultSet().getInt(4));
   mod.setSituacao(getResultSet().getInt(5));
   lista.add(mod);
   
   } 
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return lista;
   }
    //RETORNAR LISTA FORMA PAGAMENTO PARCELAMENTO
   
   public ArrayList<ModelFormaPagamento>retornarListaFormParcelamento(){
   ArrayList<ModelFormaPagamento> lista = new ArrayList<>();
   ModelFormaPagamento mod = new ModelFormaPagamento();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_forma_pag, "
   + "descricao, "
   + "desconto, "
   + "parcela, " 
   + "situacao "
   + "FROM tbl_forma_pagamento_parc;"
   + "");
   while(getResultSet().next()){
   mod = new ModelFormaPagamento();
   mod.setId(getResultSet().getInt(1));
   mod.setDescricao(getResultSet().getString(2));
   mod.setDesconto(getResultSet().getFloat(3));
   mod.setParcela(getResultSet().getInt(4));
   mod.setSituacao(getResultSet().getInt(5));
   lista.add(mod);
   
   } 
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return lista;
   }
   }
