package com.slobokot.dp;

import com.slobokot.leetcode.TestRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;


class NumberOfDiceRollsWithTargetSum1155Test {
    NumberOfDiceRollsWithTargetSum1155 x = new NumberOfDiceRollsWithTargetSum1155();

    @TestFactory
    List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                x,
                "com/slobokot/dp/NumberOfDiceRollsWithTargetSum1155.txt");
    }

}