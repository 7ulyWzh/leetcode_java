package leetcode.editor.cn;//请判断一个链表是否为回文链表。
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 969 👎 0


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
class Solution234 {
    public boolean isPalindrome(ListNode head) {

        ListNode remainHalf = endOfFirstHalf(head).next;  // 后半部分的head
        ListNode reverseRemainHalf = reverseListNode(remainHalf);  // 将后半部分反转

        ListNode curFirst = head;
        ListNode curRemain = reverseRemainHalf;
        while(curRemain != null){  // // 整个回文为奇数长度时，前半部分比后半部分大1
            if(curFirst.val != curRemain.val){
                return false;
            }
            curFirst = curFirst.next;
            curRemain = curRemain.next;
        }
        return true;
    }


    public ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode reverseListNode(ListNode head){
        // 递归终止条件
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(
                new ListNode[]{new ListNode(1),new ListNode(2),new ListNode(3),new ListNode(2), new ListNode(1)}
        );
        ListNode head = singleLinkedList.getHead();
        Solution234 solution234 = new Solution234();
        boolean res = solution234.isPalindrome(head);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
