/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference_request;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class FailResponse extends Response implements Serializable{

    private FailResponseBody response;

    public FailResponse() {
    } 

    public FailResponse(Integer status) {
        super(status);
    }
    

    public FailResponse(FailResponseBody response) {
        this.response = response;
    }

    public FailResponseBody getResponse() {
        return response;
    }

    public void setResponse(FailResponseBody response) {
        this.response = response;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.response);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FailResponse other = (FailResponse) obj;
        if (!Objects.equals(this.response, other.response)) {
            return false;
        }
        return true;
    }
    
    
    
}
