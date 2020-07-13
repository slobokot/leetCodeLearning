package com.slobokot.problems.easy;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int e2 = findNonSpace(s, i);
        int b2 = findSpace(s, e2);
        return e2 - b2;
    }

    int findSpace(String s, int i) {
        for(; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
        }
        return i;
    }

    int findNonSpace(String s, int i) {
        for(; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                break;
        }
        return i;
    }
}

