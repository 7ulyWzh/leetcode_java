package leetcode.editor.cn;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1729 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode latt = curr.next;
        while(curr != null){
            // 移动latt
            latt = curr.next;

            // 反转
            curr.next = prev;

            // 移动 prev curr
            prev = curr;
            curr = latt;
        }
        return prev;  // 最后一次前进后，curr已指向最后的null
    }

    public ListNode reverseList2(ListNode head){
        // 递归终止条件
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverseList2(head.next);  // 递 至最后一个节点，单个节点即是单个节点的反转
        // 归过程的操作
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(
                new ListNode[]{new ListNode(1),new ListNode(1),new ListNode(2),new ListNode(3), new ListNode(3)}
        );
        ListNode head = singleLinkedList.getHead();
        Solution206 solution206 = new Solution206();
        ListNode res = solution206.reverseList2(head);
        res.printFromHead();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
