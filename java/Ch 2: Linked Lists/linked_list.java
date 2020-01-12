/**
 * Most problems are variants of well known questions
 * There is typically a lack of constant time access and frequency of reqursion
 * 
 * BE ABLE TO IMPLEMENT THIS FROM SCRATCH
 */

// Make sure you understand if it is a single or doubly linked list

// Simple single linked list
class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;
        if(n.data == d) {
            return head.next; // moved head
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
    }
};

/**
    The runner technique can be used in many problems. The technique
    uses means that you iterate through the linked list with two pointers
    simultaneously, with one ahead of the other.
    Good for rearranging 
    a1->a2->a3....->b1->b2->... into
    a1->b1->a2->b2->.... so long as you know that the length of the list is an even number
 */

 /**
    Many linked list problems rely on recursion. If you're having trouble solving a linked
    proble, you should explore a recursive approach. Recursive algorithms take at least O(n) space
    where n is the depth of the recursive call.
  */