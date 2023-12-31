package pers.jjzxl.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * * 左括号必须用相同类型的右括号闭合。
 * * 左括号必须以正确的顺序闭合。
 * * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lixu
 * @date 2023/01/30
 */
public class Exercise20 {

    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()([)]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('(', ')');
        characterMap.put('[', ']');
        characterMap.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character character = characterMap.get(stack.lastElement());
                if (character == null || character != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
