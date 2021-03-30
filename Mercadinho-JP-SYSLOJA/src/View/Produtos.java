/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author hugov
 */
public class Produtos {
    
    public static String LISTAR = "SELECT * FROM produtos ORDER BY nome_pro";
    
    public static String REGISTRAR = "INSERT INTO tbl_usuario(nome, tipo, senha) "
            + "VALUES(?,?,?)";
    
    public static String ATUALIZAR = "UPDATE produtos SET "
                + "tipo_pro=?, "
                + "nome_pro=?, "
                + "valor_pro=? WHERE codigo_pro=?";
    
    public static String ELIMINAR = "DELETE FROM produtos WHERE codigo_pro = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM produtos";
    
    
    private String tipo;
    private String nome;
    private String valor;

    public Produtos(){
        
    }

 

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
