    public static void main(String[] args) {
        Node head = buildLink(10);
        Node head2 = buildLink(20);
        System.out.println(printLink(head));
        System.out.println(printLink(reverseMtoN(head, 1, 4)));
    }


    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }


    public static Node buildLink(int n) {
        int cur = 1;
        Node hair = new Node(-1);
        Node pre = hair;
        while (cur <= n) {
            Node node = new Node(cur++);
            pre.next = node;
            pre = node;
        }
        return hair.next;
    }

    public static String printLink(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }


    public static Node mergeLink(Node l1, Node l2) {
        Node hair = new Node(-1);
        Node pre = hair, l1Next, l2Next;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return hair.next;
    }


    public static Node reverseMtoN(Node head, int m, int n) {

        Node hair = new Node(-1);

        hair.next = head;
        Node pre = hair, start = pre, end = pre;

        for (int i = 0; i < m; i++) {
            if (start.next != null) {
                start = start.next;
            }
            if (i > 0) {
                pre = pre.next;
            }
        }
        for (int i = 0; i < n; i++) {
            if (end.next != null) {
                end = end.next;
            }
        }
        Node next = end.next;
        end.next = null;
        pre.next = reverser(start);
        start.next = next;


        return hair.next;


    }

    public static Node reverseK(Node head, int k) {
        Node hair = new Node(-1);
        Node pre = hair, end = hair;
        hair.next = head;
        while (end != null) {
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
            }
            if (end == null) {
                break;
            }
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverser(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return hair.next;
    }

    public static Node reverser(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

