package pgdp.stack;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Basic generic stack.
 */
public class Stack<E> implements Iterable<E> {
	// References the first item of the singly-linked list, and hence also the
	// top-most element of this stack.
	private StackItem<E> first = null;

	/**
	 * Pushes the given value onto this stack.
	 * 
	 * @param item a value to get added
	 * @return the parameter
	 */
	public E push(E item) {
		first = new StackItem<E>(item, first);
		return item;
	}

	/**
	 * Removes and returns the top-most element of this stack.
	 * 
	 * @return the top-most element of this stack
	 */
	public E pop() {
		if (first == null) {
			// not required, but this would be a proper way to handle illegal
			// states
			throw new EmptyStackException();
		}

		E result = first.getValue();
		first = first.getNext();
		return result;
	}

	/**
	 * Returns the top-most element of this stack without removing it.
	 * 
	 * @return the top-most element of this stack
	 */
	public E peek() {
		if (first == null) {
			// not required, but this would be a proper way to handle illegal
			// states
			throw new EmptyStackException();
		}

		return first.getValue();
	}

	/**
	 * Whether this stack is empty or not.
	 * 
	 * @return true if the stack is empty, else false
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the 1-based position of the first occurrence of the given object
	 * on the stack, comparing with the equals.
	 * 
	 * @param o the object to search for
	 * @return the 1-based position or -1 if there is no occurrence
	 */
	public int search(Object o) {
		int position = 0;

		for (StackItem<E> temp = first; temp != null; temp = temp.getNext()) {
			position++;
			if ((o == null && o == temp.getValue())
					|| (o != null && o.equals(temp.getValue())))
				return position;
		}
		return -1;
	}

	/**
	 * Adds all elements from the given list, making the first element of the
	 * list the topmost element
	 * 
	 * @param list the elements that should be added
	 */
	public void addAll(ArrayList<E> list) {
		for (int i = list.size() - 1; i >= 0; i--)
			push(list.get(i));
	}

	/**
	 * Retrieves all Elements as ArrayList
	 * 
	 * @return an ArrayList containing all items from the stack
	 */
	public ArrayList<E> toArrayList() {
		ArrayList<E> result = new ArrayList<>();
		for (StackItem<E> temp = first; temp != null; temp = temp.getNext())
			result.add(temp.getValue());
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			StackItem<E> current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				// Hier nicht gefordert
				if (!hasNext())
					throw new NoSuchElementException();
				var value = current.getValue();
				current = current.getNext();
				return value;
			}
		};
	}

	public int sum(Counter<E> counter) {
		int result = 0;
		for(StackItem<E> i = first; i!=null; i = i.getNext()) {
			result += counter.toNumber(i.getValue());
		}
		return result;
	}

	public Stack<E> filter(Predicate<E> filter) {
		Stack<E> result = new Stack<>();
		StackItem<E> next = null;
		for(StackItem<E> i = first; i != null; i = i.getNext()) {
			if(filter.test(i.getValue()))
				if(next == null) {
					result.first = new StackItem<E>(i.getValue(), null);
					next = result.first;
				} else {
					next.setNext(new StackItem<E>(i.getValue(), null));
					next = next.getNext();
				}
		}
		return result;
	}

	public <R> Stack<R> map(Function<E, R> mapper) {
		Stack<R> result = new Stack<>();
		StackItem<R> next = null;
		for(StackItem<E> i = first; i != null; i = i.getNext()) {
			if(next == null) {
				result.first = new StackItem<R>(mapper.apply(i.getValue()), null);
				next = result.first;
			} else {
				next.setNext(new StackItem<R>(mapper.apply(i.getValue()), null));
				next = next.getNext();
			}
		}
		return result;
	}

	public E findFirst(Predicate<E> filter) {
		E result = null;
		for(StackItem<E> i = first; i != null; i = i.getNext()) {
			if(filter.test(i.getValue())) {
				result = i.getValue();
				break;
			}
		}
		return result;
	}

	public E min(Comparator<E> comp) {
		if(isEmpty())
			return null;

		E result = first.getValue();
		for(StackItem<E> i = first.getNext(); i != null; i = i.getNext()) {
			if(comp.compare(result, i.getValue()) > 0)
				result = i.getValue();

		}
		return result;
	}
	public E max(Comparator<E> comp) {
		return min(comp.reversed());
	}
}
