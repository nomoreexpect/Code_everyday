/**
 * @Author:PanYa
 * @Date 2024/6/17-下午7:21
 * @Description:
 */


public class PrintListReversingly {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void printListReversingly(ListNode head) {
        if (head != null) {
            printListReversingly(head.next);
            System.out.print(head.val + " ");
        }
    }

    public static void main(String[] args) {
        // 构建一个链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        PrintListReversingly solution = new PrintListReversingly();
        solution.printListReversingly(head);  // 5 4 3 2 1
    }
}

