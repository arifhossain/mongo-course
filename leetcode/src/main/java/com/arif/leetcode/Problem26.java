package com.arif.leetcode;

public class Problem26 {

    public int removeDuplicates(int[] nums) {
        int unique = 0;
        int runner = 1;

        while (runner < nums.length) {
            if(nums[unique] != nums[runner]) {
                unique++;
                nums[unique] = nums[runner];
                runner++;
            } else {
                runner++;
            }
        }

        return unique + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3,4,4,5};

        System.out.println(new Problem26().removeDuplicates(nums));
    }
}
