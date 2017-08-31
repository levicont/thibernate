package com.lvg.thibernate.ce.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Victor on 31.08.2017.
 */

@Embeddable
public class City {

    @NotNull
    @Column(nullable = false)
    protected String name;
    @NotNull
    @Column(nullable = false, length = 5)
    protected String zipcode;

    @NotNull
    @Column(nullable = false)
    protected String country;
}
