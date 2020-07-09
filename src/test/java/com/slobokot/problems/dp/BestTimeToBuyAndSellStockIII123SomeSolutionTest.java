package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class BestTimeToBuyAndSellStockIII123SomeSolutionTest {

    BestTimeToBuyAndSellStockIII123_SomeSolution x = new BestTimeToBuyAndSellStockIII123_SomeSolution();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/dp/BestTimeToBuyAndSellStockIII123.txt");
    }

    @Test
    public void leetCodeTest() throws Throwable {
        new TestRunner().runLeetCodeTest(x,
                "com/slobokot/problems/dp/BestTimeToBuyAndSellStockIII123.txt", "test8");
    }
}