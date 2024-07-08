public class DoublyLinkedList <E>{
    //---------------- nested Node class ----------------
    private static class Node<E> { 
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list
        private Node<E> prev; // reference to the previous node in the list
        public Node(E e,Node<E> p, Node<E> n) { 
            element = e;
            next = n;
            prev = p;
        } 
        public E getElement() { return element; } 
        public Node<E> getNext() { return next; }
        public Node<E> getPrev() { return prev; } 
        public void setNext(Node<E> n) { next = n; }
        public void setPrev(Node<E> p) { prev=p; } 
    } //----------- end of nested Node class -----------
    
    // instance variables of the DoublyLinkedList
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public DoublyLinkedList(){
        // the constructor
        header = new Node<> (null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}
    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    public Node<E> firstNode(){
        if (isEmpty()) return null;
        return header.getNext();
    }
    public E last(){
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    public Node<E> lastNode(){
        if (isEmpty()) return null;
        return trailer.getPrev();
    }
    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public E removeFirst() { 
        if (isEmpty()) return null; // nothing to remove
        return remove(header.getNext()); // first element is beyond header
    }  
    /** Removes and returns the last element of the list. */
    public E removeLast() { 
        if (isEmpty()) return null; // nothing to remove
        return remove(trailer.getPrev()); // last element is before trailer
    }
    // private update methods
    /** Adds element e to the linked list in between the given nodes. */
    private void addBetween(E e, Node<E> pre, Node<E> post) { 
        // create and link a new node
        Node<E> newest = new Node<>(e, pre, post);
        pre.setNext(newest);
        post.setPrev(newest);
        size++;
    } 
    /** Removes the given node from the list and returns its element. */
    private E remove(Node<E> node) { 
        Node<E> pre = node.getPrev();
        Node<E> post = node.getNext();
        pre.setNext(post);
        post.setPrev(pre);
        size--;
        return node.getElement();
    }
    public static void main(String []args){
        DoublyLinkedList<Object> db1 = new DoublyLinkedList<>();
        db1.addFirst(100);
        db1.addLast(300);
        db1.addFirst("db1 start");
        db1.addLast("db1 end");
        db1.addBetween("db1 before start", db1.firstNode(), db1.firstNode().next);
        for (Node n = db1.firstNode(); n!=db1.lastNode().next;n = n.next){
            System.out.println("Element:" + n.getElement());
            System.out.println("Element prev:" + n.getPrev().getElement());
            System.out.println("Element next:" + n.getNext().getElement());
        }
    }
}
