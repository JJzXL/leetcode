package pers.jjzxl.leetcode.normal;

/**
 * 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入:l1 = [2,4,3],
 *     l2 = [5,6,4]
 * 输出:[7,0,8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author JJzXL
 * @date 2019/05/22
 */
public class Exercise2 {

    public static void main(String[] args) {

        ListNode head1Node2 = new ListNode(3);
        ListNode head1Node1 = new ListNode(4, head1Node2);
        ListNode head1 = new ListNode(2, head1Node1);
        print(head1);

        ListNode head2Node2 = new ListNode(4);
        ListNode head2Node1 = new ListNode(6, head2Node2);
        ListNode head2 = new ListNode(5, head2Node1);
        print(head2);

        System.out.println("----");

        print(addTwoNumbers(head1, head2));
    }

    public static void print(ListNode listNode) {
        while (listNode.hasNext()) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
        int a = sum / 10;
        int b = sum % 10;
        ListNode result = new ListNode(b);
        ListNode head = result;
        while (l1 != null) {
            if (l2 == null) {
                sum = l1.val + a;
            } else {
                sum = l1.val + l2.val + a;
                l2 = l2.next;
            }
            a = sum / 10;
            b = sum % 10;
            result.next = new ListNode(b);
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = a + l2.val;
            a = sum / 10;
            b = sum % 10;
            result.next = new ListNode(b);
            result = result.next;
            l2 = l2.next;
        }
        if (a != 0) {
            result.next = new ListNode(a);
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
