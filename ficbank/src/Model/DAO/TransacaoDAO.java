/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsPhpMyAdmin;
import DataBase.DataBaseGeneric;
import Model.Interfaces.ImplementTransacao;
import Model.Transacao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kassia
 */
public class TransacaoDAO extends DataBaseGeneric implements ImplementTransacao {
    public ArrayList<Transacao> list;
    private TransacaoDAO dao;
    
    public TransacaoDAO() {
        super(new ConfigurationsPhpMyAdmin(), "transacao");
        dao = new TransacaoDAO();
    }
    
    @Override
    public void insert(Transacao transacao) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id_conta", transacao.getConta().getId());
        mapObj.put("id_tag", transacao.getTag().getId());
        mapObj.put("valor", transacao.getValor());
        // mapObj.put("data", new Date());
        mapObj.put("tipo", transacao.getTipo());
        
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Transacao conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transacao> getTrasacaoPorUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transacao getUmaTransacao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
