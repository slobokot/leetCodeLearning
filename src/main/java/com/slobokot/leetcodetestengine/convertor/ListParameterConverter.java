package com.slobokot.leetcodetestengine.convertor;

import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class ListParameterConverter implements ParameterConverter {
    private final ParameterConverter mainConvertor;

    public ListParameterConverter(ParameterConverter mainConvertor) {
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

                list.add(mainConvertor.convert(testFileIterator, null));
            }

            return list;
        } catch(Exception e) {
            throw new Exception("ArrayParameter conversion failed for string: " + testFileIterator, e);
        }
    }

    @Override
    public boolean canConvert(PeekingIterator<Token> testFileIterator, Class<?> dstClass) throws Exception {
        if (dstClass == null) {
            return testFileIterator.peek() == Token.ARRAY_START;
        }

        return List.class.isAssignableFrom(dstClass);
    }
}
