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
public class FailResponseBody implements Serializable{
    private String message;
    private String error;
    private Integer status;
    private Object causes;

    public FailResponseBody() {
    }

    public FailResponseBody(String message, String error, Integer status, Object causes) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.causes = causes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getCauses() {
        return causes;
    }

    public void setCauses(Object causes) {
        this.causes = causes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.error);
        hash = 67 * hash + Objects.hashCode(this.status);
        hash = 67 * hash + Objects.hashCode(this.causes);
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
        final FailResponseBody other = (FailResponseBody) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.error, other.error)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
    
    
}
