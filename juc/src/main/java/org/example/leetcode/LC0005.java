package org.example.leetcode;

public class LC0005 {

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }


    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        boolean[][] flag = new boolean[s.length()][s.length()];
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag[i][j] = i - j <= 1 || flag[i - 1][j + 1];
                }
                if (flag[i][j] && i - j + 1 > maxLength) {
                    maxLength = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
