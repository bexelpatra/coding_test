package com.test.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class ThreadSafe {
    public void test(){
        int loop = 30;
        CountDownLatch countDownLatch = new CountDownLatch(loop);
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        // thread safe 하지 않다
        Map<String, LongAdder> map = new HashMap<>();
        // thread safe 하다
        Map<String,LongAdder> map2 = Collections.synchronizedMap(new HashMap<>());
        Map<String,LongAdder> map3 = new ConcurrentHashMap<>();

        Random random = new Random();
        String x = "이것은 숫자 : ";
        IntStream intStream = IntStream.generate(() -> random.nextInt(100)).limit(1000);

        for(int i=0; i<loop; i++){
            int type = i%3;
            executorService.submit(new Task(String.valueOf(type),countDownLatch,map));
            executorService.submit(new Task(String.valueOf(type),countDownLatch,map2));
            executorService.submit(new Task(String.valueOf(type),countDownLatch,map3));
        }
        System.out.println(map.toString());
        System.out.println(map2.toString());
        System.out.println(map3.toString());
        executorService.shutdown();
    }

    static class Task implements Runnable{
        private final String taskNo;
        private final CountDownLatch countDownLatch;
        private Map<String,LongAdder> map;

        public Task(String taskNo, CountDownLatch countDownLatch, Map<String, LongAdder> map) {
            this.taskNo = taskNo;
            this.countDownLatch = countDownLatch;
            this.map = map;
        }

        @Override
        public void run() {
            try{
                map.computeIfAbsent(taskNo,s -> new LongAdder()).increment();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
            System.out.println(countDownLatch.getCount());
        }
    }
}
