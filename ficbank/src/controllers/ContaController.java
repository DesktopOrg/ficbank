/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import Model.DAO.ContaDAO;
import Model.Interfaces.ImplementConta;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kassia
 */
public class ContaController {
    private Model.Conta conta;
    private final views.Conta panel;
    private final ImplementConta implementConta;
    private List<Conta> list;
    
    public ContaController(Conta conta) {
        this.conta = conta;
        panel = null;
        implementConta = null;
    }
    
    public ContaController(views.Conta panel) {
        this.panel = panel;
        implementConta = new ContaDAO();
        list = implementConta.getAllConta();
    }
    
    public void reset(){
        panel.getTxt_nome().setText("");
        panel.getTxt_senha().setText("");
        panel.getTxt_saldo().setText("");
        panel.getChkAtivo().setSelected(true);        
    }
    
    public void setTabel(){
        list = implementConta.getAllConta();
        //panel.getTableCliente().setModel(new TableModelConta(list));
    }
    
    public void getDataField(){
        int row = panel.getTableCliente().getSelectedRow();
        if(row != -1){
  
        }
    }
    
    
}


/*

private final CadastroConta panel;

    
    
     public void insert(){
        Conta conta = new Conta();
        conta.setName(panel.getTxt_nome().getText());
        conta.setEmail(panel.getTxt_email().getText());
        conta.setTelefone(panel.getTxt_telefone().getText());
        conta.setEstado(panel.getTxt_estado().getText());
        conta.setCidade(panel.getTxt_cidade().getText());
        conta.setLogradouro(panel.getTxt_logradouro().getText());
        conta.setNumero(panel.getTxt_numero().getText());
        conta.setBairro(panel.getTxt_bairro().getText());
        conta.setCpf(panel.getTxt_cpf().getText());
        conta.setAtivo(panel.getChkAtivo().isSelected());
        implementConta.insert(conta);
    }
    
    public void update(){
        Conta conta = new Conta();
        conta.setName(panel.getTxt_nome().getText());
        conta.setEmail(panel.getTxt_email().getText());
        conta.setTelefone(panel.getTxt_telefone().getText());
        conta.setEstado(panel.getTxt_estado().getText());
        conta.setCidade(panel.getTxt_cidade().getText());
        conta.setLogradouro(panel.getTxt_logradouro().getText());
        conta.setNumero(panel.getTxt_numero().getText());
        conta.setBairro(panel.getTxt_bairro().getText());
        conta.setCpf(panel.getTxt_cpf().getText());
        conta.setAtivo(panel.getChkAtivo().isSelected());
        implementConta.update(conta);
    }
    
    public void delete(){
        if (panel.getTxt_id().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxt_id().getText());
        implementConta.delete(row);
    }
    
    public void getData(){
        if (panel.getTxt_nomeSearch().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxt_nome().getText();
        implementConta.getContaPorNome(name);
        this.filterTable(name);
    }
    
    public void filterTable(String name){
        list = implementConta.getContaPorNome(name);
        panel.getTableConta().setModel(new TableModelConta(list));
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
    
    public void preencheCampos(Conta c){
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
        panel.getTxt_id().setText(Integer.toString(c.getCl_id()));
    
    }
    public Conta montarObj(){
            Conta c = new Conta();
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
            Conta c = new Conta();
            c = montarObj();
            try {
                t.TextFileWriter(c);
                //limparCampos();
            } catch (IOException ex) {
                Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    
    public void salvarJson(){
        Json json = new Json();
        if (verificar()){
            Conta c = new Conta();
            c = montarObj();
            json.saveJSON("./arquivoJson.json", json.convertToJSON(c));
        }
    }
    
    public void salvarBinario(){
        Binario bin = new Binario();
        if(verificar()){
            Conta c = new Conta();
            c = montarObj();
            bin.openFileWrite();
            bin.addRecords(c);
            bin.closeFileOut();
        }
    }
    
    public void loadTexto(){
        Texto t = new Texto();
        Conta retorno = new Conta();
        try {
            retorno = t.TextFileReader();
        } catch (IOException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        preencheCampos(retorno);
    }

    public void loadJson(){
        Json json = new Json();
        Conta c = json.convertToConta(json.loadJSON("./arquivoJson.json"));
        preencheCampos(c);
    }
    
    public void loadBinario(){
        Binario bin = new Binario();
        bin.openFileRead();
        Conta c = new Conta();
        c = bin.readRecords();
        bin.closeFileIn();
        preencheCampos(c);
    }

*/