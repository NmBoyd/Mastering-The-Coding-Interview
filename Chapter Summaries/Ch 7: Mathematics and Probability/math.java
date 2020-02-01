/**
 * Prime numbers
 * 
 * Every positive integer can be decomposed into a product of primes
 * e.g: 84 = 2^2 * 3^1 * 5^0 * 7^1 * 11^0 * 13^0 * 17^0 *...
 */

 // Divisibility
 // x = 2^j0 * 3^j1 * 5^j2 * 7^j3 * 11^j4
 // y = 2^k0 * 3^k1 * 5^k2 * 7^k3 * 11^k4
 // if x/y, then for all i, ji <= ki

 // greatest common divisor of x and y:
 // gcd(x,y) = 2^min(j0,k0) * 3^min(j1,k1) * 5^min(j2,k2) * ...
 // least common divisor of x and y   
 // lcm(x,y) = 2^max(j0,k0) * 3^max(j1,k1) * 5^max(j2,k2) * ...

 // gcd * lcm = xy


 /**
  * Check for primality
  * Iterate up through the square root of n. Check for divisibility
  */
  boolean primeCheck(int n) {
    if(n < 2) {
        return false;
    }
    // we only need to go to sqrt(n) because we would have already proved the second half of the condition
    int sqrt = (int)Math.sqrt(n);
    for (int i=2; i<=sqrt; i++) {
        if (n%i == 0) return false;
    }
    return true;
  }

/**
 * Generating a list of primes: The Sieve of Eratosthenes
 * - A highly efficient way of generating a list of primes. It works by recignizing that all non-prime
 * numbers are divisible by a prime number
 */
boolean[] sieveOfEratosthenes(int max) {
    boolean[] flags = new boolean[max+1];
    int count = 0;
    
    init(flags); // set all the flags to true other than 0 and 1
    int prime = 2;

    while(prime <= max) {
        // cross off remaining multiples of prime
        crossOff(flags, prime);

        // find next value which is trues
        prime = getNextPrime(flags, prime);

        if(prime >= flags.length) {
            break;
        }
    }
    return flags;
}

void crossOff(boolean[] flags, int prime) {
    /**
     * Cross off remaining multiples of prime. We can start with
     * (prime*prime), because if we have k*prime, where
     * k < prime, this value would have already been crossed off 
     * in a prior iteration
     */
    for (int i = prime*prime; i < flags.length; i+= prime) {
        flags[i] = false;
    }
}

int getNextPrime(boolean[] flags, int prime) {
    int next = prime + 1;
    while (next < flags.length && ~ flags[next]) { 
        next++;
    }
    return next;
}
// Could use only odd numbers in the array, which would allow us to half our space
