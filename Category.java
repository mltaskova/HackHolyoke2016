import java.util.*;

public class Category {

	private DoublyLinkedListImpl<Flashcard> myList;
	
	public Category () {		
		myList = new DoublyLinkedListImpl<Flashcard>();
	}
	
	public void insert(Flashcard myFlashcard) {
		myList.addFirst(myFlashcard);			
	}
	
	public void delete(Node<Flashcard> current) {
		myList.remove(current);
	}
	
	public void iterateBackward () {
		myList.iterateBackward();
	}
	
	public void iterateForward () {
		myList.iterateForward();
	}
	
	public Flashcard prev(Node<Flashcard> curNode) {
		return (Flashcard)curNode.getPrev().getElement();
	}
	
	public Flashcard next(Node<Flashcard> curNode) {		
		return (Flashcard)curNode.getNext().getElement();
	}

	public Node getLast() {
		return myList.getLast();
	}
	
	public Node getFirst() {
		return myList.getFirst();
	}
	
	public static void main(String args[])
	{
		Category myCategory = new Category ();
		myCategory.insert(new Flashcard ("aaa", "aaa"));
		myCategory.insert(new Flashcard ("bbb", "bbb"));
		myCategory.insert(new Flashcard ("ccc", "ccc"));
		myCategory.insert(new Flashcard ("ddd", "ddd"));
		myCategory.insert(new Flashcard ("eee", "eee"));
//		myCategory.delete(myCategory.getLast());
//	    myCategory.iterateBackward();
//	    myCategory.iterateForward();
    	myCategory.delete(myCategory.getFirst().getNext());
		myCategory.delete(myCategory.getLast().getPrev().getPrev());
		myCategory.iterateForward();
		myCategory.iterateBackward();
		myCategory.prev(myCategory.getLast());
	}
}
