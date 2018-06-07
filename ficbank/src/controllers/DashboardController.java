/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.Dashboard;

/**
 *
 * @author kassia
 */
public class DashboardController {
    
    private Usuario usuario;

    public DashboardController(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean goToDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setUsuario(usuario);
        dashboard.setVisible(true);
        return true;
    }
}
