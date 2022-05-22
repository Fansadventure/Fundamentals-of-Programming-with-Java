package pgdp.lists;

public class IntDoubleListElement {
    // Attributes:
    private int info;
    // These attributes are public because the elements are only supposed to be
    // used by the list which keeps the invariants. The list does not expose its
    // elements to the outside
    public IntDoubleListElement next;
    public IntDoubleListElement prev;
    // Constructor:
    public IntDoubleListElement(int info){
        this.info = info;
        this.prev = null;
        this.next = null;
    }
    public int getInfo() {
        return info;
    }
    public boolean isEqual(IntDoubleListElement other) {
        return info == other.info;
    }
}
