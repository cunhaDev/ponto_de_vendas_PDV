package Model;
/**
*
* @author monet
*/
public class ModelVendaCartao2 {

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * @return the DataRelatorio
     */
    public String getDataRelatorio() {
        return DataRelatorio;
    }

    /**
     * @param DataRelatorio the DataRelatorio to set
     */
    public void setDataRelatorio(String DataRelatorio) {
        this.DataRelatorio = DataRelatorio;
    }

    /**
     * @return the DataAnual
     */
    public String getDataAnual() {
        return DataAnual;
    }

    /**
     * @param DataAnual the DataAnual to set
     */
    public void setDataAnual(String DataAnual) {
        this.DataAnual = DataAnual;
    }

    /**
     * @return the data_relatorio
     */
    public String getData_relatorio() {
        return data_relatorio;
    }

    /** 
     * @param data_relatorio the data_relatorio to set
     */
    public void setData_relatorio(String data_relatorio) {
        this.data_relatorio = data_relatorio;
    }

    private int idVenda;
    private int cliente;
    private String data; 
    private String hora;
    private String DataRelatorio;
    private String DataAnual;
    private Double valorLiquido;
    private Double ValorBruto;
    private Double ValorDesconto;
    private int usuario;
    private String data_relatorio; 
    private String dataAnual; 
    private int turno;
    /**  
    * Construtor
    */
    public ModelVendaCartao2(){}

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
}