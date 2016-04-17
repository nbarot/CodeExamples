package datastructure;

/**
 * Created by nirav_000 on 10/4/2015.
 */
public class StackNode<E> {

    private E item;
    private StackNode<E> next = null;

    public StackNode(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }
}
