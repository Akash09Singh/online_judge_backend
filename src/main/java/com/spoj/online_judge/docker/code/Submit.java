package com.spoj.online_judge.docker.code;

import java.util.*;

class Submit {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[] {numToIndex.get(complement), i}; // Found the solution
            }

            // Add current number and index to the map
            numToIndex.put(nums[i], i);
        }

        // No solution found
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Submit solution = new Submit();
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();

            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            int target = scanner.nextInt();

            int[] result = solution.twoSum(nums, target);
            if (result.length == 2) {
                System.out.println("[" + result[0] + " " + result[1] + "]");
            } else {
                System.out.println("null");
            }
        }
    }
}
