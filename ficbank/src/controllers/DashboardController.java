/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Cliente;
import Model.Conta;
import Model.DAO.ClienteDAO;
import views.Dashboard;

/**
 *
 * @author akira
 */
public class DashboardController {
    
    Conta conta;
    Cliente cliente;
    Dashboard dashboardView;

    public DashboardController(Conta conta) {
        this.conta = conta;
    }

    public DashboardController(Conta conta, Cliente cliente) {
        this.conta = conta;
        this.cliente = cliente;
    }

    public DashboardController(Conta conta, Cliente cliente, Dashboard dashboardView) {
        this.conta = conta;
        this.cliente = cliente;
        this.dashboardView = dashboardView;
    }
    
    public void navigateToDashboard() {
        if (cliente == null) {
            getCliente();
        }
        Dashboard dash = new Dashboard(conta, cliente);
        setValues(dash);
        dash.setVisible(true);
        
    }
    
    private void getCliente() {
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.getUmCliente(conta.getCl_id());
    }
    
    private void setValues(Dashboard dash) {
        dash.getLbl_nome().setText(cliente.getName());
        dash.getLbl_saldo().setText(String.valueOf(conta.getSaldo()));
    }
    
    
}
