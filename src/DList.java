
class DList {

    private Node head;
    private Node tail;
    private int number;

    public DList() {
        this.head = new Node(0, 0, null, null);
        this.tail = new Node(0, 0, head, null);
        head.setNext(tail);
        this.number = 0;
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

        public int pos() {
            return pos;
        }

        public int len() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public Node prev() {
            return this.prev;
        }

        public Node next() {
            return this.next;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }
}