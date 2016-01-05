/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference_request;

import com.core.preference.Preference;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class SuccessPreferenceResponse extends Response implements Serializable{
    
    private String additional_info;
    private String auto_return;
    private Preference response;

    public SuccessPreferenceResponse() {
    }

    public SuccessPreferenceResponse(Integer status) {
        super(status);
    }

    public SuccessPreferenceResponse(String additional_info, String auto_return, Preference response, Integer status) {
        super(status);
        this.additional_info = additional_info;
        this.auto_return = auto_return;
        this.response = response;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getAuto_return() {
        return auto_return;
    }

    public void setAuto_return(String auto_return) {
        this.auto_return = auto_return;
    }

    public Preference getResponse() {
        return response;
    }

    public void setResponse(Preference response) {
        this.response = response;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.additional_info);
        hash = 97 * hash + Objects.hashCode(this.auto_return);
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
        final SuccessPreferenceResponse other = (SuccessPreferenceResponse) obj;
        if (!Objects.equals(this.additional_info, other.additional_info)) {
            return false;
        }
        if (!Objects.equals(this.auto_return, other.auto_return)) {
            return false;
        }
        if (!Objects.equals(this.response, other.response)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
