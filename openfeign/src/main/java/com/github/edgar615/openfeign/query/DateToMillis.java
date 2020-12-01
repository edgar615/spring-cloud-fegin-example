package com.github.edgar615.openfeign.query;

import feign.Param;

import java.util.Date;

public class DateToMillis implements Param.Expander {
    @Override
    public String expand(Object value) {
        if (value instanceof Date) {
            Date date = (Date) value;
            return  String.valueOf(date.getTime());
        }
        return null;
    }
}
