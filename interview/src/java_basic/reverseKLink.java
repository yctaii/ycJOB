package java_basic;

import org.junit.Test;

import java.util.List;

/**
 * k个节点组内逆序
 * 给定一个头节点head和一个正数 k
 * 实现 k 个节点的小组内部逆序，如果最后一组不够 k 个就不调整
 * e.g. 1->2->3->4->5->6->7->8, k = 3
 * 调整后 ： 3->2->1->6->5->4->7->8
 */
public class reverseKLink {

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
            return this.val + "";
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = findKGroupEnd(head,k);
        if(end == null) return head; //不足k个不用反转

        //因为反转后，头指针应该指向当前的end，在reverse之前先记录
        head = end;
        reverse(start,end);
        ListNode lastEnd = start;   //此时的start已经是反转链表组的尾部
        while(lastEnd.next != null){
            start = lastEnd.next;
            end = findKGroupEnd(start,k);
            if(end == null) return head;
            reverse(start,end);
            //lastend是上一个反转链表的尾节点
            //要将它与新反转的链表头节点 end 连接起来
            lastEnd.next = end;
            //那么此时的lastEnd就是这次反转后的链表的尾节点 即 start
            lastEnd = start;
        }
        return head;
    }

    public ListNode findKGroupEnd(ListNode start, int k){
        while( --k != 0 && start != null){
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end){
        //要断链，若后续要用，肯定要先记录下来
        //反转直到 start = end.next停止
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode nextT = null;
        while(cur != end){
            //要把cur.next反转，先把它记录下来
            nextT = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextT;
        }
        //因为反转，此时的start已经是这个链表的尾了
        //要将它与后面未反转的链表连起来，即与一开始的end的next链接起来
        //即 一开始直接 记录 end = end.next
        start.next = end;
    }
    @Test
    public void testRun() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode next = a.next.next;
        next.next = new ListNode(4);

        ListNode cur = reverseKGroup(a, 2);

        while (cur != null) {
            System.out.print(cur.toString());
            cur = cur.next;
        }
        System.out.println();
//        ListNode end = a.next.next;
//        reverse(a, end);
//        cur = end;
//        while (cur != null) {
//            System.out.print(cur.toString());
//            cur = cur.next;
//        }
    }
}
