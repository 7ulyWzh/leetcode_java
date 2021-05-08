package leetcode.editor.cn;

import java.util.Arrays;

public class SingleLinkedList {
    /*
    * 定义一个单链表类，管理整条链表
    * !!!用作测试案例中生成一整条链表
    * */

    // 头节点
    private ListNode head;
    // 链表节点 数组
    private ListNode[] listNodes;

    public SingleLinkedList(ListNode[] listNodes) {
        this.head = listNodes[0];
        this.listNodes = listNodes;

        // 在构造方法里调用实例方法
        this.linkAllNodes();
    }

    // 将所有链表节点连接
    public void linkAllNodes(){
        for (int i = 0; i < listNodes.length - 1; i++) {
            listNodes[i].next = listNodes[i+1];
        }
    }

    // 返回头部ListNode
    public ListNode getHead(){
        return head;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }
}
