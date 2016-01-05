/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference;

import com.core.enums.OperationType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class Preference implements Serializable{
    
    private List<Item> items;
    private Payer payer;
    private PaymentMethods payment_methods;
    private Shipments shipments;
    private BackURLs back_urls;
    private String notification_url;
    private String id;
    private String init_point;
    private String sandbox_init_point;
    private Date date_created;
    private OperationType operation_type;
    private String additional_info;
    private String external_reference;
    private Boolean expires;
    private Date expiration_date_from;
    private Date expiration_date_to;
    private String collector_id;
    private String marketplace;
    private Float marketplace_fee;

    public Preference() {
    }

    public Preference(List<Item> items, Payer payer, PaymentMethods payment_methods, Shipments shipments, BackURLs back_urls, String notification_url, String id, String init_point, String sandbox_init_point, Date date_created, OperationType operation_type, String additional_info, String external_reference, Boolean expires, Date expiration_date_from, Date expiration_date_to, String collector_id, String marketplace, Float marketplace_fee) {
        this.items = items;
        this.payer = payer;
        this.payment_methods = payment_methods;
        this.shipments = shipments;
        this.back_urls = back_urls;
        this.notification_url = notification_url;
        this.id = id;
        this.init_point = init_point;
        this.sandbox_init_point = sandbox_init_point;
        this.date_created = date_created;
        this.operation_type = operation_type;
        this.additional_info = additional_info;
        this.external_reference = external_reference;
        this.expires = expires;
        this.expiration_date_from = expiration_date_from;
        this.expiration_date_to = expiration_date_to;
        this.collector_id = collector_id;
        this.marketplace = marketplace;
        this.marketplace_fee = marketplace_fee;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public PaymentMethods getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(PaymentMethods payment_methods) {
        this.payment_methods = payment_methods;
    }

    public Shipments getShipments() {
        return shipments;
    }

    public void setShipments(Shipments shipments) {
        this.shipments = shipments;
    }

    public BackURLs getBack_urls() {
        return back_urls;
    }

    public void setBack_urls(BackURLs back_urls) {
        this.back_urls = back_urls;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInit_point() {
        return init_point;
    }

    public void setInit_point(String init_point) {
        this.init_point = init_point;
    }

    public String getSandbox_init_point() {
        return sandbox_init_point;
    }

    public void setSandbox_init_point(String sandbox_init_point) {
        this.sandbox_init_point = sandbox_init_point;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public OperationType getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(OperationType operation_type) {
        this.operation_type = operation_type;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(String external_reference) {
        this.external_reference = external_reference;
    }

    public Boolean getExpires() {
        return expires;
    }

    public void setExpires(Boolean expires) {
        this.expires = expires;
    }

    public Date getExpiration_date_from() {
        return expiration_date_from;
    }

    public void setExpiration_date_from(Date expiration_date_from) {
        this.expiration_date_from = expiration_date_from;
    }

    public Date getExpiration_date_to() {
        return expiration_date_to;
    }

    public void setExpiration_date_to(Date expiration_date_to) {
        this.expiration_date_to = expiration_date_to;
    }

    public String getCollector_id() {
        return collector_id;
    }

    public void setCollector_id(String collector_id) {
        this.collector_id = collector_id;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    public Float getMarketplace_fee() {
        return marketplace_fee;
    }

    public void setMarketplace_fee(Float marketplace_fee) {
        this.marketplace_fee = marketplace_fee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.items);
        hash = 97 * hash + Objects.hashCode(this.payer);
        hash = 97 * hash + Objects.hashCode(this.payment_methods);
        hash = 97 * hash + Objects.hashCode(this.shipments);
        hash = 97 * hash + Objects.hashCode(this.back_urls);
        hash = 97 * hash + Objects.hashCode(this.notification_url);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.init_point);
        hash = 97 * hash + Objects.hashCode(this.sandbox_init_point);
        hash = 97 * hash + Objects.hashCode(this.date_created);
        hash = 97 * hash + Objects.hashCode(this.operation_type);
        hash = 97 * hash + Objects.hashCode(this.additional_info);
        hash = 97 * hash + Objects.hashCode(this.external_reference);
        hash = 97 * hash + Objects.hashCode(this.expires);
        hash = 97 * hash + Objects.hashCode(this.expiration_date_from);
        hash = 97 * hash + Objects.hashCode(this.expiration_date_to);
        hash = 97 * hash + Objects.hashCode(this.collector_id);
        hash = 97 * hash + Objects.hashCode(this.marketplace);
        hash = 97 * hash + Objects.hashCode(this.marketplace_fee);
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
        final Preference other = (Preference) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.additional_info, other.additional_info)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        return true;
    }
    
    
}
