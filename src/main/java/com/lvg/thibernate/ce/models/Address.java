package com.lvg.thibernate.ce.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Victor on 30.08.2017.
 */
@Embeddable
public class Address {

    @NotNull
    @Column(nullable = false)
    protected String city;

    @NotNull
    @Column(nullable = false, length = 5)
    protected String zipCode;

    @NotNull
    @Column(nullable = false)
    protected String street;

    protected Address() {
    }

    public Address(String city, String zipCode, String street) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
