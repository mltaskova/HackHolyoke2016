 /*
  * from
  * https://www.java2novice.com/data-structures-in-java/linked-list/doubly-linked-list/
  */
import java.util.NoSuchElementException;
 
public class DoublyLinkedListImpl<E> {
 
    private Node head;
    private Node tail;
    private int size;
     
    public DoublyLinkedListImpl() {
        size = 0;
    }

    /**
     * returns the size of the linked list
     * @return
     */
    public int size() { return size; }
     
    /**
     * return whether the list is empty or not
     * @return
     */
    public boolean isEmpty() { return size == 0; }
     
    /**
     * adds element at the starting of the linked list
     * @param element
     */
    public Node getLast() {
    	Node tmp = tail;
    	return tmp;
    }
    
    public Node getFirst() {
    	Node tmp = head;
    	return tmp;
    }
    
    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        System.out.println("adding: "+element);
    }
     
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(E element) {
         
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        System.out.println("adding: "+element);
    }
     
    /**
     * this method walks forward through the linked list
     */
    public void iterateForward(){
         
        System.out.println("iterating forward..");
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
     
    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward(){         
        System.out.println("iterating backward..");
        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }
     
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+tmp.element);
//        return tmp.getElement();
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public void removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.element);
//        return tmp.element;
    }
     
    public void remove(Node current) {
    	if (!isEmpty()) {
    		if (current == head) {
    			head = current.getNext();
    			head.setPrev(null);
    			System.out.println("delete: " + current.getElement());
    		}
    		else if (current == tail) {
    			tail = current.getPrev();
    			tail.setNext(null);
    			System.out.println("delete: " + current.getElement());
    		}
    		else {
    			current.getPrev().setNext(current.getNext());
    	    	current.getNext().setPrev(current.getPrev()); 
    	    	System.out.println("delete: " + current.getElement());
    		}
    	}
    }
}
    
//    public static void main(String a[]){
//         
//        DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
//        dll.addFirst(10);
//        dll.addFirst(34);
//        dll.addLast(56);
//        dll.addLast(364);
//        dll.iterateForward();
//        dll.removeFirst();
//        dll.removeLast();
//        dll.iterateBackward();
//    }
