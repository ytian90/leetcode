package lintcode.systemdesign.chapter3;

import java.util.*;

/**
 * 526. Load Balancer
 */
public class LoadBalancer {
    int serverCount = 0;
    Map<Integer, Integer> map = new HashMap<>(); // number, location
    List<Integer> servers = new ArrayList<>();
    Random rand = new Random();

    public LoadBalancer() {
        // do intialization if necessary
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if (!map.containsKey(server_id)) {
            servers.add(server_id);
            map.put(server_id, servers.size() - 1);
            serverCount++;
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if (!map.containsKey(server_id)) {
            return;
        }
        int lastServer = servers.get(servers.size() - 1);
        int toDelServerLoc = map.get(server_id);
        servers.set(toDelServerLoc, lastServer);
        map.put(lastServer, toDelServerLoc);
        map.remove(server_id);
        servers.remove(serverCount -1);
        serverCount--;
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        return servers.get(rand.nextInt(serverCount));
    }
}
