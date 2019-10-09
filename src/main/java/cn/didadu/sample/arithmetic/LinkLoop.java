package cn.didadu.sample.arithmetic;

/**
 * @author zhangjing
 * @date 2019-05-30
 */
public class LinkLoop {

    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data ;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }

    public static boolean isLoop(Node node) {
        Node slow  = node;
        Node fast = node.next;

        while (slow.next != null) {
            Object dataSlow = slow.data;
            Object dataFast = fast.data;

            // 说明有环
            if (dataFast == dataSlow) {
                return true;
            }

            // 一共只有两个节点，但却不是环形链表的情况，判断NPE
            if (fast.next == null) {
                return false;
            }

            // slow走慢一点，fast走快一点
            slow = slow.next;
            fast = fast.next.next;

            // 如果走的快的发现为空 说明不存在环
            if (fast == null) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node1);

        System.out.println(isLoop(node0));
    }

}
