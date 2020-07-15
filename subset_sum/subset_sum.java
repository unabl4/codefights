// https://app.codesignal.com/challenge/Z2dD9dcsr6aDk2hyS

boolean subsetSum(int[] arr) {
    int S = 0;
    int N = arr.length;
    
    for(int i=0; i < N; i++) S += arr[i];
    if(S % 2 > 0) return false; // not possible to equally split anyway
    
    int T = S/2;    // half-sum
    
    boolean[][] B = new boolean[N+1][T+1];
    for(int i=0; i <= N; i++) B[i][0] = true;
    
    // DP
    for(int i=1; i <= N; i++) {
        for(int j=1; j <= T; j++) {
            B[i][j] = (j-arr[i-1] < 0) ? B[i-1][j] : (B[i-1][j] || B[i-1][j-arr[i-1]]);
        }
    }

    return B[N][T];
}

