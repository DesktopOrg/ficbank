/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tabel;

import Model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kamimuraf
 */
public class TableModelCliente extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Cliente> list ;

    public TableModelCliente(List<Cliente> list) {
        this.list = list;
    }
       
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getCl_id();
            case 1 : return list.get(rowIndex).getName();
            case 2 : return list.get(rowIndex).getTelefone();
            case 3 : return list.get(rowIndex).getEmail();
            case 4 : return list.get(rowIndex).getEstado();
            case 5 : return list.get(rowIndex).getCidade();
            case 6 : return list.get(rowIndex).getLogradouro();
            case 7 : return list.get(rowIndex).getNumero();
            case 8 : return list.get(rowIndex).getBairro();
            case 9 : return list.get(rowIndex).getCpf();
            case 10 : return list.get(rowIndex).isAtivo();
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0  : return "ID";
            case 1  : return "NOME";
            case 2  : return "TELEFONE";
            case 3  : return "EMAIL";
            case 4  : return "ESTADO";
            case 5  : return "CIDADE";
            case 6  : return "LOGRADOURO";
            case 7  : return "NUMERO";
            case 8  : return "BAIRRO";
            case 9  : return "CPF";
            case 10  : return "ATIVO";
            
            default : return null;
        }
    }
}