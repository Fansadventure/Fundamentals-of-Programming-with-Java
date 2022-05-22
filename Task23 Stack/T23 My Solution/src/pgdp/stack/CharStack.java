package pgdp.stack;

public class CharStack {
	private char[] stack;
	private int stackpointer = 0;

	public CharStack(int maxSize) {
        stack = new char[maxSize];
    }

	public void push(char value) {
		stack[stackpointer++] = value;
	}

	public char pop() {
		return stack[--stackpointer];
	}

	public char peek() {
		return stack[stackpointer - 1];
	}

	public boolean isEmpty() {
		return stackpointer == 0;
	}
}
