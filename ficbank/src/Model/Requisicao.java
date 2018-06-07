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
public class Requisicao {
    private int re_id;
    private double valor;
    private String dia;
    private boolean aprovado;
    private boolean visualizado;
    private int op_id;
    private int ta_id;
    private int co_idRemetente;
    private int co_idDestino;

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public int getOp_id() {
        return op_id;
    }

    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    public int getTa_id() {
        return ta_id;
    }

    public void setTa_id(int ta_id) {
        this.ta_id = ta_id;
    }

    public int getCo_idRemetente() {
        return co_idRemetente;
    }

    public void setCo_idRemetente(int co_idRemetente) {
        this.co_idRemetente = co_idRemetente;
    }

    public int getCo_idDestino() {
        return co_idDestino;
    }

    public void setCo_idDestino(int co_idDestino) {
        this.co_idDestino = co_idDestino;
    }
    
   
    
}
