import java.util.NoSuchElementException;

//import DoublyLinkedListImpl.Node;

/**
     * this class keeps track of each element information
     * @author java2novice
     *
     */
    public class Node<E> {
        protected E element;
        protected Node current;
        protected Node next;
        protected Node prev;
        private int size;
 
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        
        public E getElement()
        {
        	return this.element;
        }
        
        public Node getNext()
        {
        	return this.next;
        }
        
        public Node getPrev() 
        {
        	return this.prev;
        }
        
        public void setPrev(Node prev) {
        	this.prev = prev;
        }
        
        public void setNext(Node next) {
        	this.next = next;
        }
    } 