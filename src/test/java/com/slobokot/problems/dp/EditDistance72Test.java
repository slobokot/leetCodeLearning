package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class EditDistance72Test {
    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                "com/slobokot/problems/dp/EditDistance72.txt");
    }
}