package leetcode.editor.cn;//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 
// 
// Related Topics 链表 
// 👍 589 👎 0


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
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;  // 初始化，位置在head前一个。
        ListNode temphead = temp;  // 最后的reshead应该是temphead.next


        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;  // 指向下下个
            }else{
                temp = temp.next;  // 前进
            }

        }
        return temphead.next;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(
                new ListNode[]{new ListNode(1),new ListNode(2),new ListNode(6),new ListNode(6), new ListNode(6),new ListNode(6),}
        );
        ListNode head = singleLinkedList.getHead();

        Solution203 solution203 = new Solution203();
        ListNode res = solution203.removeElements(head,6);
        res.printFromHead();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
