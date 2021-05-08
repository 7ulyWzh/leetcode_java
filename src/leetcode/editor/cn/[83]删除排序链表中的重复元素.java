package leetcode.editor.cn;//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 570 👎 0


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
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {  // 判断空链表
            return head;
        }

        ListNode reshead = head;
        ListNode res = reshead;
        ListNode temp = head;

        while(temp.next != null){
            int val = temp.val;
            temp = temp.next;
            int vall = temp.val;

            // temp前进后，值不等于上一节点的值
            if(vall != val){
                res.next = temp;
                res = res.next;
            }else{
                res.next = null;  // 末尾截断
            }
        }

        return reshead;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(
                new ListNode[]{new ListNode(1),new ListNode(1),new ListNode(2),new ListNode(3), new ListNode(3)}
        );

        ListNode head = singleLinkedList.getHead();

        ListNode headd = new ListNode(-1);

        Solution83 solution83 = new Solution83();
        solution83.deleteDuplicates(headd);
        headd.printFromHead();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
