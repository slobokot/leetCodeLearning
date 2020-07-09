package com.slobokot.leetcodetestengine.convertor;

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
    public Object convert(String value, Class<?> dstClass) throws Exception {
        try {
            Iterator<String> it = new StringArrayIterator(value);
            List<Object> list = new ArrayList<>();
            while (it.hasNext()) {
                String current = it.next();
                list.add(mainConvertor.convert(current, dstClass.getComponentType()));
            }

            Object res = Array.newInstance(dstClass.getComponentType(), list.size());
            int i = 0;
            for (Object o : list) {
                Array.set(res, i++, o);
            }

            return res;
        } catch(Exception e) {
            throw new Exception("ArrayParameter conversion failed for string: " + value, e);
        }
    }

    @Override
    public boolean canConvert(Class<?> dstClass) throws Exception {
        return dstClass.isArray();
    }
}
