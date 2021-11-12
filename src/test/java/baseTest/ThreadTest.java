package baseTest;

import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName ThreadTest
 * @date 2021-10-15 14:33:34
 */
public class ThreadTest {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("i=" + (i + 1));
                if (this.isInterrupted()) {
                    System.out.println("通过this.isInterrupted()检测到中断");
                    System.out.println("第一个interrupted()" + this.interrupted());
                    System.out.println("第二个interrupted()" + this.interrupted());
                    break;
                }
            }
            System.out.println("因为检测到中断，所以跳出循环，线程到这里结束，因为后面没有内容了");
        }


    }

    @Test
    void test1() {
        MyThread myThread=new MyThread();
        myThread.start();
        myThread.interrupt();
        //sleep等待一秒，等myThread运行完
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myThread线程是否存活："+myThread.isAlive());
    }
}
