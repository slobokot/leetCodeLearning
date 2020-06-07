package com.slobokot.leetcode.convertor;

import java.lang.reflect.Method;
import java.util.Optional;

public class StringParameterConvertor implements ParameterConvertor {
    @Override
    public Object convert(String value, Class<?> dstClass) throws Exception {
        return value.substring(1, value.length() - 1);
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return dstClass == String.class;
    }
}
