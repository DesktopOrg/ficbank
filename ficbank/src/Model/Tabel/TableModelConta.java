/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tabel;

import Model.Conta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kamimuraf
 */
public class TableModelConta extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    List<Conta> list;
    
    public TableModelConta(List<Conta> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
   

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getUser();
            case 2: return list.get(rowIndex).getSaldo();
            case 3: return list.get(rowIndex).getCliente().getId();
            case 4: return list.get(rowIndex).getCliente().getName();
            
            default:return null;
        } 
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "ID";
            case 1: return "USUARIO";
            case 2: return "SALDO";
            case 3: return "ID CLIENTE";
            case 4: return "CLIENTE";
            default:return null; 
        }
    }
    
}
