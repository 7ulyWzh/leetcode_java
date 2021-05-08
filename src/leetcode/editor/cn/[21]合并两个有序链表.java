package leetcode.editor.cn;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1696 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;  // prev的下一个ListNode对象 指向l1
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;  // prev当前指针 + 1
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        // 测试用例
        ListNode[] listNodes1 = {new ListNode(1), new ListNode(2),new ListNode(4)};
        ListNode[] listNodes2 = {new ListNode(1), new ListNode(3),new ListNode(4)};

        // 初始化单链表类
        SingleLinkedList singleLinkedList1 = new SingleLinkedList(listNodes1);
        SingleLinkedList singleLinkedList2 = new SingleLinkedList(listNodes2);

        // 获取头部链表节点
        ListNode l1 = singleLinkedList1.getHead();
        ListNode l2 = singleLinkedList2.getHead();

        Solution21 solution21 = new Solution21();
        ListNode reshead = solution21.mergeTwoLists(l1, l2);

        reshead.printFromHead();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
