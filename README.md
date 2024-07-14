# Data Structures in Java

### Implementation of various data structures in Java...
I am trying to implement or rather recreate various data structues in Java primarily using the Java Generic Framework...
<br>I have currently been able to make data structures like Singly Linked List, Circularly Linked List and Doubly Linked Lists...
<br>I'm planning to implement various other data structures later on...<br>
<br><br>
### Singly Linked List
Below is the structure of a linked list<br><br>
`val1(head)[data]--[next]-->val2-->....-->val{n}(tail)-->null`<br><br>
Here the head is an object of the `Node` class<br>
`head.next` returns a Node object, which is like a linked list with out he head...<br><br>
In a statically typed language like Java, using generic framework to create linked lists help in storing different data types...<br>
As the name says, linkedlists have a series of elements, pointing to the next one...<br>
We can use also it to store elements of a single data type as well<br>
```java
SinglyLinkedList<Object> list1 = new SinglyLinkedList<>();
SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
/*linked list list1 can store different data types,
whereas linked list list2 can only store Integer data type
*/
```
Another fact to be noted is that the elsments stored are not of primitive data types but rather the wrapper classes of the primitive data types, this in a way provides greater flexibility...
<br><br>
### Circularly Linked List
Below is the structure of a circularly linked list<br><br>
`val1(head)[data]--[next]-->val2-->....-->val{n}(tail)-->val1(head)`<br><br>
Traversing a circularly linked list gives an infinite loop...<br>
Note that the `val1(head)` at the end refers to the start of the circularly linked list rather than the element at head, i.e., it refers to the head node...<br>
Also, we can reduce a little storage by considering `head=tail.next`<br>
