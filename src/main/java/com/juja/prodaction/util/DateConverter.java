package com.juja.prodaction.util;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Lyashenko
 */
@Component
public class DateConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        return Date.valueOf(attribute.toLocalDate());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        return dbData.toLocalDate().atStartOfDay();
    }
}
