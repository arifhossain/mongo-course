package com.arif.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */

public class Problem14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String start = getSmallest(strs);
        String common = start;
        for (int i = 0; i < strs.length; i++) {
            common = getCommonPrefix(common, strs[i]);
        }

        return common;
    }

    private String getCommonPrefix(String sOne, String sTwo) {
        String common = "";
        int smaller = sOne.length() < sTwo.length() ? sOne.length() : sTwo.length();

        for (int i = 0; i < smaller; i++) {
            if (sOne.charAt(i) != sTwo.charAt(i)) {
                break;
            }
            common = common + sOne.charAt(i);
        }

        return common;
    }

    private String getSmallest(String[] strs) {
        String smallest = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < smallest.length()) {
                smallest = strs[i];
            }
        }

        return  smallest;
    }

    public static void main(String[] args) {
        Problem14 solution = new Problem14();

//        String[] strArray = new String[]{"flower", "flow", "flight"};
        String[] strArray = new String[]{"dog","racecar","car"};
        System.out.println("Prefix: " + solution.longestCommonPrefix(strArray));
    }

}
