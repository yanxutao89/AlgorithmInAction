package others;

import java.util.concurrent.Semaphore;

/*Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.



Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.*/
public class PrintFooBarAlternately {

	private int n;
	private Semaphore foo;
	private Semaphore bar;

    public PrintFooBarAlternately(int n) {
        this.n = n;
        this.foo = new Semaphore(1);
        this.bar = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

        	foo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        	bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

        	bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	foo.release();
        }
    }

    private int n2;
    private int current;
    private Object mutex;

    public void PrintFooBarAlternately2(int n2) {
        this.n = n2;
        this.current = 1;
        this.mutex = new Object();
    }

    public void foo2(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(mutex) {

                while(current % 2 == 0){
                    mutex.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();
                current++;
                mutex.notifyAll();
            }

        }
    }

    public void bar2(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(mutex) {

                while(current % 2 != 0) {
                    mutex.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBar.run();
                current++;
                mutex.notifyAll();
            }
        }
    }
}
