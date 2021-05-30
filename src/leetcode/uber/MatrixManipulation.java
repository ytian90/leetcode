package leetcode.uber;

/**
 * Matrix manipulation
 *      input: 2-D array with shape 4x(4*n). 每个4*4，non-overlapping 的为一个block。每个block里会有一个'?' . 每个block出现的所有数（除了问号）set(1～16), missing one number to fill in '?'.
 *      Goal: find the missing element and fill in '?', and re-organize the blocks so that it's sorted by this missing value. If two blocks have the same missing value, then keep them in their original relevant order.
 *      Output: Still a 4x(4*n) 2-D Array.
 *      Example input:
 *                [['1','2','3','4', '16','15','14','13'],
 *                 ['?','6','7','8', '12','11','10','9' ],
 *                 ['9','10','11','12' ,'8','7','6','5' ],
 *                 ['13','14','15','16','4','3','2','?' ]]
 *                    Output:
 *                [['16','15','14','13','1','2','3','4'],
 *                 ['12','11','10','9' ,'5','6','7','8'],
 *                 [ '8','7','6','5', '9','10','11','12'],
 *                 [ '4','3','2','1', '13','14','15','16']]
 */
public class MatrixManipulation {
}
