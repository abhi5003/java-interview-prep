package abhi.java.code.concurrency_multithreading;

import java.util.*;

public class Concurrenthashmap {


    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
        MapHelper1 mapHelper1 = new MapHelper1(syncMap);
        MapHelper2 mapHelper2 = new MapHelper2(syncMap);
        MapHelper3 mapHelper3 = new MapHelper3(syncMap);
        MapHelper4 mapHelper4 = new MapHelper4(syncMap);


        for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }


}



class MapHelper1 implements Runnable {
    Map<String, Integer> map;

    public MapHelper1(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        map.put("Two", 2);
        try {
            System.out.println("MapHelper1 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class MapHelper2 implements Runnable {
    Map<String, Integer> map;

    public MapHelper2(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper2").start();
    }

    public void run() {
        map.put("Two", 2);
        try {
            System.out.println("MapHelper2 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


class MapHelper3 implements Runnable {
    Map<String, Integer> map;

    public MapHelper3(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper3").start();
    }

    public void run() {
        map.put("Three", 3);
        try {
            System.out.println("MapHelper3 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


class MapHelper4 implements Runnable {
    Map<String, Integer> map;

    public MapHelper4(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper4").start();
    }

    public void run() {
        map.put("four", 4);
        try {
            System.out.println("MapHelper4 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


