package lintcode.systemdesign.chapter10;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.net.*;

public class Crawler {
    ExecutorService pool = Executors.newFixedThreadPool(3);;
    AtomicLong numTasks = new AtomicLong(0);  // wait for all task to finish
    Lock lock = new ReentrantLock();  // to protect ans::List<String> and visited::Set<String>.
    List<String> ans = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    private class crawlTask implements Runnable {
        String url;
        public crawlTask (String u) {
            url = u;
        }
        @Override
        public void run () {
            try {
                for (String neighbor : HtmlHelper.parseUrls(url)) {
                    URL neighborURL = new URL(neighbor);
                    if (!neighborURL.getHost().endsWith("wikipedia.org")) continue;  // may throw exception
                    lock.lock();
                    if (!visited.contains(neighbor)) {  // found new URL to crawl
                        visited.add(neighbor);
                        ans.add(neighbor);
                        pool.execute(new crawlTask(neighbor));
                        numTasks.incrementAndGet();
                    }
                    lock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                numTasks.decrementAndGet();
            }
        }
    }

    public List<String> crawler (String url) {
        visited.add(url);
        ans.add(url);
        pool.execute(new crawlTask(url));
        numTasks.incrementAndGet();
        try {
            while (numTasks.get() != 0) Thread.sleep(3000);;  // wait until no more tasks
        } catch (Exception e) { e.printStackTrace(); }
        pool.shutdown();  // otherwise program won't stop
        return ans;
    }
}

class HtmlHelper {
    public static List<String> parseUrls(String url) {return null;}
}