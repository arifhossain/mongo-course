package leetcode;/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.
*/


import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public int majorityElement(int[] nums) {
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts.computeIfPresent(String.valueOf(nums[i]), (key, val) -> val + 1);
            counts.putIfAbsent(String.valueOf(nums[i]), 1);
        }

        return Integer.parseInt(counts.entrySet().stream()
                .filter(entry -> entry.getValue() >= nums.length/2 + 1)
                .findFirst()
                .get()
                .getKey());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,3,2,1,1,1,1};

        Problem169 solution = new Problem169();
        System.out.println("Majority Element: " + solution.majorityElement(nums));
    }
}
