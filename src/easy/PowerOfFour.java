package easy;
/*
Problem : https://leetcode.com/problems/power-of-four/
Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true
 */
/*
Solution :
use bit manipulation to check if the given integer has exactly one set bit
and that the count of zero bits before the set bit is even.

A power of four cannot be negative or zero, so return false if the input n is either of those values.
The bitwise AND operator (&) returns a bit set to 1 if both corresponding bits in the operands are set to 1, and 0 otherwise.
The expression n & (n - 1) is zero if and only if n has exactly one set bit.
The loop counts the number of zero bits before the (only) set bit in n.
The bitwise OR operator (|) returns a bit set to 1 if either or both corresponding bits in the operands are set to 1, and 0 otherwise.
The expression (n & (1 << count)) == 0 is true if the bit at position count in n is zero.
If the count of zero bits before the (only) set bit is even, then n is a power of four. Otherwise, n is not a power of four.
 */
public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
    }
    //resolve power of four
    public static boolean isPowerOfFour(int n) {
        // Check if n is negative or zero.
        if (n <= 0) {
            return false;
        }
        // Check if n has only one set bit.
        if ((n & (n - 1)) != 0) {
            return false;
        }
        // Check if the count of zero bits before the (only) set bit is even.
        int count = 0;
        while ((n & (1 << count)) == 0) {
            count++;
        }
        return count % 2 == 0;
    }
}
