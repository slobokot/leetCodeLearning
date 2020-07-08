package com.slobokot.leetcodetestengine.convertor;

import java.lang.reflect.Method;

public class PrimitiveParameterConvertor implements ParameterConvertor {
    @Override
    public Object convert(String value, Class<?> dstClass) throws Exception {
        Method valueOf = getNonPrimitive(dstClass).getMethod("valueOf", String.class);
        return valueOf.invoke(null, value);
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return dstClass.isPrimitive();
    }

    private Class<?> getNonPrimitive(Class<?> primitive) {
        if (primitive == int.class) return Integer.class;
        if (primitive == long.class) return Long.class;
        throw new RuntimeException("Not implemented for " + primitive.getName());
    }
}
