package leetcode.mj.oracle;

import java.util.Map;

import java.util.*;
import java.util.concurrent.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class PhoneInterview {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java");

        for (String string : strings) {
            System.out.println(string);
        }

        // Call a class method that will take a leetcode.array of objects,
        // and produce a map that maps keys to values where the keys and values
        // are stored in the leetcode.array in pairs.   0-> key 1-> value, 2->key, 3->value, etc.
        List<String> myArray = new ArrayList<String>();
        myArray.addAll(Arrays.asList(new String [] {"key1", "value1", "key2", "value2", "key3", "value3"}));
        Map<String,String> newMap = getMapFromArray(myArray);
        System.out.println(newMap);

        // Create a class to simulate a http server
        // Start the server
        // post 3 requests.
        // request payload is a leetcode.string like "hello"
        // response payload is a leetcode.string with extra text like "hello world".
        // Request call returns a Future object immediately.
        // However the future result is not available for 5 seconds.
        Server myServer = new Server();
        long start = System.currentTimeMillis();
        Future<String> resp1 = myServer.post("hello");
        Future<String> resp2 = myServer.post("hello2");
        Future<String> resp3 = myServer.post("hello3");
        long end = System.currentTimeMillis();
        System.out.println("requests took: " + (end-start) + " millis");
        while (!resp1.isDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // log something
            }
        }

        try {
            System.out.println("request 1 done, response = " + resp1.get());
        } catch (Exception e) {
            // log something
        }
        long resp1DoneTime = System.currentTimeMillis();
        long resp1ElapsedTime = resp1DoneTime - end;
        System.out.println("request 1 response took " + resp1ElapsedTime);

        while (!resp2.isDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // log something
            }
        }

        try {
            System.out.println("request 2 done, response = " + resp2.get());
        } catch (Exception e) {
            // log something
        }

        long resp2ElapsedTime = System.currentTimeMillis() - resp1DoneTime;
        System.out.println("request 2 response took " + resp2ElapsedTime);
    }

    public static Map<String, String> getMapFromArray(List<String> array) {
        Map<String, String> map = new HashMap<>();
        if (array.size() == 0) {
            return map;
        }
        if (array.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < array.size() - 1; i += 2) {
            String key = array.get(i);
            String value = array.get(i + 1);
            map.put(key, value);
        }
        return map;
    }
}

class myClass {
    int count = 0;
}

class Server {


    public Server() {

    }

    private ExecutorService executor = Executors.newFixedThreadPool(3);
    // private ExecutorService executor
    //     = Executors.newSingleThreadExecutor();

    public Future<String> post(String message) {
        return executor.submit(() -> {
            Thread.sleep(3000);
            return message + " world";
        });
    }


}
