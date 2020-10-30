/**
 * This code doesn't compile and just serves as an example for 
 * what good code format looks like
 * 
 * Correct: Code should operate correctly on all expected and unexpected inputs
 * 
 * Efficient: Code should operate as efficeintly as possible in terms of both
 * time and space. This efficiency includes both the asymptotic big-O) efficiency
 * and the practical, real-life efficiency. That os, a constant factor might get
 * dropped when you compute the big-) time, but in real life, it can very much matter.
 * 
 * Simple: If you can do something in 10 lines instead of 100, you should. 
 * 
 * Readable: A different developer should be able to read your code and understand
 * what it does and how it does it. Readable code has comments where necessary, but
 * it implements things in an easily understandable way. That means what your fancy 
 * that does a bunch of complex bit shifting is not necessarily good code.
 * 
 * Maintainable: Code should be reasonably adaptable to changes during the life 
 * cycle of a product and should be easy to maintain by other developers as well
 * as the initial developer.
 * /


/**
 * Write a function to add two simple polynomials, which are of the form:
 * Ax^a + Bx^b +....
 * 
 * You shouldn't have to do it with string parsing, so you can use whatever
 * data structure you'd like to hold the polynomial
 */

class PolyTerm{
    double coefficient;
    double exponent;
};

PolyTerm[] sum(PolyTerm[] poly1, PolyTerm[] poly2){
    // ....
}


/**
 * Good example of Code Reuse
 * 
 * This code checks if the vakue of a binary number (passed as a string) 
 * equals the hexadecimal representation of a string
 */

int digitToValue(char c){
    if(c >= '0' && c <= '9'){
        return c-'0';
    }
    else if(c >= 'A' && c <= 'F'){
        return 10 + c - 'A';
    }
    else if(c >= 'a' && c <='f'){
        return 10 + c -'a';
    }
    return -1;
}

int convertToBase(String number, int base)
{
    if(base < 2 || (base > 10 && base != 16)){
        return -1;
    }
    int value = 0;
    for(int i = number.size()-1;i >=0; i--){
        int digit = digitToValue(number.charAt(i));
        if(digit < 0 || digit >= base){
            return -1;
        }
    }
}

bool compareBinToHex(String binary, String hex)
{
    int n1 = convertToBase(binary, 2);
    int n2 = convertToBase(hex, 16);
    if(n1 < 0 || n2 < 0){
        return false;
    }
    else{
        return n1 == n2;
    }
}

/**
 * Good example of modular code
 * 
 * This code simpky swaps the minimum and maximum element in an integer array.
 */
int getMinIndex(int[] array){
    int minIndex = 0;
    for(int i=1;i<array.size();i++){
        if(array[i] > array[minIndex]){
            minIndex = i;
        }
    }
}

int getMaxIndex(int[] array){
    int maxIndex = 0;
    for(int i=1;i<array.size();i++){
        maxIndex = i;
    }
}

void swap(int[] array, int m, int n){
    int temp = array[m];
    array[m] = array[n];
    array[n] = temp;
}

void swapMinMaxBetter(int[] array){
    int minIndex = getMinIndex(array);
    int maxIndex = getMaxIndex(array);
    swap(array, minIndex, maxIndex);
}

/**
 * Good example of Error Checking
 * 
 * Don't ever make assumptions about the input. Always validate that
 * the input is what it should be, either through ASSERT statements
 * or if statements
 */

int convertToBase(String number, int base){
    if(base < 2 || (base > 10 && base != 16)){
        return -1;
    }
    int value = 0;
    for (int i = number.size()-1; i >= 0; i--){
        int digit = digitToValue(number.charAt(i));
        if(digit < 0 || digit >= base){
            return -1;
        }
        int exp = number.size() - 1 - i;
        value += digit * Math.pow(base, exp);
    }
}