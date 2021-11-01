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
public class RepositoryReservation {
    @Autowired
    private InterfaceReservation crud4;
    
    public List<ReservationModel> getAll(){
        return (List<ReservationModel>) crud4.findAll();
    }
    
    public Optional<ReservationModel> getReservaciones(int id){
        return crud4.findById(id);
    }
    
    public ReservationModel save(ReservationModel reservacion){
        return crud4.save(reservacion);
    }
    
    public void delete(ReservationModel reservacion){
        crud4.delete(reservacion);
    }
    
}
