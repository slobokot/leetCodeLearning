package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class DominoAndTrominoTiling790Test {
    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                "com/slobokot/problems/dp/DominoAndTrominoTiling790.txt");
    }

    @Test
    public void leetCodeTest() throws Throwable {
        new TestRunner().runLeetCodeTest(
                "com/slobokot/problems/dp/DominoAndTrominoTiling790.txt", "test3");
    }
}