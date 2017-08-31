package com.lvg.thibernate.ce.models;


import com.lvg.thibernate.ce.Constants;
import com.lvg.thibernate.ce.converter.MonetaryAmountConverter;
import com.lvg.thibernate.ce.models.advanced.MonetaryAmount;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable{

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
    protected String name;
    protected Date auctionEnd;

    @NotNull
    @Convert(converter = MonetaryAmountConverter.class, disableConversion = false)
    @Column(name = "PRICE", length = 64)
    protected MonetaryAmount buyNowPrice;

    protected Set<Bid> bids = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    private void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void addBid(Bid bid){
        if ( bid == null)
            throw new NullPointerException("Bid must not be null");
        if (bid.getItem() != null)
            throw new IllegalArgumentException("Item already assigned to bid");
        getBids().add(bid);
        bid.setItem(this);
    }

    public void removeBid(Bid bid){
        if ( bid == null)
            throw new NullPointerException("Bid must not be null");
        if (!bid.getItem().equals(this))
            throw new IllegalArgumentException("Bid has wrong Item");
        getBids().remove(bid);
    }
}
