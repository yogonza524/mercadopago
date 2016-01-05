/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.exceptions;

import com.core.preference_request.FailResponse;

/**
 *
 * @author Gonza
 */
public class Request404Exception extends Exception{

    private FailResponse requestResponse;
            
    public Request404Exception(String message) {
        super(message);
    }

    public Request404Exception(FailResponse response, String message) {
        super(message);
        this.requestResponse = response;
    }

    public FailResponse getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(FailResponse requestResponse) {
        this.requestResponse = requestResponse;
    }
    
}
