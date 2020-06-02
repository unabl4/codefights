// https://app.codesignal.com/challenge/WfKqwFfAXPKp3sgmM

int rangeBitCount(int a, int b) {
    int c = 0;
    for(int i=a; i <= b; i++) c += Integer.bitCount(i);
    return c;
}

