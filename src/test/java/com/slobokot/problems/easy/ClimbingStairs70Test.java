package com.slobokot.problems.easy;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class ClimbingStairs70Test {
    ClimbingStairs70 x = new ClimbingStairs70();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/easy/ClimbingStairs70.txt");
    }
}