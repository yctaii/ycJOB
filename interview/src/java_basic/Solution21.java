package java_basic;

import org.junit.Test;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution21
 * @author: Eric
 * @description: TODO
 * @date: 2023/7/15 08:36
 * @version: 1.0
 */
public class Solution21 {


    public class ListNode {
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
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    @Test
    public void test() {

        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode list1 = new ListNode(1);
        list1.next = l3;
        l3.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = l2;
        l2.next = new ListNode(4);

//        while(list2 != null){
//            System.out.println(list2.val);
//            list2 = list2.next;
//        }
        ListNode[] listNodes = {list1,list2};



        mergeTwoLists(list1, list2);
    }
}
