
package datastructure;


public class TheStack<T> implements Stack<T> {

    private T[] stackArray;
    private int top = -1 ;

    public TheStack(T[] stackArray) {
        this.stackArray = stackArray;
    }

    public T pop() {

        if(top >= 0) {
            T topItem = stackArray[top] ;
            stackArray[top--] = null ;
            return topItem ;
        } else {
            System.out.println("There is no item to remove, stack is empty.");
        }
        return null;

    }


    @Override
    public void push(T item) {
        if(top < stackArray.length) {
            stackArray[++top] = item ;
        }
    }

    public T peek() {
        if(top >= 0) {
            return stackArray[top] ;
        } else {
            System.out.println("There is no item to remove, stack is empty.");
        }
        return null;
    }

    public void removeAll() {

        for (int i = top;i >= 0; i--) {
            pop();
        }

    }

    public int search(T searchItem) {

        for (int i = top, j=1; i >= 0 ; i--,j++) {

            if(stackArray[i].equals(searchItem)){
                System.out.println("Search item ::" + searchItem + " Found in the array.");
                return j;
            }
        }

        return -1 ;
    }

    public T[] getStackArray() {
        return stackArray;
    }

    public int getTop() {
        return top;
    }
}
