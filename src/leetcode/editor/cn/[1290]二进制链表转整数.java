package leetcode.editor.cn;//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
// 
//
// 示例 2： 
//
// 输入：head = [0]
//输出：0
// 
//
// 示例 3： 
//
// 输入：head = [1]
//输出：1
// 
//
// 示例 4： 
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
// 
//
// 示例 5： 
//
// 输入：head = [0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 链表不为空。 
// 链表的结点总数不超过 30。 
// 每个结点的值不是 0 就是 1。 
// 
// Related Topics 位运算 链表 
// 👍 80 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1290 {
    public int getDecimalValue(ListNode head) {
        StringBuffer s = new StringBuffer();
        while (head != null){
            s.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(String.valueOf(s), 2);  // Integer.valueOf的radix参数表示String的进制数，转换为10进制
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(
                new ListNode[]{new ListNode(1),new ListNode(0),new ListNode(0),new ListNode(0), new ListNode(1)}
        );
        ListNode head = singleLinkedList.getHead();

        Solution1290 solution1290 = new Solution1290();
        int res = solution1290.getDecimalValue(head);
        System.out.println(res);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
