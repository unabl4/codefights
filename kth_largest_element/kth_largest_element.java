// https://app.codesignal.com/challenge/A24ySg5gC8qHpxvnn

int kthLargestElement(int[] n, int k) {
    Arrays.sort(n);
    return n[n.length-k];
}

