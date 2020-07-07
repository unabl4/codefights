// https://app.codesignal.com/challenge/ykEuaJg7JqDt4Ts9h

int[] removeArrayPart(int[] I, int l, int r) {
    int n = I.length;
    int[] o = new int[n-(r-l+1)];
    
    int t = 0;
    for(int i=0; i < n; i++) {
        if(i >= l && i <= r) continue;
        o[t++] = I[i];
    }
    
    return o;
}

