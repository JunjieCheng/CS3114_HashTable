
class DList {

    private Node head;
    private Node tail;
    private int size;

    public DList(int size) {
        Node node = new Node(0, size);
        this.head = new Node(0, 0, null, node);
        this.tail = new Node(0, 0, node, null);
        this.size = 1;
    }

    public int search(int size) {
        int res = Integer.MAX_VALUE;
        int pos = -1;
        Node current = this.head.next;

        while (current != this.tail) {
            if (res == 0) {
                break;
            }
            if (current.len >= size && current.len - size < res) {
                res = current.len - size;
                pos = current.pos;
            }
        }

        return pos;
    }
    
    public void add(int pos, int len) {
        
    }

    public void merge(Node node) {
        
    }

    private class Node {

        private int pos;
        private int len;
        private Node prev;
        private Node next;

        public Node(int pos, int len, Node prev, Node next) {
            this.pos = pos;
            this.len = len;
            this.prev = prev;
            this.next = next;
        }

        public Node(int pos, int len) {
            this.pos = pos;
            this.len = len;
        }
    }
}