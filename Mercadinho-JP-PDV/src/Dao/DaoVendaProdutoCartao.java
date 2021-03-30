package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import java.util.ArrayList;
import Model.ModelVendaProdutoCartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
* 
* @author monet
*/
public class DaoVendaProdutoCartao extends ConexaoMySql {
static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    /**
    * grava vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return int 
    */
    public int salvarVendaProdutoDAO(ModelVendaProdutoCartao pModelvendaDinheiroPro){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_cartao_produto ("
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                    + "nome_produto,"
                    + "mes,"
                    + "ano"
                + ") VALUES ("
                    + "'" + pModelvendaDinheiroPro.getProduto() + "',"
                    + "'" + pModelvendaDinheiroPro.getVenda() + "',"
                    + "'" + pModelvendaDinheiroPro.getUsuario() + "',"
                    + "'" + pModelvendaDinheiroPro.getValorVenda() + "',"
                    + "'" + pModelvendaDinheiroPro.getQuantidade() + "',"
                    + "'" + pModelvendaDinheiroPro.getNome_produto() + "',"
                    + "'" + pModelvendaDinheiroPro.getMes() + "',"
                    + "'" + pModelvendaDinheiroPro.getAno() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return ModelvendaDinheiroPro
    */
    public ModelVendaProdutoCartao getVendaProdutoDAO(int pIdVendaDinheiroPro){
        ModelVendaProdutoCartao modelvendaDinheiroPro = new ModelVendaProdutoCartao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendaProduto,"
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                    + "nome_produto,"
                    + "mes,"
                    + "ano"
                 + " FROM"
                     + " tbl_venda_cartao_produto"
                 + " WHERE"
                     + " pk_id_vendaProduto = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvendaDinheiroPro.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
                modelvendaDinheiroPro.setProduto(this.getResultSet().getInt(2));
                modelvendaDinheiroPro.setVenda(this.getResultSet().getInt(3));
                modelvendaDinheiroPro.setUsuario(this.getResultSet().getInt(4));
                modelvendaDinheiroPro.setValorVenda(this.getResultSet().getDouble(5));
                modelvendaDinheiroPro.setQuantidade(this.getResultSet().getInt(6));
                modelvendaDinheiroPro.setNome_produto(this.getResultSet().getString(7));
                modelvendaDinheiroPro.setMes(this.getResultSet().getString(8)); 
                modelvendaDinheiroPro.setAno(this.getResultSet().getString(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelvendaDinheiroPro;
    }

    /** 
    * recupera uma lista de vendaDinheiroPro
        * return ArrayList
    */
    public ArrayList<ModelVendaProdutoCartao> getListaVendaProdutoDAO(){
        ArrayList<ModelVendaProdutoCartao> listamodelvendaDinheiroPro = new ArrayList();
        ModelVendaProdutoCartao modelvendaDinheiroPro = new ModelVendaProdutoCartao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                  + "pk_id_vendaProduto,"
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                    + "nome_produto,"
                    + "mes,"
                    + "ano"
                 + " FROM"
                     + " tbl_venda_cartao_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvendaDinheiroPro = new ModelVendaProdutoCartao();
                modelvendaDinheiroPro.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
                modelvendaDinheiroPro.setProduto(this.getResultSet().getInt(2));
                modelvendaDinheiroPro.setVenda(this.getResultSet().getInt(3));
                modelvendaDinheiroPro.setUsuario(this.getResultSet().getInt(4));
                modelvendaDinheiroPro.setValorVenda(this.getResultSet().getDouble(5));
                modelvendaDinheiroPro.setQuantidade(this.getResultSet().getInt(6));
                modelvendaDinheiroPro.setNome_produto(this.getResultSet().getString(7));
                modelvendaDinheiroPro.setMes(this.getResultSet().getString(8));
                modelvendaDinheiroPro.setAno(this.getResultSet().getString(9));
                listamodelvendaDinheiroPro.add(modelvendaDinheiroPro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvendaDinheiroPro;
    }

    
    public ArrayList<ModelVendaProdutoCartao> getListaVendaProdutoDAOpeloCodigo(int id){
        ArrayList<ModelVendaProdutoCartao> listamodelvendaDinheiroPro = new ArrayList();
        ModelVendaProdutoCartao modelvendaDinheiroPro = new ModelVendaProdutoCartao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                  + "pk_id_vendaProduto,"
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                    + "nome_produto,"
                    + "mes,"
                    + "ano"
                 + " FROM"
                     + " tbl_venda_cartao_produto WHERE fk_venda = '"+id+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvendaDinheiroPro = new ModelVendaProdutoCartao();
                modelvendaDinheiroPro.setIdVendaDinheiroPro(this.getResultSet().getInt(1));
                modelvendaDinheiroPro.setProduto(this.getResultSet().getInt(2));
                modelvendaDinheiroPro.setVenda(this.getResultSet().getInt(3));
                modelvendaDinheiroPro.setUsuario(this.getResultSet().getInt(4));
                modelvendaDinheiroPro.setValorVenda(this.getResultSet().getDouble(5));
                modelvendaDinheiroPro.setQuantidade(this.getResultSet().getInt(6));
                modelvendaDinheiroPro.setNome_produto(this.getResultSet().getString(7));
                modelvendaDinheiroPro.setMes(this.getResultSet().getString(8));
                modelvendaDinheiroPro.setAno(this.getResultSet().getString(9));
                listamodelvendaDinheiroPro.add(modelvendaDinheiroPro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvendaDinheiroPro;
    }
    /**
    * atualiza vendaDinheiroPro
    * @param pModelvendaDinheiroPro
    * return boolean
    */
    public boolean atualizarVendaProdutoDAO(ModelVendaProdutoCartao pModelvendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_cartao_produto SET "
                    + "pk_id_vendaProduto = '" + pModelvendaDinheiroPro.getIdVendaDinheiroPro() + "',"
                    + "fk_produto = '" + pModelvendaDinheiroPro.getProduto() + "',"
                    + "fk_venda = '" + pModelvendaDinheiroPro.getVenda() + "',"
                    + "fk_usuario = '" + pModelvendaDinheiroPro.getUsuario() + "',"
                    + "valor_venda = '" + pModelvendaDinheiroPro.getValorVenda() + "',"
                    + "quantidade = '" + pModelvendaDinheiroPro.getQuantidade() + "',"
                    + "nome_produto = '" + pModelvendaDinheiroPro.getNome_produto() + "',"
                            
                    + "mes = '" + pModelvendaDinheiroPro.getMes() + "',"
                    + "ano = '" + pModelvendaDinheiroPro.getAno() + "'"
                + " WHERE "
                    + "pk_id_vendaProduto = '" + pModelvendaDinheiroPro.getIdVendaDinheiroPro() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui vendaDinheiroPro
    * @param pIdVendaDinheiroPro
    * return boolean
    */
    public boolean excluirVendaProdutoDAO(int pIdVendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_cartao_produto "
                + " WHERE "
                    + "pk_id_vendaProduto = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

     public boolean excluirVendaProdutoDAOCodVenda(int pIdVendaDinheiroPro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_cartao_produto "
                + " WHERE "
                    + "fk_venda = '" + pIdVendaDinheiroPro + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    
    
    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVendaProdutoCartao> pListaModelVendaProduto) {
    try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO tbl_venda_cartao_produto ("
                    + "fk_produto,"
                    + "fk_venda,"
                    + "fk_usuario,"
                    + "valor_venda,"
                    + "quantidade,"
                    + "nome_produto,"
                    + "mes,"
                    + "ano"
                + ") VALUES ("
                    + "'" + pListaModelVendaProduto.get(i).getProduto()+ "',"
                    + "'" + pListaModelVendaProduto.get(i).getVenda() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getUsuario() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorVenda() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getQuantidade() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getNome_produto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getMes() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getAno() + "'"
                + ");"
            ); 
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }    
    
    }
     public static int eliminaTodos() {
        
        int rsu = 0;
        String sql = ModelVendaProdutoCartao.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql); 
        return rsu;
    }
}