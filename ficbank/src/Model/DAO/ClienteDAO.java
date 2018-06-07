/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBaseGeneric;
import Model.Cliente;
import Model.Interfaces.ImplementCliente;
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
        super(new ConfigurationsMySQL(), "FIKBANK");
    }
    
    @Override
    public void insert(Cliente cliente){
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("name", cliente.getName());
        mapObj.put("telefone", cliente.getTelefone());
        
        
        this.genericInsert(mapObj);
    }
    
    public void update(Cliente cliente);
    
    public void delete(int id);
    
    public List<Cliente> getClientePorNome(String nome);
    
    public List<Cliente> getAllCliente();
    
    public Cliente getUmCliente(int id);
    /*

    @Override
    public void update(Course course){
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("name", course.getName());
        mapConditions.put("id", course.getId());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Course> getCourseByName(String name){
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) { 
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex){
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse(){
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public Course getOneCourse(int id){
        ResultSet rs = this.getOne(id);
        Course course = new Course();
        try {
            course.setId(rs.getInt(1));
            course.setName(rs.getString("name"));
            return course;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo id: " + ex.getMessage());
        }
        return null;
    }
}

    
    
    
    */
}
