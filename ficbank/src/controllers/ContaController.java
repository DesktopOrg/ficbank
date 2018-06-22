/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Cliente;
import Model.Conta;
import Model.DAO.ClienteDAO;
import Model.DAO.ContaDAO;
import Model.Interfaces.ImplementConta;
import Model.Tabel.TableModelConta;
import Report.ReportContas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kassia
 */
public class ContaController {
    private Model.Conta conta;
    private final views.panels.AdmCadConta panel;
    private final ImplementConta implementConta;
    private List<Conta> list;
    
    
    
    public ContaController(Conta conta) {
        this.conta = conta;
        panel = null;
        implementConta = null;
    }
    
    public ContaController(views.panels.AdmCadConta panel) {
        this.panel = panel;
        implementConta = new ContaDAO();
        list = implementConta.getAllConta();
        
    }
    
    public void carregaCb_cliente(views.panels.AdmCadConta panel){
        ClienteDAO dao = new ClienteDAO();
        for (Cliente c: dao.getAllCliente()){
            if(c.getId()!= 1){
                panel.getCb_clientes().addItem(c);
            }
        }
    }
    public void reset(){
        panel.getCb_clientes().setSelectedIndex(0);
        panel.getTxt_login().setText("");
        panel.getTxt_senha().setText("");
        panel.getTxt_senhaReparticao().setText("");
        panel.getTxt_saldo().setText("");
        panel.getChkAtivo().setSelected(true);
        panel.getTxt_id().setText("");
    }
    
    public void setTabel(){
        list = implementConta.getAllConta();
        panel.getTableConta().setModel(new TableModelConta(list));
    }
    
    public void getDataField(){
        int row = panel.getTableConta().getSelectedRow();
        if(row != -1){
           Conta c = new Conta();
           c = implementConta.getAllConta().get(row);
             
           panel.getTxt_id().setText(String.valueOf(list.get(row).getId()));
           panel.getTxt_login().setText(c.getUser());
           panel.getTxt_senha().setText(c.getSenha());
           panel.getTxt_senhaReparticao().setText(c.getCodigoReparticao());
           panel.getTxt_saldo().setText(Double.toString(c.getSaldo()));
           panel.getChkAtivo().setSelected(list.get(row).isAtivo());
        }
    }
    
    public void insert(){
        Conta conta = new Conta();
        conta.setUser(panel.getTxt_login().getText());
        conta.setSenha(panel.getTxt_senha().getPassword().toString());
        conta.setSaldo(Double.parseDouble(panel.getTxt_saldo().getText()));
        conta.setCodigoReparticao(panel.getTxt_senhaReparticao().getPassword().toString());
        Cliente c = (Cliente) panel.getCb_clientes().getSelectedItem();
        conta.setCliente(c);
        conta.setAtivo(true); //sempre que for criado ele tem que ser ativo
        if ( (implementConta.getClienteConta(c.getId())).isEmpty()){
            if ( implementConta.getContaPorUser(conta.getUser()).isEmpty() ){
                implementConta.insert(conta);
            }else{
               JOptionPane.showMessageDialog(null, "O login de usuário já existe. Não foi possível cadastrar", "Informação", JOptionPane.INFORMATION_MESSAGE); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cliente já possui conta: " + implementConta.getClienteConta(c.getId()).get(0).getUser() , "Informação", JOptionPane.INFORMATION_MESSAGE); 
        }
        
        
    }
    
    public void delete(){
        if (panel.getTxt_id().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxt_id().getText());
        implementConta.delete(row);
    }
    
    
     public boolean verificar(){
        if (panel.getTxt_login().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo User está vazio, preencha-o antes de continuar!");
            panel.getTxt_login().grabFocus();
            return false;
        }
        if (panel.getTxt_senha().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo senha está vazio, preencha-o antes de continuar!");
            panel.getTxt_senha().grabFocus();
            return false;
        }
        if (panel.getTxt_senhaReparticao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo senha da reparição está vazio, preencha-o antes de continuar!");
            panel.getTxt_senhaReparticao().grabFocus();
            return false;
        }
        if (panel.getTxt_saldo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Campo saldo está vazio, preencha-o antes de continuar!");
            panel.getTxt_saldo().grabFocus();
            return false;
        }
        
        Double valor;
        if (panel.getTxt_saldo().getText().length() != 0) {
            try {
                valor = Double.parseDouble(panel.getTxt_saldo().getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo saldo só aceita números", "Informação", JOptionPane.INFORMATION_MESSAGE);
                panel.getTxt_saldo().grabFocus();
                return false;
            }
        }

        return true;  
    }
     public void getData(){
        if (panel.getTxt_userSearch().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de usuário para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxt_userSearch().getText();
        implementConta.getContaPorUser(name);
        this.filterTable(name);
    }
    
    public void filterTable(String name){
        list = implementConta.getContaPorUser(name);
        panel.getTableConta().setModel(new TableModelConta(list));
    }
    
    public void update(){
        Conta conta = new Conta();
        conta.setUser(panel.getTxt_login().getText());
        //conta.setSenha(panel.getTxt_senha().getPassword().toString());
        conta.setSaldo(Double.parseDouble(panel.getTxt_saldo().getText()));
        //conta.setCodigoReparticao(panel.getTxt_senhaReparticao().getPassword().toString());
        Cliente c = (Cliente) panel.getCb_clientes().getSelectedItem();
        conta.setCliente(c);
        conta.setAtivo(panel.getChkAtivo().isSelected());
        implementConta.update(conta);
    }
    
    public void GeraRelatorio(){
        try {
            new ReportContas().generate("reportConta.jrxml");
        } catch (Exception e) {
            e.printStackTrace();
        }

}
    
}


/*  
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
*/