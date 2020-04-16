// https://app.codesignal.com/challenge/7YX8Fcyhxo62wBXoM

int arrayPacking(int[] a) {
    StringBuilder sb = new StringBuilder();
    for(int j=a.length-1; j >= 0; j--) {
        String b = String.format("%8s", Integer.toBinaryString(a[j])).replace(' ', '0');
        sb.append(b);
    }

    return Integer.parseInt(sb.toString(), 2);
}
