/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.util;

import com.core.exceptions.NoCredentialException;
import com.core.exceptions.Request400Exception;
import com.core.exceptions.UninitializedException;
import com.google.gson.Gson;
import com.mercadopago.MP;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonza
 */
public class MercadoPagoConnector {

    private static MP instance;
    private static String CLIENT_ID = "";
    private static String CLIENT_SECRET = "";
    
    private MercadoPagoConnector() {
    }
    
    public static void init(String CLIENT_ID, String CLIENT_SECRET) throws NoCredentialException, Request400Exception{
        if (CLIENT_ID == null || CLIENT_ID.length() == 0) {
            throw new NoCredentialException("Your CLIENT_ID is null or empty");
        }
        if (CLIENT_SECRET == null || CLIENT_SECRET.length() == 0) {
            throw new NoCredentialException("Your CLIENT_SECRET is null or empty");
        }
        instance = new MP(CLIENT_ID, CLIENT_SECRET);
        try {
            instance.getAccessToken();
        } catch (Exception ex) {
            Logger.getLogger(MercadoPagoConnector.class.getName()).log(Level.SEVERE, null, ex);
            Gson g = new Gson();
            throw new Request400Exception((g.fromJson(ex.getMessage(), Request400Exception.class)).getResponse400(), "Your credential are bad! You are not allowed to access to Mercado Pago API Rest");
        }
    }
    
    public static MP getInstance() throws UninitializedException{
        if (instance == null) {
            throw new UninitializedException("You may call the static method init(CLIENT_ID,CLIENT_SECRET) from this class first!");
        }
        return instance;
    }
}
