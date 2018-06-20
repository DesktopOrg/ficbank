/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Arquivos.Binario;
import Arquivos.Json;
import Arquivos.Texto;
import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.Interfaces.ImplementCliente;
import Model.Tabel.TableModelCliente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.panels.AdmCadCliente;

/**
 *
 * @author kamimuraf
 */
public class ClienteController {
    
    private final AdmCadCliente panel;
    private final ImplementCliente implementCliente;
    private List<Cliente> list;

    public ClienteController(AdmCadCliente panel) {
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
            panel.getTxt_id().setText(String.valueOf(list.get(row).getId()));
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
        cliente.setAtivo(true);
        implementCliente.insert(cliente);
    }
    
    public void update(){
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(panel.getTxt_id().getText()));
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
            JOptionPane.showMessageDialog(panel, "Digite um nome para buscar.", null, JOptionPane.WARNING_MESSAGE);
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
    
    public boolean verificar(){
        if (panel.getTxt_nome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo Nome está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_telefone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo telefone está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_email().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo email está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_estado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo estado está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_cidade().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo cidade está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_logradouro().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo logradouro está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_bairro().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo bairro está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_numero().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo numero está vazio, preencha-o antes de continuar!");
            return false;
        }
        if (panel.getTxt_cpf().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo CPF está vazio, preencha-o antes de continuar!");
            return false;
        }

        long valor;
        if (panel.getTxt_telefone().getText().length() != 0) {
            try {
                valor = Long.parseLong(panel.getTxt_telefone().getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo Telefone só aceita números", "Informação", JOptionPane.INFORMATION_MESSAGE);
                panel.getTxt_telefone().grabFocus();
                return false;
            }
        }

        if (panel.getTxt_cpf().getText().length() != 0) {
            try {
                valor = Long.parseLong(panel.getTxt_cpf().getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo CPF só aceita números", "Informação", JOptionPane.INFORMATION_MESSAGE);
                panel.getTxt_cpf().grabFocus();
                return false;
            }
        }
    
        return true;  
    }
    
    public void preencheCampos(Cliente c){
        panel.getTxt_nome().setText(c.getName());
        panel.getTxt_telefone().setText(c.getTelefone());
        panel.getTxt_email().setText(c.getEmail());
        panel.getTxt_estado().setText(c.getEstado());
        panel.getTxt_cidade().setText(c.getCidade());
        panel.getTxt_logradouro().setText(c.getLogradouro());
        panel.getTxt_numero().setText(c.getNumero());
        panel.getTxt_bairro().setText(c.getBairro());
        panel.getTxt_cpf().setText(c.getCpf());
        panel.getChkAtivo().setSelected(c.isAtivo());
        panel.getTxt_id().setText(Integer.toString(c.getId()));
    
    }
    public Cliente montarObj(){
            Cliente c = new Cliente();
            c.setName(panel.getTxt_nome().getText());
            c.setCpf(panel.getTxt_cpf().getText());
            c.setEmail(panel.getTxt_email().getText());
            c.setTelefone(panel.getTxt_telefone().getText());
            c.setEstado(panel.getTxt_estado().getText());
            c.setCidade(panel.getTxt_cidade().getText());
            c.setLogradouro(panel.getTxt_logradouro().getText());
            c.setNumero(panel.getTxt_numero().getText());
            c.setBairro(panel.getTxt_bairro().getText());
            c.setAtivo(panel.getChkAtivo().isSelected());
            JOptionPane.showMessageDialog(null, "Objeto criado com sucesso!");
            return c;
    }
    
    public void salvarTexto(){
        Texto t = new Texto();
        if (verificar()){
            Cliente c = new Cliente();
            c = montarObj();
            try {
                t.TextFileWriter(c);
                //limparCampos();
            } catch (IOException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    
    public void salvarJson(){
        Json json = new Json();
        if (verificar()){
            Cliente c = new Cliente();
            c = montarObj();
            json.saveJSON("./arquivoJson.json", json.convertToJSON(c));
        }
    }
    
    public void salvarBinario(){
        Binario bin = new Binario();
        if(verificar()){
            Cliente c = new Cliente();
            c = montarObj();
            bin.openFileWrite();
            bin.addRecords(c);
            bin.closeFileOut();
        }
    }
    
    public void loadTexto(){
        Texto t = new Texto();
        Cliente retorno = new Cliente();
        try {
            retorno = t.TextFileReader();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencheCampos(retorno);
    }

    public void loadJson(){
        Json json = new Json();
        Cliente c = json.convertToCliente(json.loadJSON("./arquivoJson.json"));
        preencheCampos(c);
    }
    
    public void loadBinario(){
        Binario bin = new Binario();
        bin.openFileRead();
        Cliente c = new Cliente();
        c = bin.readRecords();
        bin.closeFileIn();
        preencheCampos(c);
    }
}
