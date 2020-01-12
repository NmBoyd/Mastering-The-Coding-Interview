/**
 * Recursion
 * - Follow similar patterns. A good hint that a problem is recursive is that it can be 
 * built off sub-problems.
 * "Design an algorithm to compute the nth..." or "implement a method to compute all..."
 * 
 * - Add, remove, or otherwise change solution for f(n-1)
 */
/**
 * Bottom-up Recursion
 * - We start with knowing how to solve the problem for a simple case, like a list with 
 * one element, and figure out how to solve the problem for two elements, three, etc.
 * Build for the solution for one case off the previous case.
 */
/**
 * Top-Down Recursion
 * - We try to divide the problem for case N into sub-problems. Be careful not to overlap cases
 */

 /**
  * Dynamic Programming
  - Rarely asked. Too hard for a 45min interview. If you struggle, you can try to approach with 
  a recursive solution.
  */

  // Dynamic Prog: Fibonacci Numbers
  // This is simple. But inefficient. Call two recursive calls each time O(2^n)
  // 50th fibonacci # -> over a minute
  int fibonacci(int i) {
      if (i == 0) return 0;
      if (i == 1) return 1;
      return fibonacci(i-1) + fibonacci(i-2);
  }
  // Better fibonacci for O(N) by caching the results
  // 10'000th fibonacci # -> lass than a millisecond 
  int[] fib = new int[max];
  int fibonacci(int i) {
      if (i == 0) return 0;
      if (i == 1) return 1;
      if (fib[i] != 0) return fib[i]; // return cached result
      fib[i] = fibonacci(i-1) + fibonacci(i-2); // cache result
      return fib[i];
  }

  /**
   * Recursion vs Iterative Solutions
   * - Recursion can be very space inefficient. Each recursive call adds a new layer to the 
   * stack, which mean O(n) calls -> O(n) memory
   * - All recursive code can be implemented iteratively, although sometimes the code to do
   * so is much more complex. Discuss the trade-offs with the interviewer
   */