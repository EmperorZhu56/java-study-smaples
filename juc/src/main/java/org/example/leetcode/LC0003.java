package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

//滑动窗口
public class LC0003 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            var c = s.charAt(end);
            start = Math.max(start, map.getOrDefault(c, -1) + 1);
            res = Math.max(res, end - start + 1);
            map.put(c, end);
            end++;
        }
        return res;
    }
}
