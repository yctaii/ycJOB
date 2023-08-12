package java_basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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


    public ListNode mergeKLists(ListNode[] lists){
        if( lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val -o2.val;
            }
        });
        for (ListNode ll : lists){
            if (ll != null){
                pq.add(ll);
            }
        }
        if (pq.isEmpty()) return null;
        ListNode head = pq.poll();
        ListNode pre = head;
        if (pre.next != null){
           pq.add(pre.next);
        }

        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null)
                pq.add(cur.next);
        }
        return head;
    }

    public ListNode mergeKListss(ListNode[] lNodes) {
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
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (ListNode lNode : lNodes) {
//            while(lNode !=null){
//                pq.add(lNode.val);
//                lNode = lNode.next;
//            }
//        }
//        ListNode mergedNode = new ListNode(-1);
//        ListNode tempNode = mergedNode;
//        while(!pq.isEmpty()){
//            tempNode.next = new ListNode(pq.remove());
//            tempNode = tempNode.next;
//        }
//        return mergedNode.next;
        if(lNodes == null ) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            //默认comparetor 返回负数时 第一个放前面
            // 返回正数时  第二个放前面
            // 返回 0 时 谁放前面无所谓
            public int compare(ListNode o1, ListNode o2) {
                // o1.val - o2.val 囊括了三种情况
                // 我们要的排序是 值小的放前面 按照val从小到大排链表
                // 当 o1.val < o2.val时 o1 应该放在前面 返回负数  而o1.val - o2.val正好负数
                // 当 o2.val < o1.val时 应该o2在前  而 o1.val - o2.val是正数 所以 o2在前
                return o1.val - o2.val;
            }
        });
        for (ListNode ll : lNodes){
            if(ll != null)
                pq.add(ll);
        }
        if (pq.isEmpty()) return null;
        // 优先队列pq中 当你用poll()或 remove()去数据时，默认排序后取
        // peek()方法则是按照添加顺序取元素 而不是 取排序后的顺序
        ListNode head = pq.poll();
        ListNode pre = head;
        if(pre.next != null){
            pq.add(pre.next);
        }
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return head;
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

