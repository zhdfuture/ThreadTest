package zh;

public class TestDeadLock {
    public static void main(String[] args) {
        final  Book book=new Book();
        final  Pen pen=new Pen();
       Thread threadA=new ThreadA(pen,book);
       threadA.setName("A");
       Thread threadB=new ThreadB(pen,book);
       threadB.setName("B");
        threadA.start();
        threadB.start();

    }
}
class Pen{
    private String name="笔";

    public String getName() {
        return name;
    }
}
class Book{
private String name="本";

    public String getName() {
        return name;
    }
}
class ThreadA extends Thread {
private final Pen pen;
private final Book book;
ThreadA(Pen pen,Book book){
    this.pen=pen;
    this.book=book;
}
    public void run() {
    synchronized (this.pen){
        System.out.println(Thread.currentThread().getName()+"有笔，缺个本");
        synchronized (this.book){
            System.out.println(Thread.currentThread().getName() + " 有笔，有本");
        }
    }

        }

    }
    class ThreadB extends Thread {
        private final Pen pen;
        private final Book book;

        ThreadB(Pen pen, Book book) {
            this.pen = pen;
            this.book = book;
        }

        public void run() {
            synchronized (this.book) {
                System.out.println(Thread.currentThread().getName() + "有本，缺个笔");
                synchronized (this.pen) {
                    System.out.println(Thread.currentThread().getName() + " 有笔，有本");
                }

            }
        }
    }

    //为防止死锁，可以加个时间sleep()，则大部分不会死锁