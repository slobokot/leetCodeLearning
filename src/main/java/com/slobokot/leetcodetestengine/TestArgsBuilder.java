package com.slobokot.leetcodetestengine;

import com.slobokot.leetcodetestengine.convertor.ParameterConverter;
import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

import java.lang.reflect.Array;

public class TestArgsBuilder {
    private final ParameterConverter parameterConverter;
    private final Class<?>[] parameterTypes;
    private final Class<?> resultType;
    private Object[] args;
    private int ptI;
    private Object result;
    private StringBuilder stringArgs;
    private int idx = 0;

    public TestArgsBuilder(ParameterConverter parameterConverter,
                           Class<?>[] parameterTypes,
                           Class<?> resultType) {
        this.parameterConverter = parameterConverter;
        this.parameterTypes = parameterTypes;
        this.resultType = resultType;
        init();
    }

    private void init() {
        args = new Object[parameterTypes.length];
        ptI = 0;
        result = null;
        stringArgs = new StringBuilder();
        idx++;
    }

    public void provideArg(PeekingIterator<Token> testFileIterator) throws Exception {
        args[ptI] = parameterConverter.convert(testFileIterator, parameterTypes[ptI]);
        stringArgs.append(toString(args[ptI])).append("\n");
        ptI++;
    }

    private String toString(Object o) {
        if (o != null && o.getClass().isArray()) {
            int size = Array.getLength(o);
            StringBuilder s = new StringBuilder();
            s.append("[");
            for(int i = 0; i < size; i++) {
                if (i > 0)
                    s.append(", ");
                s.append(toString(Array.get(o, i)));
            }
            s.append("]");
            return s.toString();
        } else {
            return String.valueOf(o);
        }
    }

    public void provideAnswer(PeekingIterator<Token> testFileIterator) throws Exception {
        if (result != null) throw new RuntimeException("Multiple results expected");
        result = parameterConverter.convert(testFileIterator, resultType);
    }

    public TestArgs build() {
        if (ptI != parameterTypes.length) throw new RuntimeException("Bad input");
        TestArgs x = new TestArgs(stringArgs.toString(),
                args,
                result,
                null,
                "test"+idx);
        init();
        return x;
    }
}
