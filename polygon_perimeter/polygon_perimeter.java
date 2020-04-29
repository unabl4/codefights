// https://app.codesignal.com/challenge/BkPXssgpn7ZoDXhmD

int neighboursCount(boolean[][] M, int r, int c) {
    int n = 0;
    int H = M.length; // height
    int L = M[0].length;  // length

    if(r > 0 && M[r-1][c]) n++;
    if(r < H-1 && M[r+1][c]) n++;
    if(c > 0 && M[r][c-1]) n++;
    if(c < L-1 && M[r][c+1]) n++;

    return n;
}

int polygonPerimeter(boolean[][] M) {
    int H = M.length; // height
    int L = M[0].length;  // length

    int p = 0; // perimeter

    for(int r=0; r < H; r++) {
        for(int c=0; c < L; c++) {
            if(!M[r][c]) continue;  // white cell -> skip
            
            // black cell
            p += 4-neighboursCount(M,r,c);
        }
    }

    return p;
}
 
