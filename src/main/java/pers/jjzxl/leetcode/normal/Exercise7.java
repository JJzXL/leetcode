package pers.jjzxl.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author JJzXL
 * @date 2019/03/15
 */
public class Exercise7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(9896552));
    }

    public static int reverse(int x) {
        List<Long> list = new ArrayList<>();
        long xx = x;
        while (xx != 0) {
            list.add(xx % 10);
            xx /= 10;
        }
        long num = 0L;
        for (int i = 0, j = list.size(); i < list.size(); i ++, j--) {
            if (list.get(i) == 0 && i == 0) {
                continue;
            }
            num += (list.get(i) * (int) Math.pow(10, j - 1));
        }
        return num > Integer.MAX_VALUE || num < Integer.MIN_VALUE ? 0 : (int) num;
    }
}
