/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raque
 */
@Repository
public class RepositoryCategory {
    @Autowired
    private InterfaceCategory crud;
    
    public List<CategoryModel> getAll(){
        return (List<CategoryModel>) crud.findAll();
    }
    public Optional<CategoryModel> getCategoria(int id){
        return crud.findById(id);
    }

    public CategoryModel save(CategoryModel Categoria){
        return crud.save(Categoria);
    }
    public void delete(CategoryModel Categoria){
       crud.delete(Categoria);
    }
}
