/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class ServiceReservation {
    @Autowired
    private RepositoryReservation metodosCrud;

    public List<ReservationModel> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ReservationModel> getReservation(int reservationId) {
        return metodosCrud.getReservaciones(reservationId);
    }

    public ReservationModel save(ReservationModel reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<ReservationModel> e= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public ReservationModel update(ReservationModel reservation){
        if(reservation.getIdReservation()!=null){
            Optional<ReservationModel> e= metodosCrud.getReservaciones(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    public StatusReservas getReporteStatusReservaciones(){
        List<ReservationModel>completed= metodosCrud.ReservacionStatus("completed");
        List<ReservationModel>cancelled= metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<ReservationModel> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
   
    public List<ContadorCliente> servicioTopClientes(){
        return metodosCrud.getTopClientes();
    }
}
