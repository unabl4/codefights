// https://app.codesignal.com/challenge/vEEEdKQa9NrKSrDbt

int additionWithoutCarrying(int A, int B) {
    int AL = L(A);
    int BL = L(B);
    int M = Math.max(AL,BL);

    int R = 0; // result

    for(int i=0; i < M; i++) {
        int t = 0;  // tmp

        if(i >= M-AL) {
            int pA = (int)Math.pow(10, AL-1);
            t += A / pA;
            A %= pA;    
            AL--;
        }

        if(i >= M-BL) {
            int pB = (int)Math.pow(10, BL-1);
            t += B / pB;
            B %= pB;    
            BL--;
        }

        t %= 10;
        R += t * Math.pow(10, M-i-1);
    }

    return R;
}

int L(int n) {
    return (int)(Math.floor(Math.log10(n))+1);
}
