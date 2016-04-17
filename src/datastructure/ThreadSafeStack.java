
package datastructure;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadSafeStack<E> implements Stack<E> {

    private AtomicReference<StackNode> head ;
    private  CyclicBarrier cyclicBarrier;

    public ThreadSafeStack() {
        head = new AtomicReference<>();
    }


    @Override
    public E pop() {

        StackNode<E> headNode = head.get() ;
        StackNode<E> newHead = null;
        E item;
        do{
            headNode = head.get() ;
            if(headNode == null) {
                System.out.println("Stack is empty.");
                return null;
            }
            newHead = headNode.getNext();
            item = headNode.getItem();
        }while (!head.compareAndSet(headNode, newHead));
        System.out.println("Popped item :: " + item);
        return item;
    }

    @Override
    public void push(E item) {
        StackNode<E> newHead = new StackNode<>(item);
        StackNode<E> headNode = null;
        do{
            headNode = head.get();
            if(headNode != null){
                newHead.setNext(headNode);
            }

        } while (!head.compareAndSet(headNode, newHead));

       // displayStack();
    }

    public void displayStack() {
        StackNode<E> node = head.get();
        if(node != null){
            System.out.println("Items in the Stack : " + node.getItem());
            while(node.getNext() != null){
                node = node.getNext();
                System.out.println("Items in the Stack : " + node.getItem());
            }
        } else {
            System.out.println("The stack is empty. Nothing to display.");
        }

    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public int search(E searchItem) {
        return 0;
    }
}
