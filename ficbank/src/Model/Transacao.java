/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author kamimuraf
 */
public class Transacao {
    private int id;
    private Conta conta;
    private Tag tag;
    private double valor;
    private Date data;
    private TipoEnum tipo;

    public Transacao(int id, Conta conta, Tag tag, double valor, Date data, TipoEnum tipo) {
        this.id = id;
        this.conta = conta;
        this.tag = tag;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Transacao(Conta conta, double valor, TipoEnum tipo) {
        this.conta = conta;
        this.valor = valor;
        this.tipo = tipo;
    }

    
    
    public Transacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }
}
