package datastructure;

import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Created by nirav_000 on 10/3/2015.
 */
public class TheStackTest {

    private TheStack<String> theStack;
    private String[] stackArray;

    @Before
    public void setUp() throws Exception {
        stackArray = new String[10];
        theStack = new TheStack<String>(stackArray);
    }

    @Test
    public void testPop() throws Exception {

        String nextItem = theStack.pop();
        assertNull(nextItem);

        theStack = fillStack();

        String nextItem1 = theStack.pop();
        assertEquals("6",nextItem1);
        String nextItem2 = theStack.pop();
        assertEquals("5",nextItem2);
        String nextItem3 = theStack.pop();
        assertEquals("4",nextItem3);
        String nextItem4 = theStack.pop();
        assertEquals("3",nextItem4);
        String nextItem5 = theStack.pop();
        assertEquals("2",nextItem5);
    }

    @Test
    public void testPush() throws Exception {

        theStack = fillStack();

        String[] mockedStack = {"2","3","4","5","6",null,null,null,null,null}; ;

        assertArrayEquals(mockedStack, theStack.getStackArray());
    }

    @Test
    public void testPeek() throws Exception {

        theStack = fillStack();

        String topMostItem = theStack.peek();

        assertEquals("6", topMostItem);
    }

    @Test
    public void testRemoveAll() throws Exception {

        theStack = fillStack();

        assertEquals(4,theStack.getTop());

        theStack.removeAll();

        assertEquals(-1,theStack.getTop());

    }

    @Test
    public void testSearch() throws Exception {

        theStack = fillStack();

        assertEquals(4,theStack.search("3"));

    }


    private TheStack fillStack(){

        theStack.push("2");
        theStack.push("3");
        theStack.push("4");
        theStack.push("5");
        theStack.push("6");

        return theStack;
    }
}