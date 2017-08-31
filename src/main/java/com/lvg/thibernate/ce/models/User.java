package com.lvg.thibernate.ce.models;

import com.lvg.thibernate.ce.Constants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Victor on 30.08.2017.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    protected String name;
    protected String secondName;


    protected Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIP_CODE", length = 5)),
            @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "country", column = @Column(name = "BILLING_COUNTRY"))

    })
    protected Address billingAddress;
}
