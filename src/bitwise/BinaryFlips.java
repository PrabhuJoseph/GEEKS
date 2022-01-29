package bitwise;

public class BinaryFlips {

  // https://leetcode.com/discuss/interview-question/386726/Binary-String-flip-to-Zero-string-or-ThoughtSpot/347969

  /*

Given a binary string of size N and a positive integer K, calculate the number of operations required to convert this string to
zero string by applying the following operation any number of times.
Operation: Let X is the index of first ‘1’ bit from left side, then Flip all the X’th, X+K, X+2K, X+3K… bits of string.
1 <= N <= 10^6
1 <= K <= N

Sample:
Input: 100010010011110, K = 2
Step-1: 001000111001011
Step-2: 000010010011110
Step-3: 000000111001011
Step-4: 000000010011110
Step-5: 000000000110100
Step-6: 000000000011110
Step-7: 000000000001011
Step-8: 000000000000001
Step-9: 000000000000000

Output=9


   */
}
