package pgdp.stack;

public class StackItem<E> {
    private final E value;
    private final StackItem<E> next;

    public StackItem (E value, StackItem<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public StackItem<E> getNext() {
        return next;
    }
}
