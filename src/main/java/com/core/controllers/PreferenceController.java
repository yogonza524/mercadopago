/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.controllers;

import com.core.exceptions.Request400Exception;
import com.core.exceptions.Request404Exception;
import com.core.exceptions.UninitializedException;
import com.core.fail_request.Response400;
import com.core.preference.Item;
import com.core.preference.Preference;
import com.core.preference_request.FailResponse;
import com.core.preference_request.SuccessPreferenceResponse;
import com.core.util.MercadoPagoConnector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mercadopago.MP;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Gonza
 */
public class PreferenceController {

    public PreferenceController() {
    }
    
    public Preference byId(String id) throws UninitializedException, JSONException, Request404Exception, Exception{
        if (id != null) {
            MP m = MercadoPagoConnector.getInstance();
            JSONObject request = m.getPreference(id);
            if (request != null) {
                Gson g = new Gson();
                if (request.getInt("status") == 200) {
                    SuccessPreferenceResponse p = g.fromJson(request.toString(), SuccessPreferenceResponse.class);
                    return p.getResponse();
                }
                else{
                    if (request.getInt("status") == 404) {
                        throw new Request404Exception(g.fromJson(request.toString(), FailResponse.class), "Preference not found!");
                    }
                }
            }
        }
        return null;
    }
    
    public Preference addPreference(List<Item> preference) throws UninitializedException, Exception{
        Preference p = null;
        if (preference != null) {
            MP m = MercadoPagoConnector.getInstance();
            Gson g = new Gson();
            Type collectionType = new TypeToken<Collection<Item>>(){}.getType();
            String items = g.toJson(preference, collectionType);
            JSONObject request = m.createPreference("{'items':" + items + "}");
            if (request != null) {
                if (request.getInt("status") == 201) {
                    SuccessPreferenceResponse response = g.fromJson(request.toString(), SuccessPreferenceResponse.class);
                    return response.getResponse();
                }
                else{
                    if (request.getInt("status") == 404) {
                        throw new Request404Exception(g.fromJson(request.toString(), FailResponse.class), "Preference not found!");
                    }
                    else{
                        if (request.getInt("status") == 400) {
                            throw new Request400Exception(g.fromJson(request.toString(), Response400.class), "Error 400! Check it out");
                        }
                    }
                }
            }
        }
        return p;
    }
    
    public Preference updatePreference(String id, List<Item> preference) throws UninitializedException, JSONException, Request404Exception, Request400Exception, Exception{
        Preference p = null;
        if (preference != null && id != null && id.length() > 0) {
            MP m = MercadoPagoConnector.getInstance();
            Gson g = new Gson();
            Type collectionType = new TypeToken<Collection<Item>>(){}.getType();
            String items = g.toJson(preference, collectionType);
            JSONObject request = m.updatePreference(id,"{'items':" + items + "}");
            if (request != null) {
                if (request.getInt("status") == 200) {
                    SuccessPreferenceResponse response = g.fromJson(request.toString(), SuccessPreferenceResponse.class);
                    return response.getResponse();
                }
                else{
                    if (request.getInt("status") == 404) {
                        throw new Request404Exception(g.fromJson(request.toString(), FailResponse.class), "Preference not found!");
                    }
                    else{
                        if (request.getInt("status") == 400) {
                            throw new Request400Exception(g.fromJson(request.toString(), Response400.class), "Error 400! Check it out");
                        }
                    }
                }
            }
        }
        return p;
    }
}
