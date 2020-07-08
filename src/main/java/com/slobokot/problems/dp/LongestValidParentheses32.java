package com.slobokot.problems.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestValidParentheses32 {

    /**
     * time O(1)
     * space O(1)
     */
    public int longestValidParentheses(String s) {
        LinkedList<Integer> open = new LinkedList<>();
        int max = 0;
        List<Integer> prevLen = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.addLast(i);
                if (prevLen.size() < open.size())
                    prevLen.add(0);
            }
            else {
                if (!open.isEmpty()) {
                    int start = open.removeLast();
                    int cursize = i - start + 1;
                    cursize += prevLen.get(open.size());
                    prevLen.set(open.size(), cursize);
                    max = Math.max(max, cursize);
                    if (open.size() + 1 < prevLen.size())
                        prevLen.remove(prevLen.size() - 1);
                } else if (!prevLen.isEmpty()) {
                    prevLen.clear();
                }
            }
        }
        return max;
    }
}
