/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoDepartamento;
import Model.ModelDepartamento;
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
     public class ControllerDepartamento {
    
    
     private DaoDepartamento dao = new DaoDepartamento();
     
     
     
     //SALVAR
     public int salvarController(ModelDepartamento mod){
     return dao.SalvarDao(mod);
     }
     //EXCLUIR
     public boolean excluirController(int id){
     return this.dao.excluirDao(id);
     }
     
     //RETORNAR UMA LISTA
     public ArrayList<ModelDepartamento> listaModelController(){
     return this.dao.retornarLista();
     }
     
     //RETORNAR UM
     public ModelDepartamento retornarController(int cod){
     return this.dao.retornarDao(cod);
     }
     //ALTERAR 
     public boolean alterarController(ModelDepartamento mod){
     return this.dao.alterarDao(mod);
     }
     
}
