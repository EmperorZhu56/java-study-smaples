package org.example.leetcode;


public class LC0008 {

    public static void main(String[] args) {
        String s = "-2147483647";
        int num = myAtoi(s);
        System.out.println(num);
    }


    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        var first = s.charAt(0);
        if ("+-0123456789".indexOf(first) == -1) {
            return 0;
        }
        int index = 1;
        while (index < s.length()) {
            var c = s.charAt(index++);
            if (c < 48 || c > 57) {
                index--;
                break;
            }
        }
        var substring = s.substring(first == '-' || first == '+' ? 1 : 0, index);
        int sum = 0;
        var num = first == '-' ? -1 : 1;
        for (int i = 0; i < substring.length(); i++) {
            var c = substring.charAt(substring.length() - 1 - i);
            sum += (c - 48) * Math.pow(10, i) * num;
        }
        return  sum;
    }
}
