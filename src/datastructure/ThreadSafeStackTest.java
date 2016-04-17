package datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * Created by nirav_000 on 10/11/2015.
 */
public class ThreadSafeStackTest {

    private Executor stackExector ;
    private ThreadSafeStack<String> threadSafeStack;
    private CyclicBarrier cyclicBarrier;

    @Before
    public void setUp(){
       // stackExector = Executors.newFixedThreadPool(4);
        threadSafeStack = new ThreadSafeStack<>();

    }

    @Test
    public void testPop() throws Exception {

        testPush();

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                threadSafeStack.displayStack();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.pop();
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.pop();
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.pop();
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.pop();
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.pop();
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Test
    public void testPush() throws Exception {

        cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                threadSafeStack.displayStack();
            }
        });

       new Thread(new Runnable() {
           @Override
           public void run() {
               threadSafeStack.push("Nirav");
               try {
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }
       }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.push("Purvi");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.push("Prisha");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafeStack.push("Bheem");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }

    @Test
    public void testPeek() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testSearch() throws Exception {

    }
}