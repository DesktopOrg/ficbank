/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import Model.DAO.ContaDAO;
import Model.DAO.TransacaoDAO;
import Model.TipoEnum;
import Model.Transacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import views.panels.PanelCadastroReparticao;

/**
 *
 * @author kassia
 */
public class ReparticaoController {

    PanelCadastroReparticao panel;
    private List<Conta> contasReparticaoList;
    private DefaultListModel modelList;
    
    public ReparticaoController() {
        contasReparticaoList = new ArrayList<>();
        modelList = new DefaultListModel();
    }

    public ReparticaoController(PanelCadastroReparticao panel) {
        this.panel = panel;
        contasReparticaoList = new ArrayList<>();
        modelList = new DefaultListModel();
    }
    
    public void cancelarReparticao() {
        
    }
    
    public void adicionarReparticaoListaView(String contaReparticionada) {
        // !contasReparticao.isEmpty()
        if (!contaReparticionada.isEmpty()) {
            modelList.addElement(contaReparticionada);
            panel.getList_contas_reparticao().setModel(modelList);
            limparCamposCadastroContaReparticao();
        }
    }
    
    public void removeConta() {
        if (!modelList.isEmpty()) {
            for (Conta c: contasReparticaoList) {
                if (panel.getList_contas_reparticao().getSelectedValue().contains(String.valueOf(c.getId()))) {
                    contasReparticaoList.remove(c);
                    modelList.removeElementAt(panel.getList_contas_reparticao().getSelectedIndex());
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível excluir, a lista está vazia.", "Erro ao excluir conta de repartição", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void adicionarConta() {
        ContaDAO dao = new ContaDAO();
        String numeroConta = panel.getTxt_conta_reparticao().getText();
        String codigoReparticao = panel.getTxt_codigo_conta_reparticao().getText();
        if(validaAdicaoDeContaReparticao(numeroConta, codigoReparticao)){
            Conta reparticao = dao.getContaReparticao(Integer.parseInt(numeroConta), codigoReparticao);

            if (reparticao != null) {
                if (!verificaSeExisteNasContasAdicionadas(reparticao)) {
                    contasReparticaoList.add(reparticao);
                    String reparticaoList = "("+ reparticao.getId() + ") - " + reparticao.getCliente().getName();
                    adicionarReparticaoListaView(reparticaoList);
                } else {
                    JOptionPane.showMessageDialog(null, "Conta já está adicionada na lista! Insira uma conta diferente.", "Erro adicionar conta repartição", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Conta Inválida! Tente Novamente.", "Erro adicionar conta repartição", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean verificaSeExisteNasContasAdicionadas(Conta conta) {
        for (Conta c : contasReparticaoList) {
            if (c.getId() == conta.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean validaAdicaoDeContaReparticao(String numero, String codigo) {
        if (!numero.isEmpty() && !codigo.isEmpty()) {
            return true;
        } else if(!numero.isEmpty() && codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Numero da Conta Inválido! Tente Novamente.", "Erro adicionar conta repartição", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(numero.isEmpty() && !codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código da Conta Inválido! Tente Novamente.", "Erro adicionar conta repartição", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Numero da Conta e Código de Repartição Inválidos! Tente Novamente.", "Erro adicionar conta repartição", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void limparCamposCadastroContaReparticao() {
        panel.getTxt_codigo_conta_reparticao().setText("");
        panel.getTxt_conta_reparticao().setText("");
        panel.getTxt_conta_reparticao().requestFocus();
    }

    public void salvarReparticao() {
        if (panel.getTxt_total_dabito().getText().isEmpty() || Double.parseDouble(panel.getTxt_total_dabito().getText()) <= 10) {
            JOptionPane.showMessageDialog(null, "Valor do débito total inválido", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        } else {
            double debitoTotal = Double.parseDouble(panel.getTxt_total_dabito().getText());
            if (!contasReparticaoList.isEmpty()) {
                TransacaoDAO dao = new TransacaoDAO();
                System.out.println(panel.getDashboard().conta.getId());
                Transacao transacao = new Transacao(panel.getDashboard().conta, debitoTotal, TipoEnum.REQUISICAO);
                int id = dao.insert(transacao);
                
                // Cadastrar Transação (1 transação para muitos usuarios na transação)
                // Campos: id, Valor Total, Valor Repartido, data_criada
                
                
                // Cadastrar Usuarios da transação
                // Campos: id, id_transacao, id_conta_criador, id_conta_repartidor, aprovado
            } else {
                JOptionPane.showMessageDialog(null, "Lista de contas para repartir o debito vazia! Adicione mais conta.", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
