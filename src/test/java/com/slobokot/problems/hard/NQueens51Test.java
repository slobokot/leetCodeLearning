package com.slobokot.problems.hard;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class NQueens51Test {
    NQueens51 x = new NQueens51();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/hard/NQueens51.txt");
    }
}