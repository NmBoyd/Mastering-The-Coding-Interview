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

    /**
     * Synchronized Methods 
     * Most commonly, we restrict access to shared resources through the use of the `synchronized`
     * keyword. It can be applied to methods and code blocks, and restricts multiple threads from
     * executing the code simultaneous on the smae object.
     */

    public class MyClass extends Thread {
        private String name;
        private MyObject myObj;

        public MyClass (MyObject obj, String n) {
            name = n;
            myObj = obj;
        }

        public void run() {
            myObj.foo(name);
        }
    }

    public class MyObject {
        public synchronized void foo(String name) {
            try {
                System.out.println("Thread "+name+".foo(): starting");
                Thread.sleep(3000);
                System.out.println("Thread "+name+".foo(): ending");
            }
            catch (InterruptedException exc) {
                System.out.println("Thread "+name+": interrupted");
            }
        }
    }
    /**
     * Two insances of MyClass can call foo at the same time. But only if they hold different references
     */
    // Different references - both threads can call MyObject.foo()
    MyObject obj1 = new MyObject();
    MyObject obj2 = new MyObject();
    MyClass thread1 = new MyClass(obj1, "1");
    MyClass thread2 = new MyClass(obj2, "2");
    thread1.start();
    thread2.start();

    // Same reference to obj. Only one will be allowed to call foo, and the other will wait
    MyObject obj = new MyObject();
    MyClass thread1 = new MyClass(obj, "1");
    MyClass thread2 = new MyClass(obj, "2");
    thread1.start();
    thread2.start();

    /**
     * Static methods synchronize on the `class lock`. The two threads above could not simultaneously
     * execute synchronized static methods on the same class, even if one is calling foo and the other  
     * is calling bar.
     */
    public class MyClass extends Thread {
        // ...
        public void run() {
            if (name.equals("1")) {
                MyObject.bar(name);
            }
            else if(name.euqals("2")) {
                MyObject.bar(name);
            }
        }
    }

    public class MyObject {
        public static synchronized void foo(String name) {
            // Same as before
        }

        public static synchronized void bar(String name) {
            // Same as foo
        }
    }

    // On Run:
    // Thread 1.foo(): starting 
    // Thread 1.foo(): ending
    // Thread 2.bar(): starting
    // Thread 2.bar(): ending  


    /**
     * Synchronized Blocks
     * Block of code can be synchronized. This operates very similarly to synchronizing a method
     */
    public class MyClass extends Thread {
        // ...
        public void run() {
            myObj.foo(name);
        }
    }
    public class MyObject {
        public void foo(String name) {
            synchronized(this) {
                // ...
            }
        }
    }
    /**
     * That means that, if thread1 and thread2 have the same instance of MyObject, only
     * one will be allowed to execute the code block at a time.
     */

    /**
     * Locks
     * Locks can be used for more granular control. A lock (or monitor) is used to synchronize
     * access to a shared resource by associating the resource with the lock. A thread gets
     * access to a shared resource by first acquiring the lock associated with the resource. At
     * any given time, at most one thread can hold the lock and, therefore, only one thread can
     * access the shared resource
     * 
     * Common use case for locks is when a resource is accessed from multipe places, but should
     * only be accessed by one thread at a time.
     */
    public class LockedATM {
        private Lock lock;
        private int balance = 100;

        public LockedATM() {
            lock = new ReentrantLock();
        }

        public int withdraw(int value) {
            lock.lock();
            int temp = balance;
            try {
                Thread.sleep(100);
                temp = temp-value;
                Thread.sleep(100);
                balance = temp;
            }
            catch (InterruptedException exc) {
            }

            lock.unlock();
            return temp;
        }

        public int deposit(int value) {
            lock.lock();
            int temp = balance;
            try {
                Thread.sleep(100);
                temp = temp+value;
                Thread.sleep(300);
                balance = temp;
            }
            catch (InterruptedException exc){

            }
            lock.unlock();
            return temp;
        }
    }

    /**
     * Deadlocking is a situation where a thread is waiting for an object lock that 
     * another thread holds and this second thread is waiting for an object lock that
     * the first thread holds (or an equivalent situation with several threads).
     */