package com.slobokot.problems.medium;

import com.slobokot.leetcodetestengine.TestRunner;
import com.slobokot.problems.hard.NQueens51;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsII63Test {
    UniquePathsII63 x = new UniquePathsII63();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/medium/UniquePathsII63.txt");
    }
}