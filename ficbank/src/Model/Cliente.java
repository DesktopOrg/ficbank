/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author kamimuraf
 */
public class Cliente implements Serializable{
    private int cl_id;
    private String name;
    private String telefone;
    private String email;
    private String estado;
    private String cidade;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cpf;
    private boolean ativo;

    public Cliente(int cl_id, String name, String telefone, String email, String estado, String cidade, String logradouro, String numero, String bairro, String cpf, boolean ativo) {
        this.cl_id = cl_id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    public Cliente() {
   
    }
       
    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
