/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.Interfaces.ImplementCliente;
import Model.Tabel.TableModelCliente;
import java.util.List;
import javax.swing.JOptionPane;
import views.CadastroCliente;
import views.teste;

/**
 *
 * @author kamimuraf
 */
public class ClienteController {
    
    private final CadastroCliente panel;
    private final ImplementCliente implementCliente;
    private List<Cliente> list;

    public ClienteController(CadastroCliente panel) {
        this.panel = panel;
        implementCliente = new ClienteDAO();
        list = implementCliente.getAllCliente();
    }
    
    
    public void reset(){
        panel.getTxt_nome().setText("");
        panel.getTxt_telefone().setText("");
        panel.getTxt_email().setText("");
        panel.getTxt_estado().setText("");
        panel.getTxt_cidade().setText("");
        panel.getTxt_logradouro().setText("");
        panel.getTxt_numero().setText("");
        panel.getTxt_bairro().setText("");
        panel.getTxt_cpf().setText("");
        panel.getChkAtivo().setSelected(true);
        panel.getTxt_id().setText("");
    }
    
    
    public void setTabel(){
        list = implementCliente.getAllCliente();
        panel.getTableCliente().setModel(new TableModelCliente(list));
    }

    public void getDataField(){
        int row = panel.getTableCliente().getSelectedRow();
        if(row != -1){
            panel.getTxt_id().setText(String.valueOf(list.get(row).getCl_id()));
            panel.getTxt_nome().setText(list.get(row).getName());
            panel.getTxt_email().setText(list.get(row).getEmail());
            panel.getTxt_telefone().setText(list.get(row).getTelefone());
            panel.getTxt_estado().setText(list.get(row).getEstado());
            panel.getTxt_cidade().setText(list.get(row).getCidade());
            panel.getTxt_logradouro().setText(list.get(row).getLogradouro());
            panel.getTxt_numero().setText(list.get(row).getNumero());
            panel.getTxt_bairro().setText(list.get(row).getBairro());
            panel.getTxt_cpf().setText(list.get(row).getCpf());
            panel.getChkAtivo().setSelected(list.get(row).isAtivo());
        }
    }
    
     public void insert(){
        Cliente cliente = new Cliente();
        cliente.setName(panel.getTxt_nome().getText());
        cliente.setEmail(panel.getTxt_email().getText());
        cliente.setTelefone(panel.getTxt_telefone().getText());
        cliente.setEstado(panel.getTxt_estado().getText());
        cliente.setCidade(panel.getTxt_cidade().getText());
        cliente.setLogradouro(panel.getTxt_logradouro().getText());
        cliente.setNumero(panel.getTxt_numero().getText());
        cliente.setBairro(panel.getTxt_bairro().getText());
        cliente.setCpf(panel.getTxt_cpf().getText());
        cliente.setAtivo(panel.getChkAtivo().isSelected());
        implementCliente.insert(cliente);
    }
    
    public void update(){
        Cliente cliente = new Cliente();
        cliente.setName(panel.getTxt_nome().getText());
        cliente.setEmail(panel.getTxt_email().getText());
        cliente.setTelefone(panel.getTxt_telefone().getText());
        cliente.setEstado(panel.getTxt_estado().getText());
        cliente.setCidade(panel.getTxt_cidade().getText());
        cliente.setLogradouro(panel.getTxt_logradouro().getText());
        cliente.setNumero(panel.getTxt_numero().getText());
        cliente.setBairro(panel.getTxt_bairro().getText());
        cliente.setCpf(panel.getTxt_cpf().getText());
        cliente.setAtivo(panel.getChkAtivo().isSelected());
        implementCliente.update(cliente);
    }
    
    public void delete(){
        if (panel.getTxt_id().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxt_id().getText());
        implementCliente.delete(row);
    }
    
    public void getData(){
        if (panel.getTxt_nomeSearch().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxt_nome().getText();
        implementCliente.getClientePorNome(name);
        this.filterTable(name);
    }
    
    public void filterTable(String name){
        list = implementCliente.getClientePorNome(name);
        panel.getTableCliente().setModel(new TableModelCliente(list));
    }
}
