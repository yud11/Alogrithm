package leetcode.array.binarysearch;

/**
 * @autor yud1
 * @date 2022/10/25 16:15
 *
 * 题目描述：
 *        数组中相邻元素不相等，查找数组中的任意一个极小值
 * 解题思路：
 *        1，先判断左右端点是否符合情况，若符合情况直接返回。
 *        2，不符合极值条件时，则数组左边呈下降趋势，数组右边呈上升趋势，由于相邻元素不相等的条件
 *        则必存在极小值。
 *        3，利用二分法来寻找这个极小值，每次取中间值，判断该值是否为极小值，是，直接返回
 *        4，否，则左右必有一边存在极小值，继续二分，直到找到极小值
 *
 */
public class FindPeak {

    public Integer findPeak(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int len  = nums.length;
        if (len == 1){
            return nums[0];
        }

        if (nums[0] < nums[1]){
            return nums[0];
        }

        if(nums[len-1] < nums[len-2]){
            return nums[len-1];
        }
        int start = 0;
        int end = len-1;
        int mid = -1;
        while(start <= end){
            //mid = (start + end) >> 1; 可能会溢出
            mid = start + ((end - start) >> 1);
            //极值直接返回
            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            } else if (nums[mid] > nums[mid+1]){
                start = mid+1;
            }else if (nums[mid] > nums[mid-1]){
                end = mid-1;
            }
        }
        return null;
    }
}
