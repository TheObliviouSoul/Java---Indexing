package A2;

/** Binary tree node implementation: Pointers to children */
public class BSTNode<E> implements BinNode<E> {

    private E element;          // Element for this node
    private BSTNode<E> left;  // Pointer to left child
    private BSTNode<E> right; // Pointer to right child

    /**Constructors*/
    public BSTNode() {
        left = right = null;
    }

    public BSTNode(E val) {
        left = right = null;
//	  key = k;
        element = val;
    }

    public BSTNode(E val, BSTNode<E> l, BSTNode<E> r) {
        left = l;
        right = r;
//	  key = k;
        element = val;
    }

    /**
     * Return and set the element value
     */
    public E element() {
        return element;
    }

    public void setElement(E v) {
        element = v;
    }

    /**
     * Return and set the left child
     */
    public BSTNode<E> left() {
        return left;
    }

    public void setLeft(E p) {
        left = (BSTNode<E>) p;
    }

    /**
     * Return and set the right child
     */
    public BSTNode<E> right() {
        return right;
    }

    public void setRight(E p) {
        right = (BSTNode<E>) p;
    }

    /**
     * Return true if this is a leaf node
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
