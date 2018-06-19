/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsPhpMyAdmin;
import Configurations.ConfigurationsMySQL;
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
     public ContaDAO(){
        super(new ConfigurationsMySQL(), "conta");
    }
    @Override
    public void insert(Conta conta) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("user", conta.getUser());
        mapObj.put("senha", conta.getSenha());
        mapObj.put("saldo", conta.getSaldo());
        mapObj.put("ativo", conta.isAtivo());
        mapObj.put("id", conta.getCl_id());

        
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
        mapObj.put("id", conta.getCl_id());
        mapConditions.put("id", conta.getCo_id());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
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
                conta.setSenha(rs.getString("senha"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setAtivo(rs.getBoolean("ativo"));
                conta.setCl_id(rs.getInt("id"));
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
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Conta conta = new Conta();
                conta.setCo_id(rs.getInt(1));
                conta.setUser(rs.getString("user"));
                conta.setSenha(rs.getString("senha"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setAtivo(rs.getBoolean("ativo"));
                conta.setCl_id(rs.getInt("id"));
                list.add(conta);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Conta getUmaConta(int id) {
        ResultSet rs = this.getOne(id);
        Conta conta = new Conta();
        try {
            conta.setCo_id(rs.getInt(1));
            conta.setUser(rs.getString("user"));
            conta.setSenha(rs.getString("senha"));
            conta.setSaldo(rs.getDouble("saldo"));
            conta.setAtivo(rs.getBoolean("ativo"));
            conta.setCl_id(rs.getInt("id"));
            return conta;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar uma conta pelo id: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Conta login(String login, String senha) {
        ResultSet rs = this.getUserLogin(login, senha);
        Conta conta = new Conta();
        try {
            if (!rs.next())
                return null;
            
            conta.setCo_id(rs.getInt(1));
            conta.setUser(rs.getString("user"));
            conta.setSenha(rs.getString("senha"));
            conta.setSaldo(rs.getDouble("saldo"));
            conta.setAtivo(rs.getBoolean("ativo"));
            conta.setCl_id(rs.getInt("id"));
            
            return conta;
        } catch (SQLException ex) {
            System.out.println("Erro ao fazer login: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Conta getContaReparticao(int codigoConta, String codigoReparticao) {
        ResultSet rs = this.getUserReparticao(codigoConta, codigoReparticao);
        Conta conta = new Conta();
        try {
            if (!rs.next())
                return null;
            
            conta.setCo_id(rs.getInt(1));
            conta.setUser(rs.getString("user"));
            conta.setSenha(rs.getString("senha"));
            conta.setSaldo(rs.getDouble("saldo"));
            conta.setAtivo(rs.getBoolean("ativo"));
            conta.setCl_id(rs.getInt("id"));
            //conta.setCodigoReparticao("codigo_reparticao");
            ClienteDAO dao = new ClienteDAO();
            conta.setCliente(dao.getUmCliente(conta.getCl_id()));
            
            return conta;
        } catch (SQLException ex) {
            System.out.println("Erro ao encontrar conta para particionar um debito: " + ex.getMessage());
        }
        return null;
    }
    
}