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
public class ServiceMessage {
    @Autowired
    private RepositoryMessage metodosCrud;

    public List<MessageModel> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<MessageModel> getMessage(int messageId) {
        return metodosCrud.getMensaje(messageId);
    }

    public MessageModel save(MessageModel message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<MessageModel> e= metodosCrud.getMensaje(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public MessageModel update(MessageModel message){
        if(message.getIdMessage()!=null){
            Optional<MessageModel> e= metodosCrud.getMensaje(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
