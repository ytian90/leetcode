package leetcode.mj.airbnb;

import java.util.HashMap;
import java.util.Map;

/**
 * 7. File System
 */
public class FileSystem {
    Map<String, Integer> pathMap;
    Map<String, Runnable> callbackMap;

    public FileSystem() {
        this.pathMap = new HashMap<>();
        this.callbackMap = new HashMap<>();
        this.pathMap.put("", 0);
    }

    public boolean create(String path, int value) {
        if (pathMap.containsKey(path)) {
            return false;
        }
        int lastSlashIndex = path.lastIndexOf("/");
        if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
            return false;
        }
        pathMap.put(path, value);
        return true;
    }

    public boolean set(String path, int value) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        pathMap.put(path, value);

        // Trigger callback
        String currPath = path;
        while (currPath.length() > 0) {
            if (callbackMap.containsKey(currPath)) {
                callbackMap.get(currPath).run();
            }
            int lastSlashIndex = currPath.lastIndexOf("/");
            currPath = currPath.substring(0, lastSlashIndex);
        }
        return true;
    }

    public Integer get(String path) {
        if (!pathMap.containsKey(path)) {
            return -1;
        }
        return pathMap.get(path);
    }

    public boolean watch(String path, Runnable callback) {
        if (!pathMap.containsKey(path)) {
            return false;
        }
        callbackMap.put(path, callback);
        return true;
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.create("/a", 1);
        System.out.println(fileSystem.get("/a"));
        fileSystem.create("/a/b", 2);
        System.out.println(fileSystem.get("/a/b"));
        fileSystem.watch("/a", new Runnable(){
            @Override
            public void run() {
                System.out.println("yes");
            }});
        fileSystem.watch("/a/b", new Runnable(){
            @Override
            public void run() {
                System.out.println("no");
            }});
        fileSystem.set("/a/b", 3);
        System.out.println(fileSystem.get("/a/b"));
        System.out.println(fileSystem.create("/c/d", 1));
        System.out.println(fileSystem.get("/c"));
    }
}
