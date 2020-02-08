// https://app.codesignal.com/challenge/Cg7JueyPBNPfycb7x


// the idea is to find a longest common subseqence (LCS) between a string S and its "reverse" counterpart - S'
// let L = LCS(S,S'), where L is the length of the LCS
// Then the answer are looking for is if k >= (|S|-L), i.e MAX allowed(!) number of changes (deletions) is greater (gte) than MIN number of changes necessary to produce a palindrome  
boolean kpalindrome(String s, int k) {
    String r = new StringBuilder(s).reverse().toString();
    return k >= s.length()-LCS(s,r);
}

// a = abc, b = def
int LCS(String a, String b) {
    int N = a.length();
    int M = b.length();
    int[][] m = new int[N+1][M+1];
    
    for(int y=1; y <= M; y++) {
        for(int x=1; x <= N; x++) {
            if(a.charAt(x-1) == b.charAt(y-1)) {
                m[y][x] = 1+m[y-1][x-1];
            } else {
                m[y][x] = Math.max(m[y-1][x], m[y][x-1]);
            }
        }
    }

    return m[N][M];
}
