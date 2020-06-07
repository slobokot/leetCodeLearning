package com.slobokot.leetcode;

import java.util.List;

public class TestArgs {

    private final Object[] args;
    private final Object result;
    private final String meta;
    private final String stringArgs;
    private String name;

    public TestArgs(String stringArgs,
                    Object[] args,
                    Object result,
                    String meta,
                    String name) {
        this.args = args;
        this.result = result;
        this.meta = meta;
        this.stringArgs = stringArgs;
        this.name = name;
    }

    public Object getResult () {
        return result;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getStringArgs() {
        return stringArgs;
    }

    public String getName() {
        return name;
    }
}
