/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DataBase.DataBaseGeneric;
import Model.Conta;
import Model.Interfaces.ImplementConta;
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
public class ContaDAO extends DataBaseGeneric implements ImplementConta{
     public ArrayList<Conta> list;
     
    @Override
    public void insert(Conta conta) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("user", conta.getUser());
        mapObj.put("senha", conta.getSenha());
        mapObj.put("saldo", conta.getSaldo());
        mapObj.put("ativo", conta.isAtivo());
        mapObj.put("cl_id", conta.getCl_id());

        
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Conta conta) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("user", conta.getUser());
        mapObj.put("senha", conta.getSenha());
        mapObj.put("saldo", conta.getSaldo());
        mapObj.put("ativo", conta.isAtivo());
        mapObj.put("cl_id", conta.getCl_id());
        mapConditions.put("co_id", conta.getCo_id());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("co_id", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Conta> getContaPorUser(String user) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("user", user);
            while (rs.next()) { 
                Conta conta = new Conta();
                conta.setCo_id(rs.getInt(1));
                conta.setUser(rs.getString("user"));
                conta.setSenha(rs.getString("email"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setAtivo(rs.getBoolean("ativo"));
                conta.setCl_id(rs.getInt("cl_id"));
                list.add(conta);
            }
            return list;
        } catch (SQLException ex){
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Conta> getAllConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta getUmaConta(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
/*
    @Override
    public List<Cliente> getAllCliente(){
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Cliente conta = new Cliente();
                conta.setCl_id(rs.getInt(1));
                conta.setName(rs.getString("name"));
                conta.setEmail(rs.getString("email"));
                conta.setTelefone(rs.getString("telefone"));
                conta.setEstado(rs.getString("estado"));
                conta.setCidade(rs.getString("cidade"));
                conta.setLogradouro(rs.getString("logradouro"));
                conta.setNumero(rs.getString("numero"));
                conta.setBairro(rs.getString("bairro"));
                conta.setCpf(rs.getString("cpf"));
                conta.setAtivo(rs.getBoolean("ativo"));
                list.add(conta);
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
        Cliente conta = new Cliente();
        try {
            conta.setCl_id(rs.getInt(1));
            conta.setName(rs.getString("name"));
            conta.setEmail(rs.getString("email"));
            conta.setTelefone(rs.getString("telefone"));
            conta.setEstado(rs.getString("estado"));
            conta.setCidade(rs.getString("cidade"));
            conta.setLogradouro(rs.getString("logradouro"));
            conta.setNumero(rs.getString("numero"));
            conta.setBairro(rs.getString("bairro"));
            conta.setCpf(rs.getString("cpf"));
            conta.setAtivo(rs.getBoolean("ativo"));
            return conta;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo id: " + ex.getMessage());
        }
        return null;
    }

*/