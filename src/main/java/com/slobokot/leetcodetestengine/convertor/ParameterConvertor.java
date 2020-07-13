package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

public interface ParameterConvertor {
    Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception;
    boolean canConvert(Class<?> dstClass) throws Exception;
}
