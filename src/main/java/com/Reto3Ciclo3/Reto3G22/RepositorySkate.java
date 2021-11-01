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
public class RepositorySkate {
    @Autowired
    
    private InterfaceSkate crud;

    public List<SkateModel> getAll(){
        return (List<SkateModel>) crud.findAll();
    }
    
    public Optional<SkateModel> getSkate(int id){
        return crud.findById(id);
    }
    
    public SkateModel save(SkateModel skate){
        return crud.save(skate);
    }
    
    public void delete(SkateModel skate){
        crud.delete(skate);
    }
    
    
}
