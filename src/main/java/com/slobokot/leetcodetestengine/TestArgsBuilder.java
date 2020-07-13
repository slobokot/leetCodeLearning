package com.slobokot.leetcodetestengine;

import com.slobokot.leetcodetestengine.convertor.ParameterConvertor;
import com.slobokot.leetcodetestengine.parser.PeekingIterator;
import com.slobokot.leetcodetestengine.parser.Token;

public class TestArgsBuilder {
    private final ParameterConvertor parameterConvertor;
    private final Class<?>[] parameterTypes;
    private final Class<?> resultType;
    private Object[] args;
    private int ptI;
    private Object result;
    private StringBuilder stringArgs;
    private int idx = 0;

    public TestArgsBuilder(ParameterConvertor parameterConvertor,
                           Class<?>[] parameterTypes,
                           Class<?> resultType) {
        this.parameterConvertor = parameterConvertor;
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
        args[ptI] = parameterConvertor.convert(testFileIterator, parameterTypes[ptI]);
        stringArgs.append(args[ptI]).append("\n");
        ptI++;
    }

    public void provideAnswer(PeekingIterator<Token> testFileIterator) throws Exception {
        if (result != null) throw new RuntimeException("Multiple results expected");
        result = parameterConvertor.convert(testFileIterator, resultType);
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
