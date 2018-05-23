package com.java.threads.sychronized.classes;

import com.java.threads.sychronized.statics.SyncThread;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class Test {
    /*
 A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
   */
    public static void main(String[] args) {
        com.java.threads.sychronized.statics.SyncThread syncThread1 = new com.java.threads.sychronized.statics.SyncThread();
        com.java.threads.sychronized.statics.SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
