/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Conta;
import java.util.List;


/**
 *
 * @author kamimuraf
 */
public interface ImplementConta {
    public void insert(Conta conta);
    
    public void update(Conta conta);
    
    public void delete(int id);
    
    public List<Conta> getContaPorUser(String user);
    
    public List<Conta> getAllConta();
    
    public Conta getUmaConta(int id);
    
    public Conta login(String login, String senha);
}
