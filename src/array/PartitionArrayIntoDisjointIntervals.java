package array;

/**
 * 915. Partition Array into Disjoint Intervals
 */
public class PartitionArrayIntoDisjointIntervals {

    public static int partitionDisjoint(int[] A) {
        int localMax = A[0], max = localMax, partitionIdx = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < localMax) {
                localMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, A[i]);
            }
        }
        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
    }

    /*
    suppose the original left subarray is from 0 to partitionIdx,
    the max value of that is localMax. If it is a isMidValTooSmall partition,
    every value from partitionIdx + 1 to end should be >= localMax.
    But if we find a value in the right part, a[i], is smaller than
    localMax, which means the partition is not correct and we have to
    incorporate a[i] to form the left subarray. So the partitionIdx
    is set to be i, and we have to recalculate the max value of the
    new left subarray.(recorded in max)
     */
}
