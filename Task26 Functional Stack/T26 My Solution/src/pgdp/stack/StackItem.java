package pgdp.stack;

/**
 * Representation of one element of a generic stack.
 */
public class StackItem<E> {
	private final E value;
	private StackItem<E> next;

	/**
	 * Constructs a new instance of StackItem for the given value and reference
	 * to the successor.
	 * 
	 * @param value the value of this item
	 * @param next  the successor of this item, or null if this item is the last
	 *              item of the singly-linked list
	 */
	public StackItem(E value, StackItem<E> next) {
		this.next = next;
		this.value = value;
	}

	/**
	 * @return the value of this item
	 */
	public E getValue() {
		return value;
	}

	/**
	 * @return the successor of this item
	 */
	public StackItem<E> getNext() {
		return next;
	}

	public void setNext(StackItem<E> item) {
		next = item;
	}

}
