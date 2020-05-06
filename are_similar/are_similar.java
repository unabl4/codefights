// https://app.codesignal.com/challenge/if9FScKonZnQLrPYi

boolean areSimilar(int[] a, int[] b) {
    int A = a.length;
    int B = b.length;
    if(A != B) return false;

    boolean misMatchLimitReached = false;
    int[] Q = null; // mismatch "queue"
    for(int i=0; i < A; i++) {
        if(a[i] == b[i]) continue;  // the same

        if(misMatchLimitReached) return false;
        if(Q == null) {
            Q = new int[] { b[i], a[i] };
        } else {
            if(Q[0] == a[i] && Q[1] == b[i]) {
                Q = null;   // reset
                misMatchLimitReached = true;
            } else {
                return false;
            }
        }
    }


    return Q == null;
}
