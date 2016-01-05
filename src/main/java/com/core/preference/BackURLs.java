/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class BackURLs implements Serializable{
    private String failure;
    private String pending;
    private String success;

    public BackURLs() {
    }

    public BackURLs(String failure, String pending, String success) {
        this.failure = failure;
        this.pending = pending;
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.failure);
        hash = 59 * hash + Objects.hashCode(this.pending);
        hash = 59 * hash + Objects.hashCode(this.success);
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
        final BackURLs other = (BackURLs) obj;
        if (!Objects.equals(this.failure, other.failure)) {
            return false;
        }
        if (!Objects.equals(this.pending, other.pending)) {
            return false;
        }
        if (!Objects.equals(this.success, other.success)) {
            return false;
        }
        return true;
    }
    
    
}
