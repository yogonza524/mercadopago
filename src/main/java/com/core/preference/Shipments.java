/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference;

import com.core.enums.ShipmentsMode;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class Shipments implements Serializable{
    
    private ShipmentsMode mode;
    private Boolean local_pickup;
    private String dimensions;
    private Integer default_shipping_method;
    private List<FreeMethod> free_methods;
    private Float cost;
    private Boolean free_shipping;
    private ReceiverAddress receiver_address;

    public Shipments() {
    }

    public Shipments(ShipmentsMode mode, Boolean local_pickup, String dimensions, Integer default_shipping_method, List<FreeMethod> free_methods, Float cost, Boolean free_shipping, ReceiverAddress receiver_address) {
        this.mode = mode;
        this.local_pickup = local_pickup;
        this.dimensions = dimensions;
        this.default_shipping_method = default_shipping_method;
        this.free_methods = free_methods;
        this.cost = cost;
        this.free_shipping = free_shipping;
        this.receiver_address = receiver_address;
    }

    public ShipmentsMode getMode() {
        return mode;
    }

    public void setMode(ShipmentsMode mode) {
        this.mode = mode;
    }

    public Boolean getLocal_pickup() {
        return local_pickup;
    }

    public void setLocal_pickup(Boolean local_pickup) {
        this.local_pickup = local_pickup;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Integer getDefault_shipping_method() {
        return default_shipping_method;
    }

    public void setDefault_shipping_method(Integer default_shipping_method) {
        this.default_shipping_method = default_shipping_method;
    }

    public List<FreeMethod> getFree_methods() {
        return free_methods;
    }

    public void setFree_methods(List<FreeMethod> free_methods) {
        this.free_methods = free_methods;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Boolean getFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(Boolean free_shipping) {
        this.free_shipping = free_shipping;
    }

    public ReceiverAddress getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(ReceiverAddress receiver_address) {
        this.receiver_address = receiver_address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.mode);
        hash = 59 * hash + Objects.hashCode(this.local_pickup);
        hash = 59 * hash + Objects.hashCode(this.dimensions);
        hash = 59 * hash + Objects.hashCode(this.default_shipping_method);
        hash = 59 * hash + Objects.hashCode(this.free_methods);
        hash = 59 * hash + Objects.hashCode(this.cost);
        hash = 59 * hash + Objects.hashCode(this.free_shipping);
        hash = 59 * hash + Objects.hashCode(this.receiver_address);
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
        final Shipments other = (Shipments) obj;
        if (!Objects.equals(this.mode, other.mode)) {
            return false;
        }
        if (!Objects.equals(this.dimensions, other.dimensions)) {
            return false;
        }
        if (!Objects.equals(this.local_pickup, other.local_pickup)) {
            return false;
        }
        if (!Objects.equals(this.default_shipping_method, other.default_shipping_method)) {
            return false;
        }
        if (!Objects.equals(this.free_methods, other.free_methods)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.free_shipping, other.free_shipping)) {
            return false;
        }
        if (!Objects.equals(this.receiver_address, other.receiver_address)) {
            return false;
        }
        return true;
    }
    
    
}
