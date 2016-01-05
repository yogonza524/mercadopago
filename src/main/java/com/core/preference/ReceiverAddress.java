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
public class ReceiverAddress implements Serializable{
    
    private String zip_code;
    private String street_name;
    private Integer street_number;
    private String floor;
    private String apartment;

    public ReceiverAddress() {
    }

    public ReceiverAddress(String zip_code, String street_name, Integer street_number, String floor, String apartment) {
        this.zip_code = zip_code;
        this.street_name = street_name;
        this.street_number = street_number;
        this.floor = floor;
        this.apartment = apartment;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.zip_code);
        hash = 67 * hash + Objects.hashCode(this.street_name);
        hash = 67 * hash + Objects.hashCode(this.street_number);
        hash = 67 * hash + Objects.hashCode(this.floor);
        hash = 67 * hash + Objects.hashCode(this.apartment);
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
        final ReceiverAddress other = (ReceiverAddress) obj;
        if (!Objects.equals(this.zip_code, other.zip_code)) {
            return false;
        }
        if (!Objects.equals(this.street_name, other.street_name)) {
            return false;
        }
        if (!Objects.equals(this.floor, other.floor)) {
            return false;
        }
        if (!Objects.equals(this.apartment, other.apartment)) {
            return false;
        }
        if (!Objects.equals(this.street_number, other.street_number)) {
            return false;
        }
        return true;
    }
    
    
}
