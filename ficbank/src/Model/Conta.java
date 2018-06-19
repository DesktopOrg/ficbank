/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kamimuraf
 */
public class Conta {
    private int id;
    private String user;
    private String senha;
    private double saldo;
    private boolean ativo;
    private boolean admin;
    private String codigoReparticao;
    private Cliente cliente;
    
    public Conta(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Conta(int id, String user, String senha, double saldo, int cl_id, boolean ativo) {
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.saldo = saldo;
        this.ativo = ativo;
    }

    public Conta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigoReparticao() {
        return codigoReparticao;
    }

    public void setCodigoReparticao(String codigoReparticao) {
        this.codigoReparticao = codigoReparticao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
