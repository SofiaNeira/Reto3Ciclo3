/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author raque
 */
public interface InterfaceClient extends CrudRepository<ClientModel, Integer> {
    
}