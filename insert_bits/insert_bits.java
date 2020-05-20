// https://app.codesignal.com/challenge/XBjhCgyeeSjh4e5QD

int insertBits(int n, int a, int b, int k) {
    int L = b-a+1;  // bits
    int C = n & ~(((1<<L)-1) << a); // clear bit area
    return C | (k << a);   // put the k bits
}

