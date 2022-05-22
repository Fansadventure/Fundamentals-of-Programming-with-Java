package pgdp.lists;

public class IntDoubleList {
    // Attributes:
    private IntDoubleListElement head;
    private IntDoubleListElement tail;
    private int size = 0;

    public IntDoubleList() {
        head = null;
        tail = null;
    }

    public void append(int info) {
        IntDoubleListElement newElement = new IntDoubleListElement(info);
        if(size ==0){
            head = newElement;
            tail = newElement;
        }else{
            tail.next= newElement;
            newElement.prev = tail;
            tail = newElement;
        }
        size++;
    }

    public int size() {
        return size;
    }

    private IntDoubleListElement getElement(int pos) {
        if(pos<0 || pos>=size) System.out.println("Invalid position!");
        if(pos<=size/2){
            IntDoubleListElement result = head;
            for(int i=0; i<pos;i++)
                result=result.next;
            return result;
        }else{
            IntDoubleListElement result = tail;
            for(int i=size-1; i>pos;i--)
                result = result.prev;
            return result;
        }
    }

    public int get(int pos) {
        if(pos<0 || pos>=size) {
            System.out.println("Invalid position!");
            return -100;
        }
        if(size!=0){
            IntDoubleListElement resultElement = getElement(pos);
            return resultElement.getInfo();
        }else{
            System.out.println("Empty list!");
            return -10;
        }
    }

    public void remove(int pos) {
        if(pos<0 || pos>=size)
            System.out.println("Invalid position!");
        else {
            IntDoubleListElement removeElement = getElement(pos);
            if(removeElement.prev == null)
                head = head.next;
            else
                removeElement.prev.next = removeElement.next;
            if(removeElement.next == null)
                tail = tail.prev;
            else
                removeElement.next.prev = removeElement.prev;
            size --;
        }
    }

    public void appendList(IntDoubleList other) {
        if(size==0) head = other.head;
        else tail.next = other.head;
        if(other.size()!=0){
            other.head.prev = tail;
            tail = other.tail;
        }
    }

    public String toString() {
       StringBuilder result = new StringBuilder();
       for(int i=0;i<size;i++){
           if(head != null) result.append(head.getInfo());
           if(head.next!=null) result.append(",");
           head=head.next;
       }
       return result.toString();
    }

    public boolean isEqual(IntDoubleList other) {
        if(size == other.size()){
            boolean same = true;
            for(int i=0;i<size;i++){
                if (head.getInfo() != other.head.getInfo()) {
                    same = false;
                    break;
                }
                head=head.next;
                other.head = other.head.next;
            }
            return same;
        }
        return false;
    }

    public int sum() {
        int mySum=0;
        for(int i=0; i<size;i++){
            mySum += head.getInfo();
            head=head.next;
        }
        return mySum;
    }

    public IntDoubleList copy() {
        IntDoubleList result = new IntDoubleList();
        for(IntDoubleListElement i = head;i != null; i=i.next){
            result.append(i.getInfo());
        }
        return result;
    }
}
