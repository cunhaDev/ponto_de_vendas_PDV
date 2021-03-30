package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Model.ModelVendaTickets;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author monet 
*/
public class DaoVendaTickts extends ConexaoMySql {
static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    /** 
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVendaTickets pModelvenda){
        try {
            this.conectar();
            return this.insertSQL( 
                "INSERT INTO tbl_venda_tickets ("
                    + "fk_cliente, "
                    + "fk_usuario, "
                    + "data, "
                    + "hora, "
                    + "valor_liquido, "
                    + "valor_bruto, "
                    + "valor_desconto, "
                    + "data_relatorio, "
                    + "data_anual, "
                    + "pk_id_venda "
                    
                + ") VALUES ("
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getData() + "',"
                    + "'" + pModelvenda.getHora() + "',"                       
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto() + "',"
                    + "'" + pModelvenda.getData_relatorio() + "',"
                    + "'" + pModelvenda.getDataAnual() + "',"
                    + "'" + pModelvenda.getIdVenda() + "'"
                   
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
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVendaTickets getvendaDAO(int pIdVenda){
        ModelVendaTickets modelvenda = new ModelVendaTickets();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                   + "pk_id_venda,"
                    + "fk_cliente,"
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto,"
                    + "data_relatorio,"
                    + "data_anual "
                    + " FROM"
                     + " tbl_venda_tickets"
                    + " WHERE"
                     + " pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setData_relatorio(this.getResultSet().getString(9));
                modelvenda.setDataAnual(this.getResultSet().getString(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelvenda;
    }

    /**
    * recupera uma lista de venda
        * return ArrayList
    */
    public ArrayList<ModelVendaTickets> getListavendaDAO(){
        ArrayList<ModelVendaTickets> listamodelvenda = new ArrayList();
        ModelVendaTickets modelvenda = new ModelVendaTickets();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT " 
                    + "pk_id_venda,"
                    + "fk_cliente," 
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto,"
                    + "data_relatorio, "
                    + "data_anual "
                 + " FROM"
                     + " tbl_venda_tickets"
                + ";"
            ); 
            
           

            while(this.getResultSet().next()){
                modelvenda = new ModelVendaTickets();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setData_relatorio(this.getResultSet().getString(9)); 
                modelvenda.setDataAnual(this.getResultSet().getString(10)); 
                listamodelvenda.add(modelvenda); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvenda;
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */
    public boolean atualizarvendaDAO(ModelVendaTickets pModelvenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_tickets SET "
                    + "pk_id_venda = '" + pModelvenda.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
                    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
                    + "data = '" + pModelvenda.getData() + "',"
                    + "hora = '" + pModelvenda.getHora() + "',"
                    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
                    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
                    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "',"
                    + "data_relatorio = '" + pModelvenda.getData_relatorio() + "',"
                    + "data_anual = '" + pModelvenda.getDataAnual() + "'"
                + " WHERE "
                    + "pk_id_venda = '" + pModelvenda.getIdVenda() + "'"
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
    * exclui venda
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirvendaDAO(int pIdVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda_tickets "
                + " WHERE "
                    + "pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    
    public static int eliminaTodos() {
        
        int rsu = 0; 
        String sql = ModelVendaTickets.ELIMINAR_TUDO;
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