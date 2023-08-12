package java_basic;

import org.junit.Test;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution83
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 17:32
 * @version: 1.0
 */
public class Solution83 {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode removeDuplicate(ListNode head){
        if(head == null ) return null;
        if(head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void testRun(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        removeDuplicate(head);
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
