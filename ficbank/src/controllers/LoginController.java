/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import Model.DAO.ContaDAO;
import javax.swing.JOptionPane;
import views.Login;

/**
 *
 * @author akira
 */
public class LoginController {
    private Login loginView;

    public LoginController(Login login) {
        this.loginView = login;
    }
    
    public void login() {
        String login = loginView.getTxt_login().getText();
        String senha = new String(loginView.getTxt_senha().getPassword());
        if (login.isEmpty() && senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login e Senha Inválidos! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        } else if(login.isEmpty() && !senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login Inválido! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        } else if(!login.isEmpty() && senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Senha Inválida! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        } else {
            validateClient(login, senha);
        }
    }
    
    private void validateClient(String login, String senha) {
        ContaDAO dao = new ContaDAO();
        Conta conta = dao.login(login, senha);
        if (conta != null) {
            DashboardController controller = new DashboardController(conta);
            controller.navigateToDashboard();
            loginView.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Falha no login, conta não encontrada no banco de dados! Tente Novamente.", "Conta não encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
