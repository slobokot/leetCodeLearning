package com.slobokot.problems.easy;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class PlusOne66Test {
    PlusOne66 x = new PlusOne66();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/easy/PlusOne66.txt");
    }
}