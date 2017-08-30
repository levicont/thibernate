package com.lvg.thibernate.ce.models;

import com.lvg.thibernate.ce.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
}
