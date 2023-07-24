package java_basic;

import org.junit.Test;

/**
 * 给定两个链表的头节点head1、head2
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * eg. 4-> 7 -> 6   2->5->3->3
 * 输出 6 -> 2 -> 0 -> 4
 */
public class sumLinkedList {

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

        @Override
        public String toString() {
            if (this.next != null) return this.val + "->";
            return this.val + ".";
        }
    }

    public ListNode sumLinkedList(ListNode node1, ListNode node2) {
        int l1 = getLen(node1);
        int l2 = getLen(node2);
        ListNode longLen = l1 > l2 ? node1 : node2;
        ListNode shortLen = longLen == node1 ? node2 : node1;
        ListNode ans = longLen;
        int jinwei = 0;
        int sumTmp;
        //短的肯定先加完考虑短的先
        while(shortLen != null){
            sumTmp = shortLen.val + longLen.val + jinwei;
            jinwei = sumTmp / 10;
            longLen.val = sumTmp % 10;
            shortLen = shortLen.next;
            longLen = longLen.next;
        }

        //在考虑长的，若有进位，直接加加完以后 进位清零
        while (longLen != null){
            sumTmp = longLen.val + jinwei;
            jinwei  = sumTmp / 10;
            longLen.val = sumTmp % 10;
            longLen = longLen.next;
        }
        //都加完了，如果还有进位，开一个新结点放进位
        if(jinwei != 0)
            longLen.next = new ListNode(jinwei);

        return ans;

    }


    public int getLen(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    @Test
    public void testRun() {
        ListNode[] listNodes = new ListNode[3];
        listNodes[2] = new ListNode(6);
        listNodes[1] = new ListNode(7, listNodes[2]);
        listNodes[0] = new ListNode(4, listNodes[1]);

        ListNode[] listNodess = new ListNode[4];
        listNodess[3] = new ListNode(3);
        listNodess[2] = new ListNode(3, listNodess[3]);
        listNodess[1] = new ListNode(5, listNodess[2]);
        listNodess[0] = new ListNode(2, listNodess[1]);

        int l1 = getLen(listNodes[0]);
        int l2 = getLen(listNodess[0]);

        ListNode listNode = sumLinkedList(listNodes[0], listNodess[0]);
        while (listNode != null) {
            System.out.print(listNode.toString());
            listNode = listNode.next;
        }
        System.out.println();

    }


}
