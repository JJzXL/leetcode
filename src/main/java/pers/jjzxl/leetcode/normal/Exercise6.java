package pers.jjzxl.leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 6.将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 *
 * @author JJzXL
 * @date 2023/12/31
 */
public class Exercise6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }

    public static String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return "";
        }
        final List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            list.add(new LinkedList<Character>());
        }
        int s_length = s.length();
        boolean b = true;
        int i = 0;
        while (i < s_length) {
            if (b) {
                for (int j = 0; j < numRows; j ++) {
                    if (i >= s_length) {
                        break;
                    }
                    List<Character> l = list.get(j);
                    l.add(s.charAt(i));
                    i ++;
                }
            } else {
                for (int j = (numRows - 2); j > 0; j --) {
                    if (i >= s_length) {
                        break;
                    }
                    List<Character> l = list.get(j);
                    l.add(s.charAt(i));
                    i ++;
                }
            }
            b = !b;
        }
        StringBuilder result = new StringBuilder();
        for (List<Character> l : list) {
            for (Character cc : l) {
                result.append(cc);
            }
        }
        return result.toString();
    }
}
