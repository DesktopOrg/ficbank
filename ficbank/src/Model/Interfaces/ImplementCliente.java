/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Cliente;
import java.util.List;

/**
 *
 * @author kamimuraf
 */
public interface ImplementCliente {
    public void insert(Cliente cliente);
    
    public void update(Cliente cliente);
    
    public void delete(int id);
    
    public List<Cliente> getClientePorNome(String nome);
    
    public List<Cliente> getAllCliente();
    
    public Cliente getUmCliente(int id);
}
