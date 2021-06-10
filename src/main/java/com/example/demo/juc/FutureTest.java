package com.example.demo.juc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FutureTest {

        public static void main(String[] args) {
            Future<String> future = invoke(() -> {
                try {
                    Thread.sleep(10000L);
                    return "I am Finished.";
                } catch (InterruptedException e) {
                    return "I am Error";
                }
            });
            future.setCompletable(new Completable<String>() {
                @Override
                public void complete(String s) {
                    System.out.println(s);
                }

                @Override
                public void exception(Throwable t) {
                    t.printStackTrace();
                }
            });
            System.out.println(future.get());
        }

        private static <T> T block(Callable<T> callable) {
            return callable.action();
        }

        private static <T> Future<T> invoke(final Callable<T> callable) {
            AtomicReference<T> result = new AtomicReference<>();
            AtomicBoolean finished = new AtomicBoolean(false);
            Future<T> future = new Future<T>() {
                private Completable<T> completable;

                @Override
                public T get() {
                    return result.get();
                }

                @Override
                public boolean isDone() {
                    return finished.get();
                }

                @Override
                public void setCompletable(Completable<T> completable) {
                    this.completable = completable;
                }

                @Override
                public Completable<T> getCompltable() {
                    return completable;
                }
            };
            Thread t = new Thread(() -> {
                try {
                    T value = callable.action();
                    result.set(value);
                    finished.set(true);
                    if (future.getCompltable() != null) {
                        future.getCompltable().complete(value);
                    }
                } catch (Throwable cause) {
                    if (future.getCompltable() != null) {
                        future.getCompltable().exception(cause);
                    }
                }
            });
            t.start();
            return future;
        }

        private interface Future<T> {
            T get();

            boolean isDone();

            void setCompletable(Completable<T> completable);

            Completable<T> getCompltable();
        }

        private interface Callable<T> {
            T action();
        }

        private interface Completable<T> {
            void complete(T t);

            void exception(Throwable t);
        }


}
