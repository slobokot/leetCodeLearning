package com.slobokot.problems.dp;

public class LongestValidParentheses32_BruteForce {
    /**
     * time O(N^2)
     * space O(1)
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            int cur = getLongest(s, i);
            max = Math.max(cur, max);
        }
        return max;
    }

    int getLongest(String s, int i)
    {
        int prevLen = 0;
        int len = 0;
        int open = 0;
        for(; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
                len++;
            }
            else {
                open--;
                if (open > 0) {
                    len++;
                } else if (open == 0) {
                    len++;
                    prevLen = len;
                } else {
                    return prevLen;
                }
            }
        }

        return prevLen;
    }
}
