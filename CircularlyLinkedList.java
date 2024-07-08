public class CircularlyLinkedList<E> {
    //---------------- nested Node class ----------------
    private static class Node<E> { 
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> n) { 
            element = e;
            next = n;
        } 
        public E getElement() { return element; } 
        public Node<E> getNext() { return next; } 
        public void setNext(Node<E> n) { next = n; } 
    } //----------- end of nested Node class -----------
    // instance variables
    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList(){} // constructor 
    public int size() { return size; } 
    public boolean isEmpty() { return size == 0; } 
    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // the head is *after* the tail
        }   
    public E last(){
        if (isEmpty()) return null;
        return tail.getElement();
    }
    // update methods
    public void rotate(){
        if (tail!=null)
            tail = tail.getNext();
    }
    public void addFirst(E e){
        if (size==0){
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        }
        else{
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    } 
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null; // must be the only node left
        else tail.setNext(head.getNext()); // removes ”head” from the list
        size--;
        return head.getElement();
    }
    public static void main(String[] args) {
        CircularlyLinkedList<Object> linkedlist1 = new CircularlyLinkedList<Object>();
        System.out.println(linkedlist1);
        // Node(10, linkedlist1);
        // linkedlist1.head = 10;
        linkedlist1.addLast(35);
        linkedlist1.addLast(442);
        linkedlist1.addLast(3245);
        linkedlist1.addLast(0);
        linkedlist1.addFirst("dwfsfg");
        System.out.println(linkedlist1.first());
        System.out.println(linkedlist1);
        for (Node curr = linkedlist1.tail; curr!=null;curr = curr.getNext()){
            System.out.println(curr);
            System.out.println(curr.getElement());
        }
        System.out.println(linkedlist1.first());
        
    }
}
