package com.lvg.thibernate.ce.converter;

import com.lvg.thibernate.ce.models.advanced.MonetaryAmount;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Victor on 31.08.2017.
 */
@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        return monetaryAmount.toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String dbData) {
        return MonetaryAmount.fromString(dbData);
    }
}
