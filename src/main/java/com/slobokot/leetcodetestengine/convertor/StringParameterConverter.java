package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;
import com.slobokot.leetcodetestengine.parser.TokenType;

public class StringParameterConverter implements ParameterConverter {
    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        Token next = testFileIterator.next();
        return next.getValue();
    }

    @Override
    public boolean canConvert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        if (dstClass == null) {
            return testFileIterator.peek().getType() == TokenType.QUOTED_STRING;
        }

        return dstClass == String.class;
    }
}
