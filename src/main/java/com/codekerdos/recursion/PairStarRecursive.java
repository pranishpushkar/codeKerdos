package com.codekerdos.recursion;

public class PairStarRecursive {

    public static String appendStarRecursive(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return helper(s, 0, s.length() - 1);
    }

    private static String helper(String s, int left, int right) {

        if (left == right) {
            return "" + s.charAt(left);
        }

        if (s.charAt(left) == s.charAt(left + 1)) {
            return s.charAt(left) + "*" + helper(s, left + 1, right);
        } else {
            return s.charAt(left) + helper(s, left + 1, right);
        }
    }
}
