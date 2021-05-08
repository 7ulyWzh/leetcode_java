package leetcode.editor.cn;

import java.util.Objects;

public class ListNode {
      int val;
      ListNode next;

      // 构造方法
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
      }


      // 一个打印整条链表val的方法
      public void printFromHead(){
            // 用于保存当前链表节点位置。temp移动不会改变原对象this的位置
            ListNode temp = this;

            StringBuffer stringBuffer = new StringBuffer();
            while (temp.next != null){
                  stringBuffer.append(temp.val + ", ");
                  temp = temp.next;
            }
            stringBuffer.append(temp.val);

            System.out.println(stringBuffer);
      }
}
