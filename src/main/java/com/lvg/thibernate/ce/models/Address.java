package com.lvg.thibernate.ce.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Victor on 30.08.2017.
 */
@Embeddable
public class Address {
    @NotNull
    @Column(nullable = false)
    protected String street;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "CITY", nullable = false))
    })
    protected City city;

    protected Address() {
    }

    public Address(String street, City city) {
        this.street = street;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
