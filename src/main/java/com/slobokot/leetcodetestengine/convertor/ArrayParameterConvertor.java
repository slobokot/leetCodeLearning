package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayParameterConvertor implements ParameterConvertor {
    private final ParameterConvertor mainConvertor;

    public ArrayParameterConvertor(ParameterConvertor mainConvertor) {
        this.mainConvertor = mainConvertor;
    }

    @Override
    public Object convert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        try {
            Token next = testFileIterator.next();
            if (next != Token.ARRAY_START) throw new RuntimeException("Expected array start, got " + next);

            List<Object> list = new ArrayList<>();
            while (true) {
                next = testFileIterator.peek();
                if (next == Token.ARRAY_END) {
                    testFileIterator.next();
                    break;
                }
                if (next == Token.NEW_LINE || next == Token.SEPARATOR) {
                    testFileIterator.next();
                    continue;
                }

                list.add(mainConvertor.convert(testFileIterator, dstClass.getComponentType()));
            }

            Object res = Array.newInstance(dstClass.getComponentType(), list.size());
            int i = 0;
            for (Object o : list) {
                Array.set(res, i++, o);
            }

            return res;
        } catch(Exception e) {
            throw new Exception("ArrayParameter conversion failed for string: " + testFileIterator, e);
        }
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return dstClass.isArray();
    }
}
