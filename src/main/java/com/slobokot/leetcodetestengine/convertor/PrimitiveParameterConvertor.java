package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.lang.reflect.Method;
import java.util.Objects;

public class PrimitiveParameterConvertor implements ParameterConvertor {
    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        Method valueOf = getNonPrimitive(dstClass).getMethod("valueOf", String.class);
        Token next = testFileIterator.next();
        Objects.requireNonNull(next.getValue(), next.toString());
        return valueOf.invoke(null, next.getValue());
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
