/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference;

import com.core.enums.CurrencyId;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class Item implements Serializable{
    
    private String id;
    private String title;
    private String description;
    private String picture_url;
    private String category_id;
    private Integer quantity;
    private CurrencyId currency_id;
    private Float unit_price;

    public Item() {
    }

    public Item(String id, String title, String description, String picture_url, String category_id, Integer quantity, CurrencyId currency_id, Float unit_price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture_url = picture_url;
        this.category_id = category_id;
        this.quantity = quantity;
        this.currency_id = currency_id;
        this.unit_price = unit_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CurrencyId getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(CurrencyId currency_id) {
        this.currency_id = currency_id;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.description);
        hash = 73 * hash + Objects.hashCode(this.picture_url);
        hash = 73 * hash + Objects.hashCode(this.category_id);
        hash = 73 * hash + Objects.hashCode(this.quantity);
        hash = 73 * hash + Objects.hashCode(this.currency_id);
        hash = 73 * hash + Objects.hashCode(this.unit_price);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
