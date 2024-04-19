package leetcode.linkedlist;

import structure.ListNode;

/**
 * @autor yud1
 * @date 2024/4/17 15:40
 *
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 19. 删除链表的倒数第 N 个结点
 */
public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(n > 0){
           fast = fast.next;
           n--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
