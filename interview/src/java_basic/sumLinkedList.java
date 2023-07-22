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

    public ListNode sumLinkedList(ListNode node1,ListNode node2) {

        int len1 = getLen(node1);
        int len2 = getLen(node2);
        ListNode longLen = len1 > len2 ? node1 : node2;
        ListNode shortLen =  longLen == node1 ? node2 : node1;

        ListNode curLong =  longLen, curShort = shortLen;
        //last用于记录最后一个不为空的指针，后续处理进位信息
        ListNode last = curLong;

        int jinWei = 0;
        //当两两相加超过10，要对10取模
        int curNum = 0;
        //1.长链表和短链表都还有数据，两两相加指针后移
        while (curShort != null){
            curNum = curShort.val + curLong.val + jinWei;
            curLong.val = curNum %10;
            jinWei = curNum / 10;
            last = curLong;
            curLong = curLong.next;
            curShort = curShort.next;
        }
        //2.短链表没了，长链表还有，判断是否有进位，没有直接赋值
        while (curLong != null){
            curNum = curLong.val + jinWei;
            curLong.val = curNum % 10;
            jinWei = curNum / 10;
            last = curLong;
            curLong = curLong.next;
        }
        //3.长短链表都到头了 判断是否还有未处理的进位
        // 此时指向短链表和长链表的指针都为空了
        //last记录的是最后一个不为空的长链表的位置
        if (jinWei != 0){
            last.next = new ListNode(jinWei);
        }

        //所有值都赋给了长链表，只需返回长链表头指针即可。

        return longLen;
    }


    public int getLen(ListNode l){
        int ans = 0;
        while (l != null){
            ans++;
            l = l.next;
        }
        return ans;
    }

    @Test
    public void testRun() {
        ListNode[] listNodes = new ListNode[3];
        listNodes[2] = new ListNode(6);
        listNodes[1] = new ListNode(7,listNodes[2]);
        listNodes[0] = new ListNode(4, listNodes[1]);

        ListNode[] listNodess = new ListNode[4];
        listNodess[3] = new ListNode(3);
        listNodess[2] = new ListNode(3,listNodess[3]);
        listNodess[1] = new ListNode(5,listNodess[2]);
        listNodess[0] = new ListNode(2,listNodess[1]);

        int l1 = getLen(listNodes[0]);
        int l2 = getLen(listNodess[0]);

        ListNode listNode = sumLinkedList(listNodes[0], listNodess[0]);
        while (listNode!=null){
            System.out.print(listNode.toString());
            listNode = listNode.next;
        }
        System.out.println();

    }


}
