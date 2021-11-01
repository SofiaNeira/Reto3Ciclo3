/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class ServiceSkate {
    @Autowired
    private RepositorySkate metodosCrud;

    public List<SkateModel> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<SkateModel> getSkate(int skateId) {
        return metodosCrud.getSkate(skateId);
    }

    public SkateModel save(SkateModel skate){
        if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<SkateModel> e=metodosCrud.getSkate(skate.getId());
            if(e.isEmpty()){
                return metodosCrud.save(skate);
            }else{
                return skate;
            }
        }
    }

    public SkateModel updateSkate(SkateModel skate){
        if(skate.getId()!=null){
            Optional<SkateModel> e=metodosCrud.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    e.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }


    public boolean deleteSkate(int skateId) {
        Boolean aBoolean = getSkate(skateId).map(skate -> {
            metodosCrud.delete(skate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
