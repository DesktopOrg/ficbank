/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import views.Dashboard;

/**
 *
 * @author akira
 */
public class DashboardController {
    
    Conta conta;
    Dashboard dashboardView;

    public DashboardController(Conta conta) {
        this.conta = conta;
    }


    public DashboardController(Conta conta, Dashboard dashboardView) {
        this.conta = conta;
        this.dashboardView = dashboardView;
    }
    
    public void navigateToDashboard() {
        Dashboard dash = new Dashboard(conta);
        setValues(dash);
        dash.setVisible(true);
    }
   
    private void setValues(Dashboard dash) {
        dash.getLbl_nome().setText(conta.getCliente().getName());
        dash.getLbl_saldo().setText(String.valueOf(conta.getSaldo()));
    }
    
    
}
