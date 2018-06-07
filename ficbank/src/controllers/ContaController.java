/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Model.Conta;
import Model.DAO.ContaDAO;
import javax.swing.JOptionPane;
import views.Dashboard;

/**
 *
 * @author kassia
 */
public class ContaController {
    private Conta conta;

    public ContaController(Conta conta) {
        this.conta = conta;
    }
    
    public boolean login(){
        ContaDAO dao = new ContaDAO();
        
        if(!login.isEmpty()){
            conta = (Conta) dao.getContaPorUser(conta.getUser());
            if(conta != null){
                if(checkLogin(conta.getUser(), conta.getSenha())){
                    DashboardController dash = new DashboardController(conta);
                    return dash.goToDashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Inválidos! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Inválido! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Login Inválido! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean checkLogin(String user, String senha){
        return user.equals(getConta().getUser()) && checkSenha(senha);
    }
    
    public boolean checkSenha(String senha){
        if(!senha.equals(getConta().getSenha())){
            JOptionPane.showMessageDialog(null, "Senha Inválida! Tente Novamente.", "Erro Login", JOptionPane.ERROR_MESSAGE);
        }
        return senha.equals(getConta().getSenha());
    }
    
    private Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta){
        this.conta = conta;
    }
}


/*


 private final CoursePanelForm panel;
    private final ImplementCourse implementCourse;
    private List<Course> list;
    
    public CourseController(CoursePanelForm panel) {
        this.panel = panel;
        implementCourse = new CourseDAO();
        list = implementCourse.getAllCourse();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelCourse().clearSelection();
    }
    
    public void setTabel(){
        list = implementCourse.getAllCourse();
        panel.getTabelCourse().setModel(new TabelModelCourse(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Course course = new Course();
        course.setName(panel.getTxtName().getText());
        implementCourse.insert(course);
    }

    public void update(){
        Course course = new Course();
        course.setId(Integer.parseInt(panel.getTxtId().getText()));
        course.setName(panel.getTxtName().getText());
        implementCourse.update(course);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCourse.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCourse.getCourseByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementCourse.getCourseByName(name);
        panel.getTabelCourse().setModel(new TabelModelCourse(list));
    }
*/