package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

public interface ParameterConverter {
    Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception;
    boolean canConvert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception;
}
