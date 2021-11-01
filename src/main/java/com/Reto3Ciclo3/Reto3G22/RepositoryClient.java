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
public class RepositoryClient {
    @Autowired
    private InterfaceClient crud2;

    public List<ClientModel> getAll(){
        return (List<ClientModel>) crud2.findAll();
    }
    
    public Optional<ClientModel> getCliente(int id){
        return crud2.findById(id);
    }
    
    public ClientModel save(ClientModel cliente){
        return crud2.save(cliente);
    }
    
    public void delete(ClientModel cliente){
        crud2.delete(cliente);
    }
}
