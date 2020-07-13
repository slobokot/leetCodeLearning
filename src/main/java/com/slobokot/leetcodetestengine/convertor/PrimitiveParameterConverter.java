package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;
import com.slobokot.leetcodetestengine.parser.TokenType;

import java.lang.reflect.Method;
import java.util.Objects;

public class PrimitiveParameterConverter implements ParameterConverter {
    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        Token next = testFileIterator.next();
        Objects.requireNonNull(next.getValue(), next.toString());
        if (dstClass == null)
            return Integer.valueOf(next.getValue());

        Method valueOf = getNonPrimitive(dstClass).getMethod("valueOf", String.class);
        return valueOf.invoke(null, next.getValue());
    }

    @Override
    public boolean canConvert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        if (dstClass == null) {
            return testFileIterator.peek().getType() == TokenType.NON_QUOTED_STRING;
        }

        return dstClass.isPrimitive();
    }

    private Class<?> getNonPrimitive(Class<?> primitive) {
        if (primitive == int.class) return Integer.class;
        if (primitive == long.class) return Long.class;
        throw new RuntimeException("Not implemented for " + primitive.getName());
    }
}
