// https://app.codesignal.com/challenge/K7d4tLBrAH29JbhFi

int mapDecoding(String M) {
    int Z = 1000000007; // 10^9+7
    int L = M.length();
    if(L <= 0) return 1;    // empty string -> 1 valid decoding
    if(M.charAt(0) == '0') return 0;    // invalid

    int[] P = new int[L];

    P[0] = (M.charAt(L-1) == '0') ? 0 : 1;  // base case

    for(int i=1; i < L; i++) {
        int iC = L-1-i;  // number index
        int iP = iC+1;   // 'past' index

        char cC = M.charAt(iC);
        char cP = M.charAt(iP);
        int cPN = Character.getNumericValue(cP);

        // 00, 30, etc are not valid sequences -> cannot be decoded
        if((cC != '1' && cC != '2') && cP == '0') return 0;

        if(i == 1) {
            // second char decoding
            if((cC == '1' && cP != '0') || (cC == '2' && cPN > 0 && cPN < 7)) {
                P[i] = 2;   
            } else if(cC == '0') {
                P[i] = 0;
            } else {
                P[i] = 1;
            }

            continue;
        }

        if(cC == '0') {
            P[i] = 0; // reset
        } else if((cC == '1') || (cC == '2' && cPN > 0 && cPN < 7)) {
            P[i] = ((P[i-1] % Z) + (P[i-2] % Z)) % Z;   // mod trick
        } else {
            P[i] = P[i-1];
        }
    }

    // System.out.println(Arrays.toString(P));

    return P[L-1];
} 
