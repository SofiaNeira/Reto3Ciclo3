/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto3Ciclo3.Reto3G22;

/**
 *
 * @author raque
 */
public class ContadorCliente {
    private Long total;
    private ClientModel client;

    public ContadorCliente(Long total, ClientModel client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    
    

}
