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
    private int co_id;
    private String user;
    private String senha;
    private double saldo;
    private int cl_id;
    private boolean ativo;
    private String codigoReparticao;
    private Cliente cliente;
    
    public Conta(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Conta(int co_id, String user, String senha, double saldo, int cl_id, boolean ativo) {
        this.co_id = co_id;
        this.user = user;
        this.senha = senha;
        this.saldo = saldo;
        this.cl_id = cl_id;
        this.ativo = ativo;
    }

    public Conta() {
    }
    
    public int getCo_id() {
        return co_id;
    }

    public void setCo_id(int co_id) {
        this.co_id = co_id;
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

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
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
}
