package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

public class StringParameterConvertor implements ParameterConvertor {
    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        Token next = testFileIterator.next();
        return next.getValue();
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return dstClass == String.class;
    }
}
