/**
 * E.g Large array of person object, sort by increasing ages
 * 1. Large arrays, so efficiency is very important
 * 2. We are sorting based on ages, so we know the values are in a small range
 */

 /**
  * Bubble Sort
  * - O(n^2) average and worst case. Memory O(1)
  * - Swap the first two elements if the first is greater than second. Then we go to the next pair.
  */

  /**
   * Selection Sort
   * - Runtime: O(n^2) average and worst case. Memory O(1)
   * - Find the smallest element using a linear scan and move it to the front (swapping with that element).
   * Then find the second smallest, etc.
   */

   /**
    * Merge Sort
    * - Runtime: nLog(n) average and worst case. Memory: Depends
    * - Divide the array in half, sorts each of those halves, and then merges them back. Each half has the 
    * same sorting algorithn applied to it. Eventually you merge just single elements
    */
    void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high)/2;
            mergeSort(array,low,middle); // Sort left half
            mergeSort(array, middle+1, high); // Sort right half
            merge(array, low, middle, high); // Merge them
        }
    }

    void merge(int[] array, int low, int middle, int high) {
        int[] helper = new int[array.length];

        /* Copy both halves into a helper array */
        for (int i=low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        /* Iterate through helper array. Compare the left and right
         * half, copying back the smaller element from the two halves
         * into the original array
         */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else {
                // if the right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        /**
         * Copy the rest of the left side of the array into the target
         */
        int remaining = middle - helperLeft;
        for (int i=0; i <= remaining; i++) {
            array[current+i] = helper[helplerLeft+i];
        }
    }

    /** 
     * Quick Sort
     * - Runtime: O(nLog(n)) average, O(n^2) worst case. Memory: O(Log(n))
     * - Pick a random element and partition the array, such that all the numbers
     * are les than the partitioning element come before all elements that are 
     * greater than it. 
     */
    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // sort left half
            quickSort(arra, left, index-1);
        }
        if (index < right) { // sort right half
            quickSort(arr, index, right);
        }
    }
    
    int partition(int arr[], int left, int right) {
        int pivot = arr[(left+right)/2];
        while(left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }
            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }
            // swap elements and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    /** Radix Sort
     * - Runtime: O(kn)
     * - Radix sort is a sorting algo for integers that takes advantage of the
     * face that integers have a finite number of bits. In radix sort, we iterate
     * trough each digit of the number, grouping numbers by each digit. Then sort
     * each of these groupings by the next digit. we repeat this process sorting by 
     * each subsequent digit, until the whole array is sorted
     */

     /** Searching Algorithms!!!! */
    /** Binary Search
     * - Recursive half searching or normal
     */
    int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length-1;
        int mid;

        while (low <= high) {
            mid = (low <= high) / 2;
            if (a[mid] < x) {
                low = mid+1;
            }
            else if(a[mid] > x) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1; // error
    }

    int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1; // Error

        int mid = (low+high)/2;(
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid+1, high);
        }
        else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid-1);
        }
        else {
            return mid;
        }
    }