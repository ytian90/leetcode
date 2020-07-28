package lintcode.systemdesign.chapter3;

import java.util.*;

/**
 * 520: 一致性哈希2
 */
public class ConsistentHash2 {
    int n, k;
    Map<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    public static ConsistentHash2 create(int n, int k) {
        // Write your code here
        ConsistentHash2 solution = new ConsistentHash2();
        solution.n = n;
        solution.k = k;
        return solution;
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            int randNum = rand.nextInt(n);
            if (!map.containsKey(randNum)) {
                res.add(randNum);
                map.put(randNum, machine_id);
            }
        }
        return res;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        int count = 0;
        while (map.get(hashcode % n) == null && count < n) {
            hashcode++;
            count++;
        }
        return map.get(hashcode % n);
    }

    public static void main(String[] args) {
        ConsistentHash2 consistentHash2 = create(100, 3);
        System.out.println(consistentHash2.addMachine(1));
        System.out.println(consistentHash2.getMachineIdByHashCode(4));
        System.out.println(consistentHash2.addMachine(2));
        System.out.println(consistentHash2.getMachineIdByHashCode(61));
        System.out.println(consistentHash2.getMachineIdByHashCode(91));
    }
}
