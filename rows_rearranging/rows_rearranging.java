// https://app.codesignal.com/challenge/nXRdoJZNJnvFDMiPk

boolean rowsRearranging(int[][] M) {
    // strictly increasing order = no duplicates allowed
    // introduce new array `pos`, where pos[x] = y, position of the X-th row (0-based)

    // we take the first column, "memoize" the original arragement, check for duplicates along the way, sort the array and find the correspondence between the row index and position (see above)

    // then we proceed checking the remaining columns, reading the row values in the established order and ensuring the "<" relation holds true; return false otherwise (incl. if duplicates) 

    int H = M.length;
    int W = M[0].length;

    int[] pos = new int[H]; 
    int[] firstCol = new int[H];
    
    Map<Integer, Integer> firstColSet = new HashMap<>();
    for(int i=0; i < H; i++) {
        if(firstColSet.containsKey(M[i][0])) return false; // duplicate -> not possible
        firstCol[i] = M[i][0];
        firstColSet.put(M[i][0],i);    // record the index
    }

    int[] firstColCopy = firstCol.clone();    // ?
    Arrays.sort(firstColCopy);  // -> sorted
    for(int i=0; i < H; i++) {
        pos[i] = firstColSet.get(firstColCopy[i]);
    }

    // checkColumns
    for(int j=1; j < W; j++) {
        if(!checkColumn(M,j,pos)) return false;
    }

    return true;    // -> possible
}

// check if the column valid
boolean checkColumn(int[][] M, int col, int[] pos) {
    int prev = -1;
    boolean init = false;
    for(int p: pos) {   // e.g: 2,0,1        
        if(init && !(M[p][col] > prev)) return false;
        init = true;
        prev = M[p][col];
    }

    return true;
}
