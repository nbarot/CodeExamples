/*******************************************************************************
 * Copyright (c) 2015 Andrey Loskutov. All rights reserved.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Andrey Loskutov - initial API and implementation
 *******************************************************************************/
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nirav_000
 *
 */
public class ThreadTest1 {

    static AtomicInteger sharedVariable = new AtomicInteger();
    static int nonAtomicShared = 0 ;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Lock lock = new ReentrantLock();

        Runnable r1 = () -> {
            System.out.println("Hello World" + Thread.currentThread().getName()+" Start. Command = ");

            for(int i = 1; i <= 1000; i++) {
                sharedVariable.getAndIncrement();
                nonAtomicShared++ ;
            }
            System.out.println("sharedVariable = " + sharedVariable.get() + " nonAtomicShared " + nonAtomicShared) ;
            System.out.println(Thread.currentThread().getName()+" End.");
        };

        Runnable r2 = () -> {
            System.out.println("Hello World" + Thread.currentThread().getName()+" Start. Command = ");

            for(int i = 1; i <= 1000; i++) {
                sharedVariable.getAndIncrement();
                nonAtomicShared++ ;
            }
            System.out.println("sharedVariable = " + sharedVariable.get() + " nonAtomicShared " + nonAtomicShared) ;
            System.out.println(Thread.currentThread().getName()+" End.");
        };

        Runnable r3 = () -> {
            System.out.println("Hello World" + Thread.currentThread().getName()+" Start. Command = ");
           // lock.lock();
            try{
                lock.lock();
                for(int i = 1; i <= 10000000; i++) {
                    nonAtomicShared++;
                }
            }finally{
                lock.unlock();
            }

            System.out.println(Thread.currentThread().getName()+" End.");
        };

        Runnable r4 = () -> {
            System.out.println("Hello World" + Thread.currentThread().getName()+" Start. Command = ");
            System.out.println("sharedVariable = " + nonAtomicShared) ;
            System.out.println(Thread.currentThread().getName()+" End.");
        };

       // new Thread(r1).start();
       // new Thread(r2).start();

        new Thread(r3).start();
        new Thread(r4).start();

    }



}
