public class SinglyLinkedList <E>{
    //---------------- nested Node class ----------------
    private static class Node<E> { 
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> n) { 
            element = e;
            next = n;
        } 
        public E getElement( ) { return element; } 
        public Node<E> getNext( ) { return next; } 
        public void setNext(Node<E> n) { next = n; } 
    } //----------- end of nested Node class -----------
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() {} // constructs an initially empty list
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public E first(){
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (size == 0){
            tail = head;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public E removeFirst(){
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }
    // @Override
    // public String toString() {
    //     return "A singly linked list object";
    // }
    public static void main(String[] args) {
        SinglyLinkedList<Object> linkedlist1 = new SinglyLinkedList<Object>();
        System.out.println(linkedlist1);
        // Node(10, linkedlist1);
        // linkedlist1.head = 10;
        linkedlist1.addLast(35); // an Integer object
        linkedlist1.addLast(442L); // a Long object
        linkedlist1.addLast(3245.0324); // a Double object 
        linkedlist1.addLast(0.0F); // a Float object
        linkedlist1.addFirst("random"); // a String object
        linkedlist1.addFirst('a');  // a Character object
        System.out.println(linkedlist1.head.getElement());
        System.out.println(linkedlist1);
        for (Node curr = linkedlist1.head; curr!=null;curr = curr.getNext()){
            System.out.println(curr);
            Class c = curr.getClass();
            Class c1 = curr.getElement().getClass();
            System.out.println(c);
            System.out.println(c1);
            System.out.println(curr.getElement());
        }
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<Integer>();
        linkedList2.addFirst(1);
        linkedList2.addLast(34);
        int sum = 0;
        for (Node curr = linkedList2.head; curr!=null;curr = curr.getNext()){
            // sum +=  curr.getElement();
            /*The above statement doesn't work as the elements are stored a objects of the 
            wrapper classes of the primitive data types rather than being the primitive data type 
            the statement below works though...*/
            sum += (int) curr.getElement();
        }       
        System.out.println(sum);
    }
}
