/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping;

/**
 *
 * @author Admin
 */
public class ExternalClient {
    
    
    
    public String loadDatabase(String url) {
        
        /*
        Seria feito um GET request para o cliente externo de modo a obter os dados
        do parque de campismo, nomeadamente os seus "Places" (Tendas, etc.) 
        
        Exemplo de output:
        
        <places>
            <place>
                <id>0</id>
                ...
            </place>
            <place>
                <id>1</id>
                ...
            </place>
        </places>
        
        */
        
        return "";
    }
    
    public boolean addReservation(String url, User user, Place place) {
        
        /*
        Seria feito um POST request para a plataforma de modo a registar
        a reserva efetuada por um campista; esta reserva será também guardada
        na base de dados do cliente
        
        Exemplo de uma reservation enviada/guardada:
        
        <reservation>
            <id>
                23
            </id>
            <place_id>
                78
            </place_id>
            <start_date>
                ...
            </start_date>
            <finish_date>
                ...
            </finish_date>
            <people>
                ...
            </people>
            <user>
                ...
            </user>
        </reservation>
        
        */
                
        return true;
    }
    
}
