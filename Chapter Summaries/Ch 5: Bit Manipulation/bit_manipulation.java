/**
Work throigh the following operations through a base 10 number. You can apply the same process as
a binary number. Remeber that ^ indicates an XOR operation, and ~ is a not (negation) operation.
For simplicity, assume that these are four-bit numbers. The third column can be solved manually
or with "tricks"

0110+0010=1000 | 0011*0101=1111 | 0110+0110=1100
0011+0010=0101 | 0011*0011=1001 | 0100*0011=1100
0110-0011=0011 | 1101 >> 2=0011 | 1101 ^ (~1101)=1111
1000-0110=0010 | 1101^0101=1000 | 1011 & (~0 << 2)=1000

Column 3 tricks: 
1. 0110+0110 is equivalent to 0110*2, which is equivalent to shifting 0110 left by 1
2. Since 0100 equals 4, we are just multiplying 0011 by 4. Multiplying by 2^n just shifts
a number by n. we shift 0011 by 2 to get 1100
3. Think about this operation bit by bit. If you XOR a bit with its own negated value, you 
will always get 1. Therefore, the solution to a^(~a) will be a sequence of 1's
4. An operation like x & (~0 << n) clears the n rightmost bits of x. The value
~0 is simply a sequence of 1's so by shifting it left by n, we have a bunch of ones 
followed by n zeros. By doing an AND with x, we clear the rightmost n bits of x.
*/

/**
Bit Facts and Tricks
1s and 0s represent sequences. Remember that the operations occur bit-by-bit.
i.e: if true for 1 bit, it's true for a sequence of bitss

x^0s=x : x & 0s=0 : x|0s=x
x^1s=~x : x & 1s=x : x|1s=1s
x^x=0 : x & x=x : x|x=x 
*/

/**
 * Get, Set, Clear, and Update bits
 */

//  Get: Shifts 1 over by i bits by performing an AND with num to clear all bits other than i
boolean getBit(int num, int i){
    return ((num & (1 << i)) != 0);
}

// Set: Shifts 1 over by i bits by performing an OR with num so only bit i will change
int setBit(int num, int i) {
    return num | (1 << i);
}

// Clear bit: Reverse of Set. Create a number like 11101111 by creatubg the reverse (00010000) and negating.
// then perform AND with num to clear the ith bit and leave the remainder unchanged
int clearBit(int num, int i) {
    int mask = ~(1 << i);
    return num & mask;
}
// Clear all bits from the most significant bit through i(inclusive)
int clearBitMSBthroughI(int num, int i) {
    int mask = (1 << i) - 1;
    return num & mask;
}
// Clear all the bits from i through 0 (inclusive)
int clearBitsIthrough0(int num, int i) {
    int mask = ~((1 << (i+1)) - 1);
    return num & mask;
}

// Update: Merges setBit and clearBit. First clear the bit at i by using a mask that looks like 1110111
// then shift the intended value, v, left by i bits. This will create a number with bit i equal to v
// and all other bits equal to 0. Finally, we OR these two numbers, updating the ith bit if v is 1 and leaving
// it as 0 otherwise.
int updateBit(int num, int i, int v) {
    int mask = ~(1 << i);
    return (num & mask) | (v << i);
}