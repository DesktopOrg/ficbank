/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Transacao;
import java.util.List;

/**
 *
 * @author kassia
 */
public interface ImplementTransacao {
    public int insert(Transacao transacao);
    
    public void update(Transacao transacao);
    
    public void delete(int id);
    
    public List<Transacao> getTrasacaoPorUser(int id);
    
    public Transacao getUmaTransacao(int id);
    
    public int getIdUltimaTransacao();
}
