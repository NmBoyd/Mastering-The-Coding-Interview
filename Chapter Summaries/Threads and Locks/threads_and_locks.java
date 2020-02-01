/**
 * Threads can be created in two ways
 * 1. Implementing the lava.lang.Runnable interface
 * 2. Extending the java.lang.Thread class
 */

 /**
  * Implementing the Runnable interface
  * 1. Create a class which implements the Runnable interface. An object of this class is
  * a Runnable object
  * 2. Create an object of type Thread by passing a Runnable object as an argument to the 
  * thread constructor. The thread object now has a Runnable object that implements the run() method
  */
  public interface Runnable {
      void run();
  }

  /**
   * In this code all we really needed to do is have our class implement the run() method.
   * Another method can then pass an instance of the class to new Thread(obj) and call start()
   * on the thread (line 21)
   */
  public class RunnableThreadExample implements Runnable {
      public int count = 0;

      public void run() {
          System.out.println("RunnableThread starting");
          try {
              while (count < 5) {
                  Thread.sleep(500);
                  count++;
              }
          }
          catch (InterruptedException exc) {
               System.out.println("Runnablethread interrupted");
          }
          System.out.println("RunnableThread Terminating");
      }
  }

  public static void main(String[] args) {
      RunnableThreadExample instance = new RunnableThreadExample();
      Thread thread = new Thread(instance);
      thread.start();

      /* waits until above thread counts to 5 (slowly) */
      while (instance.count != 5) {
          try {
              Thread.sleep(250);
          }
          catch (InterruptedException exc) {
              exc.printStackTrace();
          }
      }
  }


  /**
   * Extending the Thread class
   * Creating a thread by extending the Thread class. This almost always
   * means that we override the run() method, and the subclass may also
   * call the thread constructor explicitly in its constructor
   * 
   * Main differance is that since we are extending Thread class, rather 
   * than just implementing an interface, we cab call start() on the 
   * instance of the class itself
   */
  public class ThreadExample extends Thread {
      int count = 0;

      public void run() {
          System.out.println("Thread starting.");
          try {
              while (count < 5) {
                  Thread.sleep(500);
                  System.out.println("In Thread, count is " + count);
                  count++;
              }
          }
          catch (InterruptedException exc) {
              System.out.println("Thread Interrupted");
          }
          System.out.println("Thread terminating.");
      }
  }

  public class ExampleB {
      public static void main(String args[]) {
          ThreadExample instance = new ThreadExample();
          instance.start();

          while (instance.count != 5) {
              try {
                  Thread.sleep(250);
              }
              catch (InterruptedException exc) {
                exc.printStackTrace();
              }
          }
      }
  }

  /**
   * Extenind the Thread Class vs Implementig the Runnable Interface
   * 
   * When creating threads, there are two reasons why implementing the 
   * Runnable Interface may be preferable to extending the Thread class:
   * 
   * - Java does not support multiple inheritance. Thereforce, extending 
   * the Thread class means that the subclass cannot extend any other class.
   * A class implementing the Runnable interface will be able to extend a class.
   * 
   * - A class might only be interested in being runnable, and therefore, inheriting
   * the full overhead of the Thread class would be excessive 
   */


   /**
    * Synchronization and Locks
    Threads within a given process share the same memory space, which is both a positive
    and a negative. It enables threads to share data, which can be valuable. However, it
    also creates the opportunity for issues when two threads modify a resource at the same
    time. Java provides synchronization in order to control access to shared resources.
    */