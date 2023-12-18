package org.example.leetcode;

//滑动窗口
public class LC0209 {

    public static void main(String[] args) {
        int target = 11;
        int nums[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int length = minSubArrayLen(target, nums);
        System.out.println(length);
    }


    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums.length + 1;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end++ < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start++];
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }
}
