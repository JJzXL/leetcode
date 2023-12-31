package pers.jjzxl.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * 示例1:
 * 输入:s = "III"
 * 输出: 3
 *
 * 示例2:
 * 输入:s = "IV"
 * 输出: 4
 *
 * 示例3:
 * 输入:s = "IX"
 * 输出: 9
 *
 * 示例4:
 * 输入:s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例5:
 * 输入:s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lixu
 * @date 2019/03/15
 */
public class Exercise13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static final Map<Character, Integer> MAP = new HashMap<>(16);
    static {
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < arr.length; i++){
            if (i < arr.length - 1) {
                if (MAP.get(arr[i]) < MAP.get(arr[i + 1])) {
                    num += (MAP.get(arr[i + 1]) - MAP.get(arr[i]));
                    i++;
                } else {
                    num += MAP.get(arr[i]);
                }
            } else {
                num += MAP.get(arr[i]);
            }
        }
        return num;
    }
}
