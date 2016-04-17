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

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author nirav_000
 *
 */
public class ThreadExecutoreExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Server server=new Server();
        for (int i=0; i<100; i++){
        Task task=new Task("Task "+i);
        server.executeTask(task);
        }
        server.endServer();
    }

}

class Server {

    private final ThreadPoolExecutor executor;

    public Server(){
  //  executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d\n",executor.getTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }

}

