// https://app.codesignal.com/challenges/page/1

String multiplyTwoStrings(String s1, String s2) {
    int a = s1.length();
    int b = s2.length();

    // number of digits
    int l = a+b;    // upper estimate
    int[] r = new int[l];   // zero-vector

    int c = 0;  // 0 <-> 1
    int s = 0;  // left offset
    for(int i=b-1; i >= 0; i--) {   // B
        int B = Character.getNumericValue(s2.charAt(i));
        for(int j=a-1; j >= 0; j--) {   // A
            int z = l-1-s-(a-1-j);    // plus offset
            int A = Character.getNumericValue(s1.charAt(j));
            int M = r[z]+(A*B+c);   // new value
            int R = M % 10; // digit-answer

            c = M / 10; // new carry
            r[z] = R;
        }

        // post loop MSB (MSD) correction
        if(c > 0) {
            r[l-s-a-1] += c;
            c = 0;  // reset
        }

        s++;    // increase the offset
    }

    // non-leading zero
    int t = 0;
    for(int i=0; i < l; i++) {
        if(r[i] > 0) {
            t = i;
            break;
        }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=t; i < l; i++) sb.append(Integer.toString(r[i]));

    return sb.toString();
}

