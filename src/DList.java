/**
 * Free blocks list.
 * 
 * @author Junjie Cheng (cjunjie)
 * @version September 2, 2016
 */
class DList {

    /**
     * Head of the list.
     */
    private Node head;

    /**
     * End of the list.
     */
    private Node tail;

    /**
     * Number of Node in the list.
     */
    private int size;

    /**
     * Create a new DList.
     * @param size Size of the memory pool.
     */
    public DList(int size) {
        Node node = new Node(0, size);
        this.head = new Node(0, 0, null, node);
        this.tail = new Node(0, 0, node, null);
        node.prev = this.head;
        node.next = this.tail;
        this.size = 1;
    }

    /**
     * Search for space in free blocks.
     * @param length  Needed size.
     * @return  Return the position of the free block.
     */
    public int searchBlock(int length) {
        int res = Integer.MAX_VALUE;
        int pos = -1;
        Node current = this.head.next;

        while (current != this.tail) {
            if (res == 0) {
                break;
            }
            if (current.len >= length && current.len - length < res) {
                res = current.len - length;
                pos = current.pos;
            }

            current = current.next;
        }

        return pos;
    }

    /**
     * Add a new free block to the list.
     * @param pos   Position of the free block.
     * @param len   Length of the free block.
     */
    public void add(int pos, int len) {
        Node current = this.head.next;
        Node newNode = new Node(pos, len);

        while (current != this.tail) {
            if (pos <= current.pos) {
                break;
            }
            else {
                current = current.next;
            }
        }

        newNode.next = current;
        newNode.prev = current.prev;
        newNode.prev.next = newNode;
        current.prev = newNode;
        this.size++;

        merge(newNode);
    }

    /**
     * Merge adjacent free blocks.
     * @param node  The node to be checked.
     */
    private void merge(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev != this.head 
                && prev.pos + prev.len == node.pos) {
            prev.len += node.len;
            prev.next = node.next;
            node.next.prev = prev;
            this.size--;
        }

        if (next != this.tail && 
                node.pos + node.len == next.pos) {
            node.len += next.len;
            node.next = next.next;
            next.next.prev = node;
            this.size--;
        }
    }

    /**
     * Get size.
     * @return  Size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Split space from a free block.
     * @param pos   Position of the free block.
     * @param len   Length of the free block.
     */
    public void splitBlock(int pos, int len) {
        Node current = this.head.next;

        while (current != this.tail) {
            if (current.pos == pos) {
                if (current.len == len) {
                    this.size--;
                    break;
                }

                current.len -= len;
                current.pos += len;
                merge(current);
            }

            current = current.next;
        }
    }

    /**
     * Print blocks.
     */
    public void print() {
        Node current = this.head.next;

        while (current.next != this.tail) {
            System.out.printf("(%d,%d) -> ", current.pos, current.len);
            current = current.next;
        }

        System.out.printf("(%d,%d)\n", current.pos, current.len);
    }

    /**
     * Node
     * @author Junjie Cheng (cjunjie)
     * @version September 2, 2016
     */
    private class Node {

        /**
         * Position.
         */
        private int pos;

        /**
         * Length.
         */
        private int len;

        /**
         * Previous Node.
         */
        private Node prev;

        /**
         * Next Node.
         */
        private Node next;

        /**
         * Create a new Node.
         * @param pos   Position.
         * @param len   Length.
         * @param prev  Previous Node.
         * @param next  Next Node.
         */
        public Node(int pos, int len, Node prev, Node next) {
            this.pos = pos;
            this.len = len;
            this.prev = prev;
            this.next = next;
        }

        /**
         * Create a new Node.
         * @param pos   Position.
         * @param len   Length.
         */
        public Node(int pos, int len) {
            this.pos = pos;
            this.len = len;
        }
    }
}