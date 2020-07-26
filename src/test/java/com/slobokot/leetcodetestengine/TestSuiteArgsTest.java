package com.slobokot.leetcodetestengine;

import com.slobokot.JarResources;
import com.slobokot.leetcodetestengine.parser.TestFileIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSuiteArgsTest {

    @Test
    public void test() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodeengine/TestSuiteArgs/twoDimArray.txt")));
        TestSuiteArgs suiteIterator = new TestSuiteArgs(iterator,
                TestRunner.getParameterConverter(),
                new Class[]{int[][].class},
                int.class);
        List<TestArgs> allTestArgs = suiteIterator.getAllTestArgs();
        TestArgs testArgs = allTestArgs.get(0);
        int[][] args = (int[][])testArgs.getArgs()[0];
        Assertions.assertEquals(3, args.length);
        Assertions.assertArrayEquals(new int[]{1,0,0,0}, args[0]);
        Assertions.assertArrayEquals(new int[]{0,0,0,0}, args[1]);
        Assertions.assertArrayEquals(new int[]{0,0,2,-1}, args[2]);
    }

}