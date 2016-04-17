package datastructure;

/**
 * CreaTed by nirav_000 on 10/4/2015.
 */
public interface Stack<E> {

    public E pop();

    public void push(E item);

    public E peek();

    public void removeAll();

    public int search(E searchItem);
}
