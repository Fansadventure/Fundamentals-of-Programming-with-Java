package pgdp.stack;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack <E> implements Iterable<E> {
    private StackItem<E> first = null;

    public E push(E item) {
        first = new StackItem<E>(item,first);
        return first.getValue();
    }
    public E pop() {
        if(first == null)
            return null;
        else {
            E result = first.getValue();
            first = first.getNext();
            return result;
        }
    }
    public E peek() {
        return first == null ? null : first.getValue();
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int search (Object o) {
        StackItem<E> temp = first;
        if(temp == null || o == null)
            return -1;
        int result = 1;
        while(!o.equals(temp.getValue())) {
            result++;
            temp = temp.getNext();
            if(temp == null) {
                result = -1;
                break;
            }

        }
        return result;
    }

    public void addAll(ArrayList<E> list) {
        for(int i = list.size()-1; i>=0; i--)
            first = new StackItem<E>(list.get(i),first);
    }

    public ArrayList<E> toArrayList() {
        ArrayList<E> result = new ArrayList<>();
        for(StackItem<E> i = first; i!=null; i = i.getNext())
            result.add(i.getValue());
        return result;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            StackItem<E> temp = first;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public E next() {
                if(!hasNext())
                    return null;
                else {
                    E result = temp.getValue();
                    temp = temp.getNext();
                    return result;
                }
            }
        };

    }
}
