package com.slobokot.leetcode.convertor;

public interface ParameterConvertor {
    Object convert(String value, Class<?> dstClass) throws Exception;
    boolean canConvert(Class<?> dstClass) throws Exception;
}
