/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.preference;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gonza
 */
public class PaymentMethods implements Serializable{
    
    private List<ExcludedPaymentMethods> excluded_payment_methods;
    private List<ExcludedPaymentTypes> excluded_payment_types;
    private String default_payment_method_id;
    private Integer installments;
    private Integer default_installments;

    public PaymentMethods() {
    }

    public PaymentMethods(List<ExcludedPaymentMethods> excluded_payment_methods, List<ExcludedPaymentTypes> excluded_payment_types, String default_payment_method_id, Integer installments, Integer default_installments) {
        this.excluded_payment_methods = excluded_payment_methods;
        this.excluded_payment_types = excluded_payment_types;
        this.default_payment_method_id = default_payment_method_id;
        this.installments = installments;
        this.default_installments = default_installments;
    }

    public List<ExcludedPaymentMethods> getExcluded_payment_methods() {
        return excluded_payment_methods;
    }

    public void setExcluded_payment_methods(List<ExcludedPaymentMethods> excluded_payment_methods) {
        this.excluded_payment_methods = excluded_payment_methods;
    }
    

    public List<ExcludedPaymentTypes> getExcluded_payment_types() {
        return excluded_payment_types;
    }

    public void setExcluded_payment_types(List<ExcludedPaymentTypes> excluded_payment_types) {
        this.excluded_payment_types = excluded_payment_types;
    }

    public String getDefault_payment_method_id() {
        return default_payment_method_id;
    }

    public void setDefault_payment_method_id(String default_payment_method_id) {
        this.default_payment_method_id = default_payment_method_id;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getDefault_installments() {
        return default_installments;
    }

    public void setDefault_installments(Integer default_installments) {
        this.default_installments = default_installments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.excluded_payment_methods);
        hash = 23 * hash + Objects.hashCode(this.excluded_payment_types);
        hash = 23 * hash + Objects.hashCode(this.default_payment_method_id);
        hash = 23 * hash + Objects.hashCode(this.installments);
        hash = 23 * hash + Objects.hashCode(this.default_installments);
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
        final PaymentMethods other = (PaymentMethods) obj;
        if (!Objects.equals(this.default_payment_method_id, other.default_payment_method_id)) {
            return false;
        }
        if (!Objects.equals(this.excluded_payment_methods, other.excluded_payment_methods)) {
            return false;
        }
        if (!Objects.equals(this.excluded_payment_types, other.excluded_payment_types)) {
            return false;
        }
        if (!Objects.equals(this.installments, other.installments)) {
            return false;
        }
        if (!Objects.equals(this.default_installments, other.default_installments)) {
            return false;
        }
        return true;
    }
    
    
}
