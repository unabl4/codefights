// https://app.codesignal.com/challenge/8ELyd5GpTxKSj3XFf

int[] switchLights(int[] a) {
    int N = a.length;

    for(int i=0; i < N; i++) {
        if(a[i] == 0) continue;

        for(int j=i; j >= 0; j--) {
            a[j] ^= 1;
        }
    }

    return a;
}

