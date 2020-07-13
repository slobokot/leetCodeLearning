package com.slobokot.leetcodetestengine;

import com.slobokot.leetcodetestengine.convertor.ParameterConverter;
import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestSuiteArgs {
    private final TestArgsBuilder testArgsBuilder;
    private final PeekingIterator<Token> testFileIterator;

    public TestSuiteArgs(Iterator<Token> testFileIterator,
                         ParameterConverter parameterConverter,
                         Class<?>[] parameterTypes,
                         Class<?> resultType) {
        this.testFileIterator = new PeekingIterator<>(testFileIterator);
        testArgsBuilder = new TestArgsBuilder(parameterConverter,
                parameterTypes,
                resultType);
    }

    public List<TestArgs> getAllTestArgs() throws Exception {
        List<TestArgs> result = new ArrayList<>();
        int i = 0;
        while(true) {
            if (!testFileIterator.hasNext()) break;
            while(true) {
                if (testFileIterator.peek() == Token.ANSWER) {
                    testFileIterator.next();
                    testArgsBuilder.provideAnswer(testFileIterator);
                    break;
                }

                testArgsBuilder.provideArg(testFileIterator);
                if (testFileIterator.next() != Token.NEW_LINE) throw new RuntimeException("New line expected " + testFileIterator);
            }

            result.add(testArgsBuilder.build());
            while(testFileIterator.peek() == Token.NEW_LINE)
                testFileIterator.next();
        }

        return result;
    }
}
