package com.example.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author byw
 * @description: 精确唤醒线程
 * @date 2020/12/419:03
 */
public class LockConditionDemo {


    public static void main(String[] args) {


    }

    class FutureTest implements Callable{


        @Override
        public Object call() throws Exception {
            return null;
        }
    }
}
