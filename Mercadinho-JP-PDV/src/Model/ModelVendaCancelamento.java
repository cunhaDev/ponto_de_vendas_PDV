package Model;
/**
*
* @author monet
*/
public class ModelVendaCancelamento {

    /**
     * @return the fkVenda
     */
    public int getFkVenda() {
        return fkVenda;
    }

    /**
     * @param fkVenda the fkVenda to set
     */
    public void setFkVenda(int fkVenda) {
        this.fkVenda = fkVenda;
    }

    /**
     * @return the pagamento
     */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    private int idVenda;
    private int cliente;
    private String data;
   private String hora;

    private Double valorLiquido;
    private Double ValorBruto;
    private Double ValorDesconto;
    private int usuario;
private String pagamento;
    private int fkVenda;
    /** 
    * Construtor
    */
    public ModelVendaCancelamento(){}

    /** 
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * return pk_idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    /**
    * return fk_cliente
    */
    public int getCliente(){
        return this.cliente;
    }

    /**
    * seta o valor de data
    * @param pData
    */
    public void setData(String pData){
        this.data = pData;
    }
    /**
    * return data
    */
    public String getData(){
        return this.data;
    }

    /**
    * seta o valor de valorLiquido
    * @param pValorLiquido
    */
    public void setValorLiquido(Double pValorLiquido){
        this.valorLiquido = pValorLiquido;
    }
    /**
    * return valorLiquido
    */
    public Double getValorLiquido(){ 
        return this.valorLiquido;
    }

    /**
    * seta o valor de ValorBruto
    * @param pValorBruto
    */
    public void setValorBruto(Double pValorBruto){
        this.ValorBruto = pValorBruto;
    }
    /**
    * return ValorBruto
    */
    public Double getValorBruto(){
        return this.ValorBruto;
    }

    /**
    * seta o valor de ValorDesconto
    * @param pValorDesconto
    */
    public void setValorDesconto(Double pValorDesconto){
        this.ValorDesconto = pValorDesconto;
    }
    /**
    * return ValorDesconto
    */
    public Double getValorDesconto(){
        return this.ValorDesconto;
    }

    /**
    * seta o valor de usuario
    * @param pUsuario
    */
    public void setUsuario(int pUsuario){
        this.usuario = pUsuario;
    }
    /**
    * return fk_usuario
    */
    public int getUsuario(){
        return this.usuario;
    }

    @Override
    public String toString(){
        return "Modelvenda {" + "::idVenda = " + this.idVenda + "::cliente = " + this.cliente + "::data = " + this.data + "::valorLiquido = " + this.valorLiquido + "::ValorBruto = " + this.ValorBruto + "::ValorDesconto = " + this.ValorDesconto + "::usuario = " + this.usuario +  "}";
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
        public static String ELIMINAR_TUDO = "DELETE FROM tbl_venda_cancelamento";

}