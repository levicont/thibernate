package com.lvg.thibernate.ce.models.advanced;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Victor on 31.08.2017.
 */
public class MonetaryAmount implements Serializable {

    protected final BigDecimal value;
    protected final Currency currency;

    public MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final MonetaryAmount that = (MonetaryAmount) o;

        if (!currency.equals(that.currency)) return false;
        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getValue()+" "+getCurrency();
    }

    public static MonetaryAmount fromString(String str){
        String[] split = str.split(" ");
        return new MonetaryAmount(new BigDecimal(split[0]), Currency.getInstance(split[1]));
    }
}
