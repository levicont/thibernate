package com.lvg.thibernate.ce.models;

import com.lvg.thibernate.ce.Constants;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Victor on 29.08.2017.
 */
@Entity
@Table(name = "BIDS")
@Immutable
public class Bid {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    protected Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
