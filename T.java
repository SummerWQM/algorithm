    public static void main(String[] avg) {

        Node head = buildLink(10);

        print(head);
        //print(reverse(head, 1, 2));

        print(reverse(head, 3));
    }

    public static Node reverse(Node head, int k) {
        Node hair = new Node(0);
        hair.next = head;

        Node pre = hair;

        Node start = head, end = pre;

        while (start != null) {
            for (int i = 0; i < k; i++) {
                if (end == null) {
                    break;
                }
                end = end.next;
            }
            if (end == null) {
                break;
            }
            Node[] reverse = reverse(start, end);
            pre.next = reverse[0];
            end = reverse[1];
            pre = end;
            start = end.next;
        }

        return hair.next;

    }


    public static Node reverse(Node head, int m, int n) {

        Node hair = new Node(0);
        hair.next = head;
        Node pre = hair;
        Node start = pre, end = pre;

        for (int i = 0; i < m; i++) {
            start = start.next;
            if (i > 0) {
                pre = pre.next;
            }
        }

        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        Node[] revse = reverse(start, end);

        pre.next = revse[0];

        return hair.next;

    }

    public static Node[] reverse(Node start, Node end) {
        Node pre = end.next;
        Node tail = end.next;
        Node cur = start;
        while (cur != tail) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new Node[]{end, start};
    }


    public static void print(Node head) {
        if (head == null) return;

        StringBuilder sb = new StringBuilder();
        Node read = head;

        while (read != null) {
            sb.append(read.val);
            if (read.next != null) {
                sb.append("->");
            }
            read = read.next;
        }

        System.out.println(sb.toString());
    }


    public static Node buildLink(int n) {
        Node hair = new Node(0);
        Node pre = hair;
        int i = 1;
        while (i <= n) {
            pre.next = new Node(i++);
            pre = pre.next;
        }
        return hair.next;
    }

    static class Node {
        Node next;
        int val;

        Node(int v) {
            val = v;
        }
    }

