package pers.jjzxl.leetcode.easy;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author JJzXL
 * @date 2019/03/15
 */
public class Exercise14 {

    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String str1 = strs[0];
        String str2 = strs[1];
        int length = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return "";
        } else {
            String[] arrStr = new String[strs.length - 1];
            arrStr[0] = sb.toString();
            for (int i = 2, j = 1; i < strs.length; i ++, j ++) {
                arrStr[j] = strs[i];
            }
            return longestCommonPrefix(arrStr);
        }
    }
}
