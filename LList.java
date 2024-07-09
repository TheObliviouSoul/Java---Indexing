package A2;

import A2.ADTList;

/** Linked list implementation */
public class LList<K,E> implements ADTList<K, E> {
	
	public Node<K,E> head; // Pointer to list header
	
	public Node<K,E> tail; // Pointer to last element
	
	protected Node<K,E> curr; // Access to current element
	
	public static int cnt; // length of list
	
	/** Constructors */
	public LList(int size) { this(); } // Constructor -- Ignore size
	
	public LList() {
		curr = tail = head = new Node<K,E>(null); // Create header
		cnt = 0;
	}
	
	/** Remove all elements */
	public void clear() {
		head.setNext(null); // Drop access to links
		curr = tail = head = new Node<K,E>(null); // Create header
		cnt = 0;
	}
	
	/** Insert "it" at current position */
	public void insert(K key, E val) {
		
		
		curr.setNext(new Node<K,E>(key, val, curr.next()));
		
		if (tail == curr) 
			tail = curr.next(); // New tail
		cnt++;
	}
	
	/** Append "it" to list */
	public void append(K key, E val) {
		tail = tail.setNext(new Node<K, E>(key, val, null));
		cnt++;
	}
	
	/** Remove and return current element */
	public E remove() {
		if (curr.next() == null) 
			return null; // Nothing to remove
		
		E val = curr.next().v(); // Remember value
		K key = curr.next().k();
		
		if (tail == curr.next()) 
			tail = curr; // Removed last
		
		cnt--; // Decrement count
		return val; // Return value
	}
	
	/** Set curr at list start */
	public void moveToStart()
	{ curr = head; }
	
	/** Set curr at list end */
	public void moveToEnd()
	{ curr = tail; }
	
	/** Move curr one step left; no change if now at front */
	public void prev() {
		if (curr == head) return; // No previous element
		Node<K,E> temp = head;
		// March down list until we find the previous element
		while (temp.next() != curr) 
			temp = temp.next();
		curr = temp;
	}
	
	/** Move curr one step right; no change if now at end */
	public void next(){ 

		if (curr != tail)
			curr = curr.next();
	}
	
	/** @return List length */
	public int length() { return cnt; }
	
	/** @return The position of the current element */
	public int currPos() {
		Node<K,E> temp = head;
		int i;
		for (i=0; curr != temp; i++)
		temp = temp.next();
		return i;
	}
	
	/** Move down list to "pos" position */
	public void moveToPos(int pos) {
		assert (pos>=0) && (pos<=cnt) : "Position out of range";
		curr = head;
		for(int i=0; i<pos; i++) curr = curr.next();
	}
	
	/** @return Current element value */
	public E getValue() {
		if(curr.next() == null) return null;
		return curr.next().v();
	}

}
