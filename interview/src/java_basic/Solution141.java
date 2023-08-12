package java_basic;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution141
 * @author: Eric
 * @description: 判断链表是否有环
 * @date: 2023/8/12 17:37
 * @version: 1.0
 */




//可以定义一快一慢指针，每次快指针移动两个
//慢指针移动一个，只要存在环，快的肯定会遇上慢的
public class Solution141 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public boolean hasCycle(ListNode head){
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        //环链表，肯定不可能next为null
        //若快指针next 或 next.next出现null 说明就不是环
        while(fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}
