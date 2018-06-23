/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsPhpMyAdmin;
import DataBase.DataBaseGeneric;
import Model.Interfaces.ImplementRequisicao;
import Model.Requisicao;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kassia
 */
public class RequisicaoDAO extends DataBaseGeneric implements ImplementRequisicao {

    public ArrayList<Requisicao> list;
    private TransacaoDAO dao;
    
    public RequisicaoDAO() {
        super(new ConfigurationsPhpMyAdmin(), "requisicao");
    }
    
    @Override
    public void insert(Requisicao requisicao) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id_conta_requisicao", requisicao.getConta().getId());
        // mapObj.put("id_tag", transacao.getTag().getId());
        mapObj.put("valor", requisicao.getValor());
        mapObj.put("data", new Date());
        mapObj.put("aprovado", 0);
        mapObj.put("visualizado", 0);
        mapObj.put("id_transacao", requisicao.getTransacao().getId());
        
        this.genericInsert(mapObj);
    }
    
}
