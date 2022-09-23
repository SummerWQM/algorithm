 static class Node {
        Node next;
        int val;

        public Node(int value) {
            val = value;
        }

    }

    public static String printLink(Node h) {
        StringBuilder sb = new StringBuilder();
        Node cur = h;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public static Node buildLink(int k) {
        Node head = new Node(k--);
        Node cur = head;
        while (k > 0) {
            cur.next = new Node(k--);
            cur = cur.next;
        }
        return head;
    }

    public static Node revers(Node head, int k) {
        Node hair = new Node(0);
        hair.next = head;
        Node pre = hair;
        while (head != null) {
            Node tail = pre;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return hair.next;
                }
                tail = tail.next;
            }
            Node next = tail.next;
            Node[] reverse = rever(head, tail);
            pre.next = reverse[0];
            pre = reverse[1];
            head = next;
        }

        return hair.next;
    }

    public static Node[] rever(Node head, Node tail) {
        Node pre = tail.next;
        Node cur = head;
        while (pre != tail) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new Node[]{tail, head};
    }

    public static Node numberK(Node head, int k) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] avg) {
        Node link = buildLink(10);
        System.out.println(printLink(link));
        System.out.println(printLink(revers(link, 2)));
        System.out.println(printLink(numberK(link, 2)));
    }
