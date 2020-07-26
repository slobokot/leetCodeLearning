package com.slobokot.problems.easy;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int i = digits.length - 1;
        while(i >= 0 && c == 1) {
            if (digits[i] == 9) {
                c = 1;
                digits[i] = 0;
            } else {
                c = 0;
                digits[i] ++;
            }
            i--;
        }
        if (c == 1) {
            int[] x = new int[digits.length+1];
            for(i = 0; i < digits.length; i++)
                x[i+1] = digits[i];
            x[0] = 1;
            digits = x;
        }
        return digits;
    }
}
