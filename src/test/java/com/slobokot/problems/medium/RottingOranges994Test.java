package com.slobokot.problems.medium;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class RottingOranges994Test {
    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                "com/slobokot/problems/medium/RottingOranges994.txt");
    }
}