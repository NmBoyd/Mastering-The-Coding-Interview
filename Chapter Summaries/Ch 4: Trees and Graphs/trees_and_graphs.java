
import stacks_and_queues;
/**
    Binary Tree vs Binary Search Tree
    - When given a binary tree question, many assum that the interviewer
    menas a binary search tree. Be sure to ask whether of not the tree is 
    a binary search tree. A binary search tree imposes the condition that, 
    for all nodes, the left children are less than or equal to the current 
    node, which is less than all the right nodes.

    Balanced vs Unbalanced
    - While many trees are balanced, not all are. Ask the interviewer for clarification
    on this issue. If the tree is unbalanced, you should descrribe your algorithm in 
    terms of both the average the worst case time. Note that there are mulitple ways to 
    balance a tree, and balancing a tree implies only that the depth of subtrees will not
    vary by more than a certain amount. It does not mean that the left and right subtrees
    are exactly the same size.

    Full and Complete
    - Full and complete trees are trees in which all the leaves are at the bottom of 
    the tree, and all non-leaf nodes have exactly two children. Note that full and 
    complete trees are extremely rare, as atree must have exactly 2^n-1 nodes to meet this
    condition.
*/

 /**
    TODO: Be comfortable with implementing in-order, post-order, and pre-order traversal.
    The most common of these, in-order traversal, works by visiting the left side, then 
    the current node, then the right.
  */

/**
    Tree Balancing: Red-Black Trees and AVL Trees

    Know the runtime of balanced trees, and be vaugely familiar wih how you might balanace a tree.
*/

/**
    Tries

    A trie is a variant of an n-ary tree in which characters are stored at each node. Each 
    path down the tree may represent a word.
                / | \
               M  L  A
              / \  \ 
             A   Y  I
            / 
           N 
*/

/**
    Graph traversal

    Be comfortable with binary tree traversal. Graph traversal is more challenging 
    (especially Breadth First search) is difficult. BFS and DFS are usually used in 
    different scenarios. DFs is easiest if we want to visit every node in the graph,
    at least until we find what we are looking for. BFS is good for a very large tree
    and we want to be prepared to quit when we get too far from the original node.
*/

/**
    Depth First Search (DFS)

    The following pseudocode is for DFS
    - Visit node r
    - visit all of n's adjacent nodes (exhaustively search n before r moves on) 
    - go to r's other adjacent nodes

    pre-order and other forms of tree traversal are a form of DFS
*/

void search(Node root) {
    if (root == null) return;
    visit(root);
    root.visited = true;
    foreach (Node n in root.adjacent) {
        if (n.visited == false) {
            search(n);
        }
    }
}

/**
    Breadth First Search (BFS)

    BFS is considerably less intuitive, try to be familiar with the implementation.
    Key thing is to remember is the use of the queue.

    Visit each of node r's adjacent nodes before searching of of r's "grandchildren"
*/

void search(Node root) {
    Queue queue = new Queue();
    root.visited = true;
    visit(root); // add to the end of queue
    queue.enqueue(root);

    while (!queue.isEmpty()) {
        Node r = queue.dequeue(); // remove from front of queue
        foreach (Node n in r.adjacent) {
            if (n.visited = false) {
                visit(n);
                n.visited = true;
                queue.enquque(n);
            }
        }
    }
}