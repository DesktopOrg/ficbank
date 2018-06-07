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
 * @author kassia
 */
public class NavigateController {
    
    private Conta conta;

    public NavigateController(Conta conta) {
        this.conta = conta;
    }
    
    public boolean goToDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setConta(conta);
        dashboard.setVisible(true);
        return true;
    }
}
