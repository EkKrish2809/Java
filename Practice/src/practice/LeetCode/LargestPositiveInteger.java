package practice.LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LargestPositiveInteger {

    public static int findMaxK0(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i : nums)
        {
            numList.add(i);
        }

        List<Integer> posNegList = new ArrayList<>();
        for (Integer ini : numList){
            if (numList.contains(ini) && numList.contains(-ini))
            {
                posNegList.add(ini);
            }
        }

        Integer maxNum = !posNegList.isEmpty() ? Collections.max(posNegList) : -1;
        
        return maxNum;
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = len-1; i >=0 ; i--)
        {
            if (nums[i] > 0 && Arrays.binarySearch(nums, -nums[i]) >= 0)
            {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = {-1,2,-3,3};
        int[] nums = {-1,10,6,7,-7,1};
        // int[] nums = {-10,8,6,7,-2,-3};
        // int[] nums = {-1,2,-3,3};

        System.out.println("Max Num with positive and negative counterpart is : "+findMaxK(nums));
    }
}
