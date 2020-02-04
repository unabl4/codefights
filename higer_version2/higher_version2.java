// https://app.codesignal.com/challenge/wdaNioTdYMMogFHeH

int higherVersion2(String a, String b) {
    Integer[] c = C(a);
    Integer[] d = C(b);
    
    int m = Math.min(c.length, d.length);   // common length

    for(int i=0; i < Math.max(c.length, d.length); i++) {        
        if(i >= c.length) { // 1.1 <=> 1.1.x
            return (d[i] == 0) ? 0 : -1;
        } else if(i >= d.length) {  // 1.1.x <=> 1.1
            return (c[i] == 0) ? 0 : 1;
        } else {    // 1.1.x <> 1.1.y
            if(i >= m) {    // outside the common length?
                return (c[i] > d[i]) ? 1 : -1; 
            } else {
                if(c[i] == d[i]) continue;
                return (c[i] > d[i]) ? 1 : -1; 
            }

        }
    }

    return 0;   // the same
}

Integer[] C(String s) {
    return Stream.of(s.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
}

