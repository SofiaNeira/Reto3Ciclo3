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
public class RepositoryMessage {
    @Autowired
    private InterfaceMessage crud3;
    
    public List<MessageModel> getAll(){
        return (List<MessageModel>) crud3.findAll();
    }
    
    public Optional<MessageModel> getMensaje(int id){
        return crud3.findById(id);
    }
    
    public MessageModel save(MessageModel mensaje){
        return crud3.save(mensaje);
    }
    
    public void delete(MessageModel mensaje){
        crud3.delete(mensaje);
    }
}
