/**
 * @Author: PanYa
 * @Date 2024/5/30-下午9:45
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;//

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);

        return dummyHead.next;
    }

    // 打印链表
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addTwoNumbers_2 solution = new addTwoNumbers_2();

        // 创建测试链表1：表示数字342（链表的顺序为2 -> 4 -> 3）
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 创建测试链表2：表示数字465（链表的顺序为5 -> 6 -> 4）
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 计算两个链表的和
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 打印结果链表，应该输出7 -> 0 -> 8，因为342 + 465 = 807
        printList(result);
    }
}


//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {}
//
//    ListNode(int val) { this.val = val; }
//
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
