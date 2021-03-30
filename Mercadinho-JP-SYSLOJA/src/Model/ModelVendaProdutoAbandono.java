package Model;
/**
*
* @author monet
*/ 
public class ModelVendaProdutoAbandono {

    /**
     * @return the Nome_produto
     */
    public String getNome_produto() {
        return Nome_produto;
    }

    /**
     * @param Nome_produto the Nome_produto to set
     */
    public void setNome_produto(String Nome_produto) {
        this.Nome_produto = Nome_produto;
    } 

    private int idVendaDinheiroPro;
    private int produto;
    private int venda;
    private Double valorVenda;
    private int quantidade;
  private int usuario;
  private String Nome_produto;
    /**
    * Construtor
    */
    public ModelVendaProdutoAbandono(){}

    /**
    * seta o valor de idVendaDinheiroPro
    * @param pIdVendaDinheiroPro
    */
    public void setIdVendaDinheiroPro(int pIdVendaDinheiroPro){
        this.idVendaDinheiroPro = pIdVendaDinheiroPro;
    }
    /**
    * return pk_idVendaDinheiroPro
    */
    public int getIdVendaDinheiroPro(){
        return this.idVendaDinheiroPro;
    }

    /**
    * seta o valor de produto
    * @param pProduto
    */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }
    /**
    * return fk_produto
    */
    public int getProduto(){
        return this.produto;
    }

    /**
    * seta o valor de venda
    * @param pVenda
    */
    public void setVenda(int pVenda){
        this.venda = pVenda;
    }
    /**
    * return fk_venda
    */
    public int getVenda(){
        return this.venda;
    }

    /**
    * seta o valor de valorVenda
    * @param pValorVenda
    */
    public void setValorVenda(Double pValorVenda){
        this.valorVenda = pValorVenda;
    }
    /**
    * return valorVenda
    */
    public Double getValorVenda(){
        return this.valorVenda;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(int pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public int getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "ModelvendaDinheiroPro {" + "::idVendaDinheiroPro = " + this.idVendaDinheiroPro + "::produto = " + this.produto + "::venda = " + this.venda + "::valorVenda = " + this.valorVenda + "::quantidade = " + this.quantidade +  "}";
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /** 
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
     public static String ELIMINAR_TUDO = "DELETE FROM tbl_venda_produto_abandono";
}