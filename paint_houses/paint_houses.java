// https://app.codesignal.com/challenge/Ghp9hFN36aXXsPrpY

int paintHouses(int[][] C) {
    int N = C.length-1;
    
    for(int i=1; i <= N; i++) {
        C[i][0] += Math.min(C[i-1][1], C[i-1][2]);
        C[i][1] += Math.min(C[i-1][0], C[i-1][2]);
        C[i][2] += Math.min(C[i-1][0], C[i-1][1]);
    }
    
    return Math.min(Math.min(C[N][0], C[N][1]), C[N][2]);
}

