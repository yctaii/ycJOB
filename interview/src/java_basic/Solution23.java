package java_basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution23
 * @author: Eric
 * @description: TODO
 * @date: 2023/7/15 09:12
 * @version: 1.0
 */
public class Solution23 {


    /**
     * @projectName: ycJob
     * @package: java_basic
     * @className: Solution21
     * @author: Eric
     * @description: TODO
     * @date: 2023/7/15 08:36
     * @version: 1.0
     */


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


    public ListNode mergeKLists(ListNode[] lNodes) {
//        递归，耗时很长，核心在于两个ListNode的递归比较
//        if (lNodes.length == 0) return null;
//        if (lNodes.length == 1) return lNodes[0];
//        ListNode merged = lNodes[0];
//        for (int i = 1; i < lNodes.length; i++) {
//            merged = mergeTwoList(merged,lNodes[i]);
//        }
//        return merged;
        //使用PriorityQueue,非原来的queue先进先出
        //元素小的，优先级高，越先出
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode lNode : lNodes) {
            while(lNode !=null){
                pq.add(lNode.val);
                lNode = lNode.next;
            }
        }
        ListNode mergedNode = new ListNode(-1);
        ListNode tempNode = mergedNode;
        while(!pq.isEmpty()){
            tempNode.next = new ListNode(pq.remove());
            tempNode = tempNode.next;
        }
        return mergedNode.next;
    }

    private ListNode mergeTwoList(ListNode merged, ListNode lNode) {
        if (merged == null || lNode == null) return lNode == null ? merged : lNode;
        if (merged.val < lNode.val) {
            merged.next = mergeTwoList(merged.next, lNode);
            return merged;
        } else {
            lNode.next = mergeTwoList(merged, lNode.next);
            return lNode;
        }
    }

    @Test
    public void test() {

        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode list1 = new ListNode(1);
        list1.next = l3;

        ListNode list2 = new ListNode(1);
        list2.next = l2;
        l2.next = new ListNode(4);

        ListNode list3 = new ListNode();

        ListNode[] listNodes = {list1, list2, list3};

        ListNode listNode = mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

