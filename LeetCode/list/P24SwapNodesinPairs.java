package list;

import util.ListNode;
import util.ListUtil;

/**
 * Title: 24. 两两交换链表中的节点
 * Desc: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * Created by Myth on 9/6/2019
 */
public class P24SwapNodesinPairs {
    // 节点的移动
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, swap1, swap2;
        while (cur.next != null && cur.next.next != null) {
            swap1 = cur.next;
            swap2 = cur.next.next;
            cur.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            cur = swap1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.stringToListNode("[1,2,3,4]");
        P24SwapNodesinPairs p24 = new P24SwapNodesinPairs();
        ListUtil.prettyPrintLinkedList(p24.swapPairs(head));
    }
}