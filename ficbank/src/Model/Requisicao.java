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
public class Requisicao {
    private int id;
    private double valor;
    private Date data;
    private boolean aprovado;
    private boolean visualizado;
    private Transacao transacao;
    private Conta conta;

    public Requisicao(int id, double valor, Date data, boolean aprovado, boolean visualizado, Transacao transacao, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.aprovado = aprovado;
        this.visualizado = visualizado;
        this.transacao = transacao;
        this.conta = conta;
    }

    public Requisicao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    
}
