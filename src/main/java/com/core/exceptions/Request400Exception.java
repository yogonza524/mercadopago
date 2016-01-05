/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.exceptions;

import com.core.fail_request.Response400;

/**
 *
 * @author Gonza
 */
public class Request400Exception extends Exception{

    private Response400 response400;

    public Response400 getResponse400() {
        return response400;
    }

    public void setResponse400(Response400 response400) {
        this.response400 = response400;
    }
    
    public Request400Exception(String message) {
        super(message);
    }

    public Request400Exception(Response400 response400, String message) {
        super(message);
        this.response400 = response400;
    }
    
}
