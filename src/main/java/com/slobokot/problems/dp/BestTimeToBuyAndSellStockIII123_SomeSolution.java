package com.slobokot.problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A better solution: https://www.youtube.com/watch?v=Pw6lrYANjz4 - Coding Interview Question - Max Profit With K Transactions
 */
public class BestTimeToBuyAndSellStockIII123_SomeSolution {
    Map<Integer, Map<Integer,Integer>>[] dp;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        List<Integer> peaks = removeDupsLeavePeaks(prices);

        if (peaks.size() < 2) return 0;

        dp = new Map[2];
        dp[0] = new HashMap<>();
        dp[1] = new HashMap<>();

        return profit(peaks, 0, -1, 0);
    }

    private List<Integer> removeDupsLeavePeaks(int[] prices) {
        List<Integer> nodups = new ArrayList<>();
        for (int price : prices) {
            if (nodups.isEmpty() || nodups.get(nodups.size()-1)!=price)
                nodups.add(price);
        }

        List<Integer> newPrices = new ArrayList<>();
        if (nodups.size() >= 2) {
            if (nodups.get(1) > nodups.get(0))
                newPrices.add(nodups.get(0));
            for (int i = 1; i < nodups.size() - 1; i++) {
                if (nodups.get(i - 1) > nodups.get(i) && nodups.get(i) < nodups.get(i + 1) ||
                        nodups.get(i - 1) < nodups.get(i) && nodups.get(i) > nodups.get(i + 1)) {
                    newPrices.add(nodups.get(i));
                }
            }
            if (nodups.get(nodups.size() - 2) < nodups.get(nodups.size() - 1))
                newPrices.add(nodups.get(nodups.size() - 1));
        }

        return newPrices;
    }

    private int profit(List<Integer> prices, int i, int boughtI, int transactions) {
        if (transactions >= 2 || i >= prices.size()) return 0;

        Map<Integer, Integer> dpp = dp[transactions].compute(i, (k, v) -> v == null ? new HashMap<>() : v);
        Integer res = dpp.get(boughtI);
        if (res != null) return res;

        int profit = 0;
        if (boughtI < 0) {
            // buy
            profit = profit(prices, i + 1, i, transactions);

            // not buy
            profit = Math.max(profit,
                    profit(prices, i + 1, boughtI, transactions));
        } else {
            // sell
            int possibleProfit = prices.get(i) - prices.get(boughtI);
            if (possibleProfit > 0) {
                profit = profit(prices, i + 1, -1, transactions + 1) + possibleProfit;
            }

            // keep
            profit = Math.max(profit, profit(prices, i + 1, boughtI, transactions));
        }
        dpp.put(boughtI, profit);
        return profit;
    }
}
