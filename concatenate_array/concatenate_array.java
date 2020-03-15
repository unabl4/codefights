// https://app.codesignal.com/challenge/4LpkxwykLc3Af5v5u

int[] concatenateArrays(int[] a, int[] b) {
    int[] c = new int[a.length+b.length];
    int i = 0;
    for(int A: a) c[i++] = A;
    for(int B: b) c[i++] = B;
    return c; 
}

