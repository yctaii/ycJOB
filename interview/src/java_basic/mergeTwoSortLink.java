package java_basic;

import org.junit.Test;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: mergeTwoSortLink
 * @author: Eric
 * @description: TODO
 * @date: 2023/7/23 10:30
 * @version: 1.0
 */
public class mergeTwoSortLink {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (this.next != null) return this.val + "->";
            return this.val + ".";
        }
    }


    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        if(l1.val > l2.val) {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }
    }

    @Test
    public void testRn() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(4);

        ListNode head = mergeTwoList(a, b);

        while (head != null) {
            System.out.print(head.toString());
            head = head.next;
        }
    }

}
