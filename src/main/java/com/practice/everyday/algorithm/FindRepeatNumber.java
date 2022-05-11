package com.practice.everyday.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ghm
 */
public class FindRepeatNumber {

    public Integer findRepeatNum(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            while (arrays[i] != i){
                if (arrays[i] == arrays[arrays[i]]){
                    return arrays[i];
                }
                swap(arrays, i, arrays[i]);
            }
            swap(arrays, i, arrays[i]);
        }
        return null;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
