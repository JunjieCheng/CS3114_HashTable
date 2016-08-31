/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author Junjie Cheng(cjunjie) Liang Shi(blairshi)
 * @version 0.1
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class Memman {
    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Require 3 parameter.");
        }
        
        int size = Integer.parseInt(args[1]);
        byte[] pool = MemManager(size);
        
        readFile(args[2]);
    }
    
    public static byte[] MemManager(int size) {
        return new byte[size];
    }
    
    public static void readFile(String fileName) {
        
    }
    
    private class DList {
        
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
}
