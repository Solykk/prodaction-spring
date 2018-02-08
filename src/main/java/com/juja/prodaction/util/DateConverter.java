package com.juja.prodaction.util;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Lyashenko
 */
@Component
public class DateConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        return Date.from(attribute.toInstant(ZoneOffset.UTC));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        return LocalDateTime.ofInstant(dbData.toInstant(), ZoneId.systemDefault());
    }
}
