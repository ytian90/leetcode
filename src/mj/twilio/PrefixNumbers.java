package mj.twilio;

/**
 * Given two arrays of strings, one containing the prefixes (area code) and one with a long string of numbers
 * (phone numbers), return the longest prefix corresponding to all phone numbers.
 *
 * Input: Area Code: ["213", "21358", "1234", "12"]
 * Phone Numbers: ["21349049", "1204539492", "123490485904"]
 * Output: ['213', '12', '1234']
 * Solution: Use Trie to store all the prefix strings and then search for the phone numbers in the prefix tree
 * (This solution passed all test cases)
 * Note: Keep in mind that Phone Numbers array can be very long
 *
 * https://leetcode.com/discuss/interview-question/394697/Twilio-or-OA-2019
 */
public class PrefixNumbers {
    
}
