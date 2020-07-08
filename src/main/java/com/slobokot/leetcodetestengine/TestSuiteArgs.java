package com.slobokot.leetcodetestengine;

import com.slobokot.leetcodetestengine.convertor.ParameterConvertor;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteArgs {
    private final TestArgsBuilder testArgsBuilder;
    private final List<String> lines;

    public TestSuiteArgs(List<String> lines,
                         ParameterConvertor parameterConvertor,
                         Class<?>[] parameterTypes,
                         Class<?> resultType) {
        this.lines = lines;
        testArgsBuilder = new TestArgsBuilder( parameterConvertor,
                parameterTypes,
                resultType);
    }

    public List<TestArgs> getAllTestArgs() throws Exception {
        List<TestArgs> result = new ArrayList<>();
        int i = 0;
        while(true) {
            while (i < lines.size() && lines.get(i).trim().isEmpty()) i++;
            if (i == lines.size()) break;

            while (i < lines.size()) {
                String trim = lines.get(i).trim();
                if (trim.isEmpty())
                    break;
                testArgsBuilder.provide(trim);
                i++;
            }

            result.add(testArgsBuilder.build());
        }

        return result;
    }
}
