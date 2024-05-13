/**
 * @Author:PanYa
 * @Date 2024/5/10-上午11:03
 * @Description: 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Merge_LinkedList {

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        /*
//        *@Param [l1, l2]
//        *@return ListNode
//        *@Description: 递归法
//        */
//        if(l1 == null ){
//            return l2;
//        }else if(l2 == null ){
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        /*
         *@Param [l1, l2]
         *@return ListNode
         *@Description: 迭代
         */
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
    // Helper method to print list nodes
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        Merge_LinkedList merger = new Merge_LinkedList();
        ListNode mergedList = merger.mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
