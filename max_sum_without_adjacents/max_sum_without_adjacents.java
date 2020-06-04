// https://app.codesignal.com/challenge/T6YifpP64NjsNxK7j

int maxSumWithoutAdjacents(int[] a) {
    int previousMax = 0;
    int currentMax = 0;
    
    for(int i: a) {        
        int max = Math.max(currentMax, previousMax + i);
        previousMax = currentMax;
        currentMax = max;
    }
    
    return currentMax;
}

