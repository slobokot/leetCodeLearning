package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class ChainConverter implements ParameterConverter {

    List<ParameterConverter> converters = new ArrayList<>();

    public ChainConverter() {
    }

    public ChainConverter add(ParameterConverter convertor) {
        converters.add(convertor);
        return this;
    }

    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        for (ParameterConverter converter : converters) {
            if (converter.canConvert(testFileIterator, dstClass))
                return converter.convert(testFileIterator, dstClass);
        }

        throw new RuntimeException("Can not convert '" + testFileIterator + "' to " + dstClass.getName());
    }

    @Override
    public boolean canConvert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        return true;
    }
}
