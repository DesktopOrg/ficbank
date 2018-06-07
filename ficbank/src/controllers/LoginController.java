/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import Model.DAO.ContaDAO;
import javax.swing.JOptionPane;
import views.Dashboard;

/**
 *
 * @author kassia
 */
public class LoginController {
    private Conta conta;

    public LoginController(Conta conta) {
        this.conta = conta;
    }
    
    public boolean login(){
        ContaDAO dao = new ContaDAO();
        
        if(!login.isEmpty()){
            conta = dao.findUsuario(conta.getUser());
            if(conta != null){
                if(checkLogin(conta.getUser(), conta.getSenha())){
                    DashboardController dash = new DashboardController(conta);
                    return dash.goToDashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Inválidos! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Inválido! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Login Inválido! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean checkLogin(String user, String senha){
        return user.equals(getConta().getUser()) && checkSenha(senha);
    }
    
    public boolean checkSenha(String senha){
        if(!senha.equals(getConta().getSenha())){
            JOptionPane.showMessageDialog(null, "Senha Inválida! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        }
        return senha.equals(getConta().getSenha());
    }
    
    private Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta){
        this.conta = conta;
    }
}
