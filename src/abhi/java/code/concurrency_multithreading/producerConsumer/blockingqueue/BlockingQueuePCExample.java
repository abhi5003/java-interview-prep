package abhi.java.code.concurrency_multithreading.producerConsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePCExample {
 
   public static void main(String[] args) { 
 
       BlockingQueue<String> queue=new ArrayBlockingQueue<>(5);
       Producer producer=new Producer(queue); 
       Consumer consumer=new Consumer(queue); 
       Thread producerThread = new Thread(producer); 
       Thread consumerThread = new Thread(consumer); 
 
       producerThread.start(); 
       consumerThread.start(); 
 
   } 
 
   static class Producer implements Runnable { 
 
       BlockingQueue<String> queue=null; 
 
       public Producer(BlockingQueue queue) { 
           super(); 
           this.queue = queue; 
       } 
 
       @Override 
       public void run() { 
 
               try {

                   for(int i=1; i<=10; i++){
                       System.out.println("Producing element " + i);
                       queue.put("Element " + i);
                       Thread.sleep(1000);
                   }

               } catch (InterruptedException e) { 
 
                   e.printStackTrace(); 
               } 
       } 
   } 
 
   static class Consumer implements Runnable { 
 
       BlockingQueue<String> queue=null; 
 
       public Consumer(BlockingQueue queue) { 
           super(); 
           this.queue = queue; 
       } 
 
       @Override 
       public void run() { 
 
           while(true) 
           { 
               try { 
                   System.out.println("Consumed "+queue.take()); 
               } catch (InterruptedException e) { 
                   e.printStackTrace(); 
               } 
           } 
       } 
 
   } 
} 