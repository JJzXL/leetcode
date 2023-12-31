package pers.jjzxl.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author JJzXL
 * @date 2019/01/30
 */
public class Exercise1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{1, 5, -2, 6, 8, 12, 1}, 2)));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i< nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.get(sum) != null && map.get(sum) != i) {
                result[0] = map.get(sum);
                result[1] = i;
            }
        }
        return result;
    }
}
