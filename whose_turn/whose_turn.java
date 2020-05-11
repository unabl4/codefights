// https://app.codesignal.com/challenge/XFqYfTvSqG6EXAk7M

boolean whoseTurn(String p) {
    Boolean[] K = Stream.of(p.split(";")).map(i -> isOdd(i)).toArray(Boolean[]::new);  // knights

    boolean W = K[0] ^ K[1];    // white knights
    boolean B = K[2] ^ K[3];    // black knights
    return !(W ^ B);
}

boolean isOdd(String cell) {
    int A = (int)(cell.charAt(0)-'a')+1;
    int B = Character.getNumericValue(cell.charAt(1));
    return (A % 2) == (B % 2);
}
