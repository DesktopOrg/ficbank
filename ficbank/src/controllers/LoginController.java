/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import views.Dashboard;

/**
 *
 * @author kassia
 */
public class LoginController {
    private Usuario usuario;

    public LoginController(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean login(){
        UsuarioDAO dao = new UsuarioDAO();
        
        if(!login.isEmpty()){
            usuario = dao.findUsuario(usuario.getLogin());
            if(usuario != null){
                if(checkLogin(usuario.getLogin(), usuario.getSenha())){
                    DashboardController dash = new DashboardController(usuario);
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
    
    public boolean checkLogin(String login, String senha){
        return login.equals(getUsuario().getLogin()) && checkSenha(senha);
    }
    
    public boolean checkSenha(String senha){
        if(!senha.equals(getUsuario().getSenha())){
            JOptionPane.showMessageDialog(null, "Senha Inválida! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        }
        return senha.equals(getUsuario().getSenha());
    }
    
    private Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
