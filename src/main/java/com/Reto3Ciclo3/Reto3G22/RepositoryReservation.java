/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

import java.util.ArrayList;
import java.util.Date;
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
    
    public List<ReservationModel> ReservacionStatus (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<ReservationModel> ReservacionTiempo (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     }

     public List<ContadorCliente> getTopClientes(){
         List<ContadorCliente> res=new ArrayList<>();
         List<Object[]>report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size();i++){
             res.add(new ContadorCliente((Long)report.get(i)[1],(ClientModel) report.get(i)[0]));
         
         }
         return res;
     }
    
}
