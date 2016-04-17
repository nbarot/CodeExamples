/*******************************************************************************
 * Copyright (c) 2014 Andrey Loskutov. All rights reserved.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Andrey Loskutov - initial API and implementation
 *******************************************************************************/
package concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author nirav_000
 *
 */
public class Task implements Runnable{

    private final Date initDate;
    private final String name;

    public Task(String name) {
        initDate=new Date();
        this.name=name;
    }

    @Override
    public void run() {

        System.out.printf("%s: Task %s: Created on: %s\n",Thread.
                currentThread().getName(),name,initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",Thread.
                currentThread().getName(),name,new Date());

        try {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.
                currentThread().getName(),name,new Date());
    }



}
