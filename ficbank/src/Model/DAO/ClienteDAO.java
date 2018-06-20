/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsPhpMyAdmin;
import DataBase.DataBaseGeneric;
import Model.Cliente;
import Model.Interfaces.ImplementCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kamimuraf
 */
public class ClienteDAO extends DataBaseGeneric implements ImplementCliente{
    
    public ArrayList<Cliente> list;
    
    public ClienteDAO(){
        super(new ConfigurationsPhpMyAdmin(), "cliente");
    }
    
    @Override
    public void insert(Cliente cliente){
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("name", cliente.getName());
        mapObj.put("telefone", cliente.getTelefone());
        mapObj.put("email", cliente.getEmail());
        mapObj.put("estado", cliente.getEstado());
        mapObj.put("cidade", cliente.getCidade());
        mapObj.put("logradouro", cliente.getLogradouro());
        mapObj.put("numero", cliente.getNumero());
        mapObj.put("bairro", cliente.getBairro());
        mapObj.put("cpf", cliente.getCpf());
        mapObj.put("ativo", cliente.isAtivo());
        
        this.genericInsert(mapObj);
    }
    
    
    @Override
    public void update(Cliente cliente){
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("name", cliente.getName());
        mapObj.put("telefone", cliente.getTelefone());
        mapObj.put("email", cliente.getEmail());
        mapObj.put("estado", cliente.getEstado());
        mapObj.put("cidade", cliente.getCidade());
        mapObj.put("logradouro", cliente.getLogradouro());
        mapObj.put("numero", cliente.getNumero());
        mapObj.put("bairro", cliente.getBairro());
        mapObj.put("cpf", cliente.getCpf());
        mapObj.put("ativo", cliente.isAtivo());
        mapConditions.put("id", cliente.getId());
        this.genericUpdate(mapObj, mapConditions);
    }
    
    @Override
    public void delete(int id){
    Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
        this.genericDelete(mapConditions);
    }
    
    @Override
    public List<Cliente> getClientePorNome(String nome){
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", nome);
            while (rs.next()) { 
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setName(rs.getString("name"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setAtivo(rs.getBoolean("ativo"));
                list.add(cliente);
            }
            return list;
        } catch (SQLException ex){
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Cliente> getAllCliente(){
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setName(rs.getString("name"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setAtivo(rs.getBoolean("ativo"));
                if(cliente.getId() != 1)
                    list.add(cliente);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public Cliente getUmCliente(int id){
        ResultSet rs = this.getOne(id);
        Cliente cliente = new Cliente();
        try {
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setName(rs.getString("name"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setAtivo(rs.getBoolean("ativo"));
                return cliente;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo id: " + ex.getMessage());
        }
        return null;
    }
}
