/**
    Stacks

    Stacks use LIFO (Last-in first-out) ordering. The most recent item added 
    to the stack is the first item to be removed. 
    Remember that linked lists and stacks are essentially the same thing,
    except a stack usually prevents the user from "Peeking" at the items below the top
 */

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

class Stack {
    Node top;

    Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    Object peek() {
        return top.data;
    }
}

/**
    Queues
    
    Queues implements FIFO (first-in first-out). Items are removed in the same
    order that they were added.
 */

class Queue {
    Node first, last;

    void enqueue(Object item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        }
        else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    Node dequeue() {
        if (first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
