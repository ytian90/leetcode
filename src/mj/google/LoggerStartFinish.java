package mj.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一个Class叫Logger，它有两个函数，一个是LogStart(int logId, int timestamp)，一个是LogFinish(int logId, int timestamp)。
 * Log开始时LogStart会被调用，log结束时LogFinish会被调用。要求是实现这两个函数，并打印已经结束的log，打印log时要按log的开始时间排序。
 */
public class LoggerStartFinish implements Logger {
    private class Node{
        String id;
        long start;
        long end;
        Node prev;
        Node next;
        public Node(String id, long start) {
            this.id = id;
            this.start = start;
            end = -1;
        }
    }

    Node head, tail;
    Map<String, Node> map;
    public LoggerStartFinish() {
        head = new Node("", -1);
        tail = new Node("", -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    @Override
    public void started(long time, String id) {
        Node curr = new Node(id, time);
        map.put(id, curr);
        add(curr);
    }

    @Override
    public void finished(long time, String id) {
        Node curr = map.get(id);
        if (curr != null && curr.end == -1) {
            curr.end = time;
            map.remove(id);
        }
    }

    @Override
    public void print() {
        Node curr = head.next;
        while (curr != tail) {
            if (curr.end != -1) {
                System.out.println(curr.id + " start at " + curr.start + " end at " + curr.end);
            }
            curr = curr.next;
        }
    }

    private void add(Node curr) {
        if (curr == null) {
            return;
        }
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev.next = curr;
        tail.prev = curr;
    }

    public static void main(String[] args) {
        LoggerStartFinish logger = new LoggerStartFinish();
        logger.started(100, "1");
        logger.started(101, "2");
        logger.finished(102, "2");
        logger.started(103, "3");
        logger.finished(104, "1");
        logger.finished(105, "3");
        logger.print();
    }
}

interface Logger {
    void started(long timestamp, String requestId);
    void finished(long timestamp, String requestId);
    void print();
}
