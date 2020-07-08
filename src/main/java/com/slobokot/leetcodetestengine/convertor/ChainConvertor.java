package com.slobokot.leetcodetestengine.convertor;

import java.util.ArrayList;
import java.util.List;

public class ChainConvertor implements ParameterConvertor {

    List<ParameterConvertor> convertors= new ArrayList<>();

    public ChainConvertor() {
    }

    public ChainConvertor add(ParameterConvertor convertor) {
        convertors.add(convertor);
        return this;
    }

    @Override
    public Object convert(String value, Class<?> dstClass) throws Exception {
        for (ParameterConvertor convertor : convertors) {
            if (convertor.canConvert(dstClass))
                return convertor.convert(value, dstClass);
        }

        throw new RuntimeException("Can not convert '" + value + "' to " + dstClass.getName());
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return true;
    }
}
