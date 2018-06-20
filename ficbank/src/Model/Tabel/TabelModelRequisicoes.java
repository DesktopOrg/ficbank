/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tabel;

import Model.Cliente;
import Model.Requisicao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kamimuraf
 */
public class TabelModelRequisicoes extends AbstractTableModel{
    List<Requisicao> list ;

    public TabelModelRequisicoes(List<Requisicao> list) {
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
            case 0 : return list.get(rowIndex).getRe_id();
            case 1 : return list.get(rowIndex).getCo_idRemetente();
            case 2 : return list.get(rowIndex).getOperacao().getDescricao();
            case 3 : return list.get(rowIndex).getValor();
            case 4 : return list.get(rowIndex).getCo_idRemetente();
            case 5 : return list.get(rowIndex).getDia();
            case 6 : return list.get(rowIndex).isAprovado();
 
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0  : return "ID";
            case 1  : return "ID REMETENTE";
            case 2  : return "OPERAÇÃO";
            case 3  : return "VALOR";
            case 4  : return "DESTINATARIO";
            case 5  : return "DIA";
            case 6  : return "APROVADO";
            
            default : return null;
        }
    }
}
