package pgdp.colony;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PenguinList implements Iterable<Penguin> {
    protected List<Penguin> list = new ArrayList<>();
    // info from: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    // Add(): Appends the specified element to the end of this list:
    public boolean add(Penguin penguin) { return list.add(penguin); }

    // Get(...): Returns the element at the specified position in this list:
    public Penguin get(int index) {
        return list.get(index);
    }

    // Removes the first occurrence of the specified element from this list, if it is present:
    public boolean remove(Penguin penguin) {
        return list.remove(penguin);
    }

    // Removes the element at the specified position in this list:
    public Penguin remove(int index) {
        return list.remove(index);
    }
    // Returns the number of elements in this list:
    public int size() {
        return list.size();
    }
    // Returns an iterator over the elements in this list in proper sequence:
    public Iterator<Penguin> iterator() {
        return list.iterator();
    }


    // sort the list from oldest to youngest
    public PenguinList sort(){
        PenguinList b = new PenguinList();
        for(int i=0; i<this.size(); i++){
            int j =0;
            while(j<i && this.get(i).getAgeInDays()<=b.get(j).getAgeInDays()) {
                j++;
            }
            b.add(this.get(i));
            for(int k=j; k<i;k++){
                b.add(b.get(k));
            }
            for(int k=0; k<i-j;k++) {
                b.remove(j);
            }
        }
        return b;
    }

    public PenguinList copy(){
        PenguinList b = new PenguinList();
        for(int i=0; i<size(); i++){
            b.add(this.get(i));
        }
        return b;
    }
}
