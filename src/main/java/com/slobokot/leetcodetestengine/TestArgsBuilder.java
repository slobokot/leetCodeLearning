package com.slobokot.leetcodetestengine;

import com.slobokot.leetcodetestengine.convertor.ParameterConvertor;

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

    public void provide(String value) throws Exception {
        if (value.startsWith(":")) return;
        if (value.startsWith("=")) {
            if (result != null) throw new RuntimeException("Multiple results expected");
            result = parameterConvertor.convert(value.substring(1), resultType);
            return;
        }

        stringArgs.append(value).append("\n");
        args[ptI] = parameterConvertor.convert(value, parameterTypes[ptI]);
        ptI++;
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
