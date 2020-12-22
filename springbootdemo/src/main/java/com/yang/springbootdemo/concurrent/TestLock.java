package com.yang.springbootdemo.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * </br>
 * Created by yangxiaohua on 2020/11/9.
 */
public class TestLock {

  public static void main(String[] args) {
    Ticket ticket = new Ticket();

    new Thread(ticket, "1号窗口").start();
    new Thread(ticket, "2号窗口").start();
    new Thread(ticket, "3号窗口").start();
  }
}

class Ticket implements Runnable {

  private int tick = 10;

  private Lock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true) {

      //      lock.lock();

      try {

        synchronized (this) {
          if (tick > 0) {
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 完成售票，余票为 " + --tick);
          }
        }
      } finally {
        //        lock.unlock();
      }

    }
  }
}